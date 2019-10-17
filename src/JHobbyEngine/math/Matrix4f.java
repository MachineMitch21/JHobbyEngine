package JHobbyEngine.math;

import java.util.Arrays;

public class Matrix4f {
	private float[] elements;

	public Matrix4f(float diag) {
		this.elements = new float[16];
		this.elements[0] = diag;
		this.elements[4] = diag;
		this.elements[8] = diag;
		this.elements[12] = diag;
	}

	public Matrix4f(float[] elements) {
		if (elements.length != 16) {
			System.exit(-1);
		}
		this.elements = elements;
	}

	public Matrix4f(float r0c0, float r0c1, float r0c2, float r0c3,
									float r1c0, float r1c1, float r1c2, float r1c3,
									float r2c0, float r2c1, float r2c2, float r2c3,
									float r3c0, float r3c1, float r3c2, float r3c3) {
		this.elements = new float[] {
		        r0c0, r0c1, r0c2, r0c3,
                r1c0, r1c1, r1c2, r1c3,
                r2c0, r2c1, r2c2, r2c3,
                r3c0, r3c1, r3c2, r3c3
        };
	}

	public void set(int row, int col, float val) {
		this.elements[row * 4 + col] = val;
	}

	public float get(int row, int col) {
		return this.elements[row * 4 + col];
	}

	public static Matrix4f add(Matrix4f l, Matrix4f r) {
		float[] newElements = new float[16];
		for (int i = 0; i < l.elements.length; i++) {
			newElements[i] = l.elements[i] + r.elements[i];
		}
		return new Matrix4f(newElements);
	}

	public static Matrix4f subtract(Matrix4f l, Matrix4f r) {
		float[] newElements = new float[16];
		for (int i = 0; i < l.elements.length; i++) {
			newElements[i] = l.elements[i] - r.elements[i];
		}
		return new Matrix4f(newElements);
	}

	public static Matrix4f scale(Matrix4f mat, float scalar) {
		float[] newElements = new float[16];
		for (int i = 0; i < mat.elements.length; i++) {
			newElements[i] = mat.elements[i] * scalar;
		}
		return new Matrix4f(newElements);
	}

	public static Matrix4f multiply(Matrix4f l, Matrix4f r) {
		Matrix4f result = new Matrix4f(1.0f);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				float sum = 0.0f;
				for (int k = 0; k < 4; k++) {
					sum += l.get(i, k) * r.get(k, j);
				}
				result.set(i, j, sum);
			}
		}
		return result;
	}

	public static Vector4f multiply(Matrix4f l, Vector4f r) {
		Vector4f result = new Vector4f();
		for (int i = 0; i < 4; i++) {
			float sum = 0.f;
			for (int j = 0; j < 4; j++) {
				sum += l.get(i, j) * r.get(j);
			}
			result.set(i, sum);
		}
		return result;
	}

	public static Vector3f multiply(Matrix4f l, Vector3f r) {
		Vector4f result = Matrix4f.multiply(l, new Vector4f(r.getX(), r.getY(), r.getZ(), 1.f));
		return new Vector3f(result.getX(), result.getY(), result.getZ());
	}

	public boolean equals(Matrix4f other) {
		return Arrays.equals(this.elements, other.elements);
	}
}