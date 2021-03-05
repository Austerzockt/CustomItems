package at.auster.customitems.api.items;

import at.auster.customitems.items.CustomItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemManager {
    public final List<CustomItem> items = new ArrayList<>();
    public ItemManager() {
    }
    public CustomItem getItem(Class<? extends CustomItem> clazz) {
        for (CustomItem s : items) {
            if (s.getClass().equals(clazz)) return s;

        }
        throw new NullPointerException("This Item doesn't exist: " + clazz.getSimpleName());
    }
    @SafeVarargs
    public final void load(Class<? extends CustomItem>... clazz) {
            Arrays.stream(clazz).forEach(i -> {
                try {
                    items.add((CustomItem) i.getConstructors()[0].newInstance());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });

    }

    // FIXME: 5/03/2021
    public final ItemStack createItemStack(Class<? extends CustomItem> type) {
        var item = getItem(type);
        ItemStack itemStack = new ItemStack(item.getMaterial(), item.isStackable() ? item.getMaterial().getMaxStackSize() : 1);
        var meta = itemStack.getItemMeta();
        //SET UNBREAKABLE
        if (item.isUnbreakable()) {
            meta.setUnbreakable(true);
        }
        if (item.hideEnchantments()) {
            if (!meta.hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
        }
        if (item.isEnchanted()) {
            meta.addEnchant(Enchantment.LUCK, 1,true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (item.getLore() != null) {
            itemStack.setLore(item.getLore());
        }
        if (item.getModelId() != 0) {
            meta.setCustomModelData(item.getModelId());
        }
        meta.displayName(Component.text(item.getItemStackName()));
        return itemStack;
    }

}
