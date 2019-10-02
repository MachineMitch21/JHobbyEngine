package JHobbyEngine.math;

import JHobbyEngine.util.GenericFactory;

public class MatrixFactory extends GenericFactory<String, Matrix> {

    private static MatrixFactory instance = new MatrixFactory();

    public static MatrixFactory instance() {
        return instance;
    }
}