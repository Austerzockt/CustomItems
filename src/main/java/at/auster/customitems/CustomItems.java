package at.auster.customitems;

import org.bukkit.plugin.java.JavaPlugin;

import at.auster.customitems.api.items.ItemManager;
import at.auster.customitems.utils.DebugLogger;

public class CustomItems extends JavaPlugin {
    private static ItemManager itemManager;

    @Override
    public void onEnable() {
        DebugLogger.init(getLogger());
        DebugLogger.isDebug = false;
        itemManager = new ItemManager();

    }

    public static ItemManager getItemManager() {
        return itemManager;
    }
}
