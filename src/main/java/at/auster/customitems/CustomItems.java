package at.auster.customitems;

import at.auster.customitems.api.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItems extends JavaPlugin {
    private static ItemManager itemManager;

    @Override
    public void onEnable() {
        itemManager = new ItemManager();
    }

    public static ItemManager getItemManager() {
        return itemManager;
    }
}
