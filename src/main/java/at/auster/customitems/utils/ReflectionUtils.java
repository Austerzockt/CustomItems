package at.auster.customitems.utils;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtils implements Initable{
    private static final List<String> urls = new ArrayList<>();

    private static Reflections reflections;

    public static Reflections getReflections() {
        return reflections;
    }
    public static boolean register(String url) {
        return urls.add(url);
    }

    @Override
    public void init() {

        reflections = new Reflections(new ConfigurationBuilder().addScanners(new SubTypesScanner()).setUrls(urls.stream().map(ClasspathHelper::forPackage).map(s -> s.iterator().next()).collect(Collectors.toList())));
    }
    public static List<? extends BaseReflectionable> getAllClasses(Class<? extends BaseReflectionable> clazz) {
         return reflections.getSubTypesOf(clazz).stream().map(clazz::cast).collect(Collectors.toList());
    }
}
