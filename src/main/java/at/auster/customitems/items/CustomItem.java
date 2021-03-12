package at.auster.customitems.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.List;

public abstract class CustomItem {
    private String name = ChatColor.RED + "UNFINISHED " + this.getClass().getName();
    private String itemStackName = ChatColor.RED + "UNFINISHED " + this.getClass().getName();
    private boolean enchanted = false;
    private boolean canBreakBlocks = false;
    private int modelId = 0;
    private List<String> lore = null;
    private Material material = Material.DIRT;
    private boolean canBePlaced = false;
    private boolean unbreakable = false;
    private boolean stackable = false;
    private boolean hideEnchantments = false;

    public CustomItem() {
    }

    public abstract void onItemStackCreate(ItemStack itemStack);

    public abstract ShapedRecipe setRecipe(ShapedRecipe recipe);

    public abstract void leftClickAirAction(Player player, ItemStack itemStack);

    public abstract void leftClickBlockAction(Player player, PlayerInteractEvent playerInteractEvent, Block block,
            ItemStack itemStack);

    public abstract void rightClickAirAction(Player player, ItemStack itemStack);

    public abstract void rightClickBlockAction(Player player, PlayerInteractEvent playerInteractEvent, Block block,
            ItemStack itemStack);

    public abstract void shiftLeftClickAirAction(Player player, ItemStack itemStack);

    public abstract void shiftLeftClickBlockAction(Player player, PlayerInteractEvent playerInteractEvent, Block block,
            ItemStack itemStack);

    public abstract void shiftRightClickAirAction(Player player, ItemStack itemStack);

    public abstract void shiftRightClickBlockAction(Player player, PlayerInteractEvent playerInteractEvent, Block block,
            ItemStack itemStack);

    public abstract void hitEntityAction(Player player, EntityDamageByEntityEvent entityDamageByEntityEvent,
            Entity entity, ItemStack itemStack);

    public abstract void breakBlockAction(Player player, BlockBreakEvent blockBreakEvent, Block var3,
            ItemStack itemStack);

    // GETTERS

    public String getItemStackName() {
        return itemStackName;
    }

    public boolean hideEnchantments() {
        return hideEnchantments;
    }

    public List<String> getLore() {
        return lore;
    }

    public int getModelId() {
        return modelId;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean isEnchanted() {
        return enchanted;
    }

    public boolean canBePlaced() {
        return canBePlaced;
    }

    public boolean isStackable() {
        return stackable;
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }

    public boolean canBreakBlocks() {
        return canBreakBlocks;
    }
}
