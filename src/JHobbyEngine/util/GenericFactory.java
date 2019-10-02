package JHobbyEngine.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class GenericFactory<T, U> {

    private HashMap<T, Class<? extends U>> registeredClasses = new HashMap<>();

    public void registerClass(T key, Class<? extends U> classType) {
        this.registeredClasses.put(key, classType);
    }

    public U create(T key, Object... args) {
        Class<? extends U> factoryClass = this.registeredClasses.get(key);
        U obj = null;
        try {
            Constructor<? extends U> ctor = factoryClass.getDeclaredConstructor(new Class[]{});
            obj = ctor.newInstance(args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
