package JHobbyEngine.math;

public class Vector4f extends Vector3f {

    protected Vector4f(float[] initialElements, Class<? extends Vector4f> type) {
        super(initialElements, type);
    }

    protected Vector4f(float[] initialElements) {
        super(initialElements, Vector4f.class);
    }

    public Vector4f(float x, float y, float z, float w) {
        super(new float[]{x, y, z, w}, Vector4f.class);
    }

    public void setW(float w) {
        this.elements[3] = w;
    }

    public float getW() {
        return this.elements[3];
    }
}
