package JHobbyEngine.math;

import java.util.Collection;
import java.util.List;

public class Vector3<T extends Number> extends Vector2<T> {
    public Vector3() {
        super(3, (Collection<T>) List.of(0, 0), Vector3.class);
    }

    public Vector3(Collection<T> initialElements) {
        super(3, initialElements, Vector3.class);
    }

    protected Vector3(int numElements, Collection<T> initialElements, Class<? extends Vector> classType) {
        super(numElements, initialElements, classType);
    }

    public void setZ(T val) {
        this.set(2, val);
    }

    public T getZ() {
        return this.get(2);
    }
}
