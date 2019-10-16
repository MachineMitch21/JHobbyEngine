package JHobbyEngine.math;

public class Vector2f {

    private float x;
    private float y;

    public void set(int index, float val) {
        switch (index) {
            case 0: this.x = val;
            case 1: this.y = val;
        }
    }

    public float get(int index) {
        switch (index) {
            case 0: return this.x;
            case 1: return this.y;
            default: return 0;
        }
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f(Vector2f copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    public static Vector2f add(Vector2f l, Vector2f r) {
        return new Vector2f(l.x + r.x, l.y + r.y);
    }

    public static Vector2f subtract(Vector2f l, Vector2f r) {
        return new Vector2f(l.x - r.x, l.y - r.y);
    }

    public static Vector2f scale(Vector2f v, float scalar) {
        return new Vector2f(v.x * scalar, v.y * scalar);
    }

    public static float magnitude(Vector2f v) {
        return (float) Math.sqrt(Math.pow(v.x, 2) + Math.pow(v.y, 2));
    }

    public static Vector2f normalize(Vector2f v) {
        float m = Vector2f.magnitude(v);
        return new Vector2f(v.x / m, v.y / m);
    }

    public static float dot(Vector2f l, Vector2f r) {
        return (float) l.x * r.x + l.y * r.y;
    }

    public String toString() {
        return String.format("{ %f, %f }", this.x, this.y);
    }

    public boolean equals(Vector2f other) {
        return (this.x == other.x && this.y == other.y);
    }
}
