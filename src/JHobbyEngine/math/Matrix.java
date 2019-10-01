package JHobbyEngine.math;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Matrix<T extends Number> {
    private final Class<T> elementType;
    T[][] elements;
    int rows = 0;
    int cols = 0;

    protected Matrix(int rows, int columns, T[][] elements, Class<T> elementType) {
        this.elementType = elementType;
        this.rows = rows;
        this.cols = columns;
        this.elements = elements;
    }

//    public Matrix<T> add(Matrix<T> other) {
//        T[][] newElements = (T[][]) Array.newInstance(this.elementType, this.rows, this.cols);
//        for (int i = 0; i < this.rows; i++) {
//            for (int j = 0; j < this.cols; j++) {
//                newElements[i][j] = NumberUtilities.add(this.elements[i][j], other.elements[i][j]);
//            }
//        }
//    }
}
