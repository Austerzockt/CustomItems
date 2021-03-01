package at.auster.customitems;

import at.auster.customitems.api.AbstractCustomItemsAPI;
import at.auster.customitems.api.CustomItemsAPI;
import at.auster.customitems.utils.DependencyFilter;
import at.auster.customitems.utils.ReflectionUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.helpers.NOPLogger;


public final class CustomItems extends JavaPlugin {
    private static AbstractCustomItemsAPI customItemsAPI;
    public static CustomItems INSTANCE;



    @Override
    public void onEnable() {
        INSTANCE =this;
        customItemsAPI = new CustomItemsAPI();
        Bukkit.getLogger().setFilter(new DependencyFilter());
        getLogger().setFilter(new DependencyFilter());


    }

    public static AbstractCustomItemsAPI getAPI() {
        return customItemsAPI;
    }

    @Override
    public void onDisable() {
    }
}
