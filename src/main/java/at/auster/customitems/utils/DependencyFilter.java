package at.auster.customitems.utils;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class DependencyFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return !record.getMessage().contains("which is not a depend, softdepend or loadbefore of this plugin");
    }
}
