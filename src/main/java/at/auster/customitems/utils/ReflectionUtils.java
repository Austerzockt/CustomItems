package at.auster.customitems.utils;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionUtils {
    private static final List<Class<? extends JavaPlugin>> urls = new ArrayList<>();


    public static boolean register(JavaPlugin plugin) {
        //urls.add(plugin.getClass());
        //update();
        return true;
    }


        /*Bukkit.getLogger().severe(String.valueOf("SIZE OF urls"+ urls.size()));
        urls.add(CustomItems.class);
        List<URL> urls1 = new ArrayList<>();
        List<ClassLoader> classLoaders = new ArrayList<>();
        urls.forEach( s-> {
            urls1.addAll(ClasspathHelper.forPackage(s.getPackage().getName()));

        });
        urls.forEach( s -> classLoaders.add(s.getClassLoader()));
        var builder = new ConfigurationBuilder();

        builder.addUrls(urls1);
        builder.setScanners(new SubTypesScanner());

        //reflections = new Reflections(urls1, classLoaders,new SubTypesScanner());
        reflections = new Reflections(builder);
        var x = reflections.getClass().getField("configuration");
    */


    public static  List<Class<? extends BaseReflectionable>> getAllClasses(Class<? extends BaseReflectionable> clazz) {
        try (ScanResult scanResult = new ClassGraph().acceptPackages("")
                .enableClassInfo().scan()) {
            return scanResult.getClassesImplementing(clazz.getName()).stream().map(s -> s.loadClass(clazz)).collect(Collectors.toList());
        }

    }
}
