package at.auster.customitems;

import at.auster.customitems.api.AbstractCustomItemsAPI;
import at.auster.customitems.api.CustomItemsAPI;
import org.bukkit.plugin.java.JavaPlugin;


public final class CustomItems extends JavaPlugin {
    private  AbstractCustomItemsAPI customItemsAPI; 
    @Override
    public void onEnable() {
    customItemsAPI = new CustomItemsAPI();


    }

    public AbstractCustomItemsAPI getAPI() {
        return customItemsAPI;
    }

    @Override
    public void onDisable() {
    }
}
