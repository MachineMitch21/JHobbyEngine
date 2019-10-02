package JHobbyEngine.math;

import JHobbyEngine.util.GenericFactory;

public class VectorFactory extends GenericFactory<Integer, Vector> {

    private static VectorFactory instance = new VectorFactory();

    public static VectorFactory instance() {
        return instance;
    }
}
