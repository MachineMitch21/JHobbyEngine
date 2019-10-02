package JHobbyEngine.math;

public class Matrix4<T extends Number> extends Matrix<T> {
	protected Matrix4(int rows, int columns, T[][] elements, Class<T> elementType) {
		super(rows, columns, elements, elementType);
	}
}