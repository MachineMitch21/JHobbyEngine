package JHobbyEngine.math;

public class Vector3f extends Vector2f {

    protected Vector3f(float[] initialElements, Class<? extends Vector3f> type) {
        super(initialElements, type);
    }

    protected Vector3f(float[] initialElements) {
        super(initialElements, Vector3f.class);
    }

    public Vector3f(float x, float y, float z) {
        super(new float[]{x, y, z}, Vector3f.class);
    }

    public void setZ(float z) {
        this.elements[2] = z;
    }

    public float getZ() {
        return this.elements[2];
    }
}
