package at.auster.customitems;

import at.auster.customitems.api.items.ItemManager;
import at.auster.customitems.utils.DebugLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Debug;

import javax.swing.*;

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
