package JHobbyEngine.math;

public class Vector4f {

    private float x;
    private float y;
    private float z;
    private float w;

    public Vector4f() {
        this.x = 0.f;
        this.y = 0.f;
        this.z = 0.f;
        this.w = 0.f;
    }

    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4f(Vector4f copy) {
        this.x = copy.x;
        this.y = copy.y;
        this.z = copy.z;
        this.w = copy.w;
    }

    public void set(int index, float val) {
        switch (index) {
            case 0: this.x = val;
            case 1: this.y = val;
            case 2: this.z = val;
            case 3: this.w = val;
        }
    }

    public float get(int index) {
        switch (index) {
            case 0: return this.x;
            case 1: return this.y;
            case 2: return this.z;
            case 3: return this.w;
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

    public void setW(float w) {
        this.w = w;
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

    public float getW() {
        return w;
    }

    public static float dist(Vector4f l, Vector4f r) {
        return Vector4f.magnitude(Vector4f.subtract(l, r));
    }

    public static Vector4f add(Vector4f l, Vector4f r) {
        return new Vector4f(l.x + r.x, l.y + r.y, l.z + r.z, l.w + r.w);
    }

    public static Vector4f subtract(Vector4f l, Vector4f r) {
        return new Vector4f(l.x - r.x, l.y - r.y, l.z - r.z, l.w - r.w);
    }

    public static Vector4f scale(Vector4f v, float scalar) {
        return new Vector4f(v.x * scalar, v.y * scalar, v.z * scalar, v.w * scalar);
    }

    public static float magnitude(Vector4f v) {
        return (float) Math.sqrt(Math.pow(v.x, 2) + Math.pow(v.y, 2) + Math.pow(v.z, 2) + Math.pow(v.w, 2));
    }

    public static Vector4f normalize(Vector4f v) {
        float m = Vector4f.magnitude(v);
        return new Vector4f(v.x / m, v.y / m, v.z / m, v.w / m);
    }

    public static float dot(Vector4f l, Vector4f r) {
        return (float) l.x * r.x + l.y * r.y + l.z * r.z + l.w * r.w;
    }

    public String toString() {
        return String.format("{ %f, %f, %f, %f }", this.x, this.y, this.z, this.w);
    }

    public boolean equals(Vector4f other) {
        return (this.x == other.x && this.y == other.y && this.z == other.z && this.w == other.w);
    }
}
