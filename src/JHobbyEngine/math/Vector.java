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

        VectorFactory.instance().registerVector(numElements, classType);
    }

    public Vector<T> add(Vector<T> other) {
        ArrayList<T> newElements = new ArrayList<>(this.elements.size());
        for (int i = 0; i < this.elements.size(); i++) {
            newElements.set(i, NumberUtilities.add(this.elements.get(i), other.elements.get(i)));
        }
        return (Vector<T>) VectorFactory.instance().create(Integer.valueOf(this.capacity), newElements);
    }

    public Vector<T> subtract(Vector<T> other) {
        ArrayList<T> newElements = new ArrayList<>(this.elements.size());
        for (int i = 0; i < this.elements.size(); i++) {
            newElements.set(i, NumberUtilities.subtract(this.elements.get(i), other.elements.get(i)));
        }
        return (Vector<T>) VectorFactory.instance().create(Integer.valueOf(this.capacity), newElements);
    }

    public void set(int index, T val) {
        this.elements.set(index, val);
    }

    public T get(int index) {
        return this.elements.get(index);
    }

    public Iterator<T> getIterator() {
        return this.elements.iterator();
    }
}
