package JHobbyEngine.math;

public class Matrix4f {
	private float[] elements;

	protected Matrix4f(float[] elements) {
		if (elements.length != this.elements.length) {
			System.exit(-1);
		}
		this.elements = elements;
	}

	public Matrix4f(float r0c0, float r0c1, float r0c2, float r0c3,
									float r1c0, float r1c1, float r1c2, float r1c3,
									float r2c0, float r2c1, float r2c2, float r2c3,
									float r3c0, float r3c1, float r3c2, float r3c3) {
		this.elements = new float[16];
		this.elements[0] = r0c0;
		this.elements[1] = r0c1;
		this.elements[2] = r0c2;
		this.elements[3] = r0c3;
		this.elements[4] = r1c0;
		this.elements[5] = r1c1;
		this.elements[6] = r1c2;
		this.elements[7] = r1c3;
		this.elements[8] = r2c0;
		this.elements[9] = r2c1;
		this.elements[10] = r2c2;
		this.elements[11] = r2c3;
		this.elements[12] = r3c0;
		this.elements[13] = r3c1;
		this.elements[14] = r3c2;
		this.elements[15] = r3c3;
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
}