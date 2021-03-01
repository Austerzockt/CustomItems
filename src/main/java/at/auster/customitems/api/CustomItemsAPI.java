package at.auster.customitems.api;

import at.auster.customitems.utils.BaseReflectionable;
import at.auster.customitems.utils.ReflectionUtils;

import java.util.List;

public class CustomItemsAPI extends AbstractCustomItemsAPI{

    @Override
    public boolean registerPackage(String url) {
        if (canRegister) {
            return ReflectionUtils.register(url);

        }
        throw new IllegalStateException("Packages for Commands and Items Can Only Be Registered In onLoad()");
    }

    @Override
    void stopRegistering() {
        canRegister = false;
    }

}
