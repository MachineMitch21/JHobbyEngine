package JHobbyEngine.math;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class VectorFactory {

    private static VectorFactory instance = new VectorFactory();

    public static VectorFactory instance() {
        return instance;
    }

    private HashMap<Integer, Class<? extends Vector>> registeredClasses = new HashMap<>();

    public void registerVector(Integer capacity, Class<? extends Vector> classType) {
        registeredClasses.put(capacity, classType);
    }

    public Vector<? extends Number> create(Integer capacity, Collection<? extends Number> initialElements) {
        Class<? extends Vector> factoryClass = registeredClasses.get(capacity);
        Vector<? extends Number> obj = null;
        try {
            Constructor<? extends Vector> ctor = factoryClass.getDeclaredConstructor(new Class[] { });
            obj = ctor.newInstance(new Object[] { capacity, initialElements });
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
