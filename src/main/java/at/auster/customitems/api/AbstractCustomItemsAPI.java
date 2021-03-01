package at.auster.customitems.api;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractCustomItemsAPI {
    protected boolean canRegister = true;
    public abstract boolean registerPackage(JavaPlugin javaPlugin);
    public abstract void stopRegistering();
}
