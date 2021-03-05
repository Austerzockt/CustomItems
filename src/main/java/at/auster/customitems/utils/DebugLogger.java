package at.auster.customitems.utils;


import java.util.logging.Logger;

public class DebugLogger {
    private static Logger logger;
    public static boolean isDebug = false;
    public static void init(Logger logger) {
        DebugLogger.logger = logger;
    }
    public static void debug(String message) {
        if (isDebug) logger.severe(message);
    }
}
