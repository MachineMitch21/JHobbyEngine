package JHobbyEngine.math;

public class Vector2f extends Vectorf {

    protected Vector2f(float[] initialElements, Class<? extends Vector2f> type) {
        super(initialElements, type);
    }

    public Vector2f(float[] initialElements) {
        super(initialElements, Vector2f.class);
    }

    public Vector2f(float x, float y) {
        super(new float[]{x, y}, Vector2f.class);
    }

    public void setX(float x) {
        this.elements[0] = x;
    }

    public void setY(float y) {
        this.elements[1] = y;
    }

    public float getX() {
        return this.elements[0];
    }

    public float getY() {
        return this.elements[1];
    }
}
