package oodcloud.tomcat.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyujie
 * @ClassName ParameterMap
 * @Description
 * @date 2019/7/17 0017
 */
public class ParameterMap extends HashMap {
    public ParameterMap() {
        super ();
    }
    public ParameterMap(int initialCapacity) {
        super(initialCapacity);
    }
    public ParameterMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }
    public ParameterMap(Map map) {
        super(map);
    }
    private boolean locked = false;
    public boolean isLocked() {
        return (this.locked);
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    private static final StringManager sm =
            StringManager.getManager("oodcloud.tomcat.util");

    @Override
    public void clear() {
        if (locked)
            throw new IllegalStateException
                    (sm.getString("parameterMap.locked"));
        super.clear();
    }
    @Override
    public Object put(Object key, Object value) {
        if (locked)
            throw new IllegalStateException
                    (sm.getString("parameterMap.locked"));
        return (super.put(key, value));
    }
    @Override
    public void putAll(Map map) {
        if (locked)
            throw new IllegalStateException
                    (sm.getString("parameterMap.locked"));
        super.putAll(map);
    }
    @Override
    public Object remove(Object key) {
        if (locked)
            throw new IllegalStateException
                    (sm.getString("parameterMap.locked"));
        return (super.remove(key));
    }

}
