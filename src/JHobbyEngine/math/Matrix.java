package JHobbyEngine.math;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Matrix<T extends Number> {
    private final Class<T> elementType;
    T[][] elements;
    int rows = 0;
    int cols = 0;

    protected Matrix(int rows, int columns, T[][] elements, Class<T> elementType, Class<? extends Matrix> classType) {
        this.elementType = elementType;
        this.rows = rows;
        this.cols = columns;
        this.elements = elements;

        // TODO: Verify the length of elements correlates with cols and rows

        MatrixFactory.instance().registerClass(this.getFactoryKey(), classType);
    }

    private String getFactoryKey() {
        return String.valueOf(this.rows) + String.valueOf(this.cols);
    }

    public Matrix<T> add(Matrix<T> other) {
       T[][] newElements = (T[][]) Array.newInstance(this.elementType, this.rows, this.cols);
       for (int i = 0; i < this.rows; i++) {
           for (int j = 0; j < this.cols; j++) {
               newElements[i][j] = NumberUtilities.add(this.elements[i][j], other.elements[i][j]);
           }
       }
       return (Matrix<T>) MatrixFactory.instance().create(this.getFactoryKey(), newElements);
    }

    public Matrix<T> subtract(Matrix<T> other) {
        T[][] newElements = (T[][]) Array.newInstance(this.elementType, this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                newElements[i][j] = NumberUtilities.subtract(this.elements[i][j], other.elements[i][j]);
            }
        }
        return (Matrix<T>) MatrixFactory.instance().create(this.getFactoryKey(), newElements);
    }

    public Matrix<T> scale(T scalar) {
        T[][] newElements = (T[][]) Array.newInstance(this.elementType, this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                newElements[i][j] = NumberUtilities.multiply(this.elements[i][j], scalar);
            }
        }
        return (Matrix<T>) MatrixFactory.instance().create(this.getFactoryKey(), newElements);
    }
}
