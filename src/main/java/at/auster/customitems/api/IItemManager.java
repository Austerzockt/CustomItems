package at.auster.customitems.api;

import at.auster.customitems.items.CustomItem;

public interface IItemManager {
    public CustomItem getItem(Class<? extends CustomItem> clazz);
    public void init();
}
