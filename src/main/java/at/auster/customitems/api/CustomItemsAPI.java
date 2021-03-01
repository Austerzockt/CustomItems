package at.auster.customitems.api;

import at.auster.customitems.CustomItems;
import at.auster.customitems.utils.BaseReflectionable;
import at.auster.customitems.utils.ReflectionUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class CustomItemsAPI extends AbstractCustomItemsAPI{

    @Override
    public boolean registerPackage(JavaPlugin javaPlugin) {
        if (canRegister) {
            return ReflectionUtils.register(javaPlugin);

        }
        throw new IllegalStateException("Packages for Commands and Items Can Only Be Registered In onLoad()");
    }

    @Override
    public void stopRegistering() {
        canRegister = false;
    }

}
