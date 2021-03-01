package at.auster.customitems.api;

public abstract class AbstractCustomItemsAPI {
    protected boolean canRegister = false;
    abstract boolean registerPackage(String url);
    abstract void stopRegistering();
}
