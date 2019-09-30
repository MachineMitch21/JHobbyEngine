package JHobbyEngine.math;

import java.util.ArrayList;

public abstract class Matrix<T extends Number> {
    T[][] elements;
    int rows = 0;
    int cols = 0;

    protected Matrix(int rows, int columns, T[][] elements) {
        this.rows = rows;
        this.cols = columns;
        this.elements = elements;
    }
}
