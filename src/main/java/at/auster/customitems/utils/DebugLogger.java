package at.auster.customitems.utils;

import java.util.logging.Logger;

import org.bukkit.block.data.type.BubbleColumn;

public class DebugLogger {
    private static Logger logger;
    public static boolean isDebug = false;

    public static void init(Logger logger) {
        DebugLogger.logger = logger;
    }

    public static void debug(Class<?> clazz, String message) {
        if (isDebug) {
            StringBuilder builder = new StringBuilder();
            builder.append("[").append(clazz.getSimpleName()).append("] ").append(message);
            logger.severe(builder.toString().trim());
        }
            
    }
}
