package JHobbyEngine.math;

import JHobbyEngine.util.GenericFactory;

public class VectorfFactory extends GenericFactory<Vectorf, Vectorf> {
    public static VectorfFactory instance = new VectorfFactory();
    public static VectorfFactory instance() {
        return instance;
    }
}
