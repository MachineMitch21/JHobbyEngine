package JHobbyEngine.math;

public class Vector3f {

    private float x;
    private float y;
    private float z;

    public void set(int index, float val) {
        switch (index) {
            case 0: this.x = val;
            case 1: this.y = val;
            case 2: this.z = val;
        }
    }

    public float get(int index) {
        switch (index) {
            case 0: return this.x;
            case 1: return this.y;
            case 2: return this.z;
            default: return 0;
        }
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(Vector3f copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
    }

    public static Vector3f add(Vector3f l, Vector3f r) {
        return new Vector3f(l.x + r.x, l.y + r.y, l.z + r.z);
    }

    public static Vector3f subtract(Vector3f l, Vector3f r) {
        return new Vector3f(l.x - r.x, l.y - r.y, l.z - r.z);
    }

    public static Vector3f scale(Vector3f v, float scalar) {
        return new Vector3f(v.x * scalar, v.y * scalar, v.z * scalar);
    }

    public static float magnitude(Vector3f v) {
        return (float) Math.sqrt(Math.pow(v.x, 2) + Math.pow(v.y, 2) + Math.pow(v.z, 2));
    }

    public static Vector3f normalize(Vector3f v) {
        float m = Vector3f.magnitude(v);
        return new Vector3f(v.x / m, v.y / m, v.z / m);
    }

    public static float dot(Vector3f l, Vector3f r) {
        return (float) l.x * r.x + l.y * r.y + l.z * r.z;
    }

    public String toString() {
        return String.format("{ %f, %f, %f }", this.x, this.y, this.z);
    }

    public boolean equals(Vector3f other) {
        return (this.x == other.x && this.y == other.y && this.z == other.z);
    }
}
