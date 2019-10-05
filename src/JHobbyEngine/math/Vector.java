package JHobbyEngine.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class Vector<T extends Number> {
    private ArrayList<T> elements;
    private final int capacity;

    protected Vector(int numElements, Collection<T> initialElements, Class<? extends Vector> classType) {
        this.capacity = numElements;
        this.elements = new ArrayList<T>(numElements);
        T[] arr = (T[])initialElements.toArray();
        // Only copy elements up to capacity
        for (int i = 0; i < this.capacity; i++) {
            this.elements.set(i, arr[i]);
        }

        VectorFactory.instance().registerClass(numElements, classType);
    }

    public Vector<T> add(Vector<T> other) {
        ArrayList<T> newElements = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) {
            newElements.set(i, NumberUtilities.add(this.elements.get(i), other.elements.get(i)));
        }
        return (Vector<T>) VectorFactory.instance().create(Integer.valueOf(this.capacity), newElements);
    }

    public Vector<T> subtract(Vector<T> other) {
        ArrayList<T> newElements = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) {
            newElements.set(i, NumberUtilities.subtract(this.elements.get(i), other.elements.get(i)));
        }
        return (Vector<T>) VectorFactory.instance().create(Integer.valueOf(this.capacity), newElements);
    }

    public float magnitude() {
        float mag = 0.0f;
        for (int i = 0; i < this.capacity; i++) {
            mag += (float) (Math.pow(this.elements.get(i).doubleValue(), 2));
        }
        return (float) Math.sqrt(mag);
    }

    public Vector<T> normalize() {
        float m = this.magnitude();
        ArrayList<T> newElements = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) {
            newElements.set(i, (T) Float.valueOf(this.elements.get(i).floatValue() / m));
        }
        return (Vector<T>) VectorFactory.instance().create(Integer.valueOf(this.capacity), newElements);
    }
    
    public Vector<T> scale(T scalar) {
        ArrayList<T> newElements = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) {
            newElements.set(i, NumberUtilities.multiply(this.elements.get(i), scalar));
        }
        return (Vector<T>) VectorFactory.instance().create(Integer.valueOf(this.capacity), newElements);
    }

    public T dot(Vector<T> other) {
        Vector<T> v1Normalized = this.normalize();
        Vector<T> otherNormalized = other.normalize();
        T dot = (T) Integer.valueOf(0);
        for (int i = 0; i < this.capacity; i++) {
            dot = NumberUtilities.add(dot, NumberUtilities.multiply(v1Normalized.get(i), otherNormalized.get(i)));
        }
        return dot;
    }

    protected void set(int index, T val) {
        this.elements.set(index, val);
    }

    protected T get(int index) {
        return this.elements.get(index);
    }

    public int getCapacity() { return this.capacity; }

    public Iterator<T> getIterator() {
        return this.elements.iterator();
    }
}
