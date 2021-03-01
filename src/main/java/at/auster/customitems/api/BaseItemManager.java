package at.auster.customitems.api;

import at.auster.customitems.api.IItemManager;
import at.auster.customitems.items.CustomItem;

import java.util.ArrayList;
import java.util.List;

public class BaseItemManager implements IItemManager {
    public final List<CustomItem> items = new ArrayList<>();

    public CustomItem getItem(Class<? extends CustomItem> clazz) {
        for (CustomItem s : items) {
            if (s.getClass().equals(clazz)) return s;
        }
        return null;
    }

    @Override
    public void init() {

    }
}
