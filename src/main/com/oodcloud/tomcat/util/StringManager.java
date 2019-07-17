package oodcloud.tomcat.util;

import java.util.Hashtable;
import java.util.ResourceBundle;

/**
 * @author wangyujie
 * @ClassName StringManager
 * @Description
 * @date 2019/7/16 0016
 */
public class StringManager {
    private static Hashtable<String,StringManager> manager = new Hashtable();
    private String packageName;
    private ResourceBundle resourceBundle;
    private StringManager(String packageName) {
        this.packageName = packageName;
    }

    private StringManager() {
    }

    public static synchronized StringManager getManager(String packageName) {
        StringManager stringManager = manager.get(packageName);
        if (stringManager == null) {
            stringManager = new StringManager(packageName);
            manager.put(packageName,stringManager);
        }
        return stringManager;
    }

    public String getString(String s) {
        return null;
    }
}
