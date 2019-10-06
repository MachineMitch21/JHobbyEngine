package JHobbyEngine.math;

public class Vectorf {
    protected float[] elements;
    private Class<? extends Vectorf> type;
    protected Vectorf(float[] initialElements, Class<? extends Vectorf> type) {
        elements = initialElements;
        this.type = type;
    }

    public Vectorf(Vectorf copy) {
        this.elements = copy.elements;
    }

    public static Vectorf add(Vectorf l, Vectorf r) {
        float[] elements = new float[l.elements.length];
        for (int i = 0; i < l.elements.length; i++) {
            elements[i] = l.elements[i] + r.elements[i];
        }
        return new Vectorf(elements, l.type);
    }

    public static Vectorf subtract(Vectorf l, Vectorf r) {
        float[] elements = new float[l.elements.length];
        for (int i = 0; i < l.elements.length; i++) {
            elements[i] = l.elements[i] - r.elements[i];
        }
        return new Vectorf(elements, l.type);
    }

    public static Vectorf scale(Vectorf l, float scalar) {
        float[] elements = new float[l.elements.length];
        for (int i = 0; i < l.elements.length; i++) {
            elements[i] = l.elements[i] * scalar;
        }
        return new Vectorf(elements, l.type);
    }

    public float magnitude() {
        float m = 0.0f;
        for (int i = 0; i < this.elements.length; i++) {
            m += Math.pow(this.elements[i], 2);
        }
        return (float) Math.sqrt(m);
    }

    public static Vectorf normalize(Vectorf v) {
        float m = v.magnitude();
        float[] elements = new float[v.elements.length];
        for (int i = 0; i < v.elements.length; i++) {
            elements[i] = v.elements[i] / m;
        }
        return new Vectorf(elements, v.type);
    }

    public static float dot(Vectorf l, Vectorf r) {
        float d = 0.0f;
        for (int i = 0; i < l.elements.length; i++) {
            d += l.elements[i] * r.elements[i];
        }
        return d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < this.elements.length; i++) {
            sb.append(this.elements[i]);
            if (i != this.elements.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }
}
