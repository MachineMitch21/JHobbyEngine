package JHobbyEngine.math;

import java.util.Collection;
import java.util.List;

public class Vector4<T extends Number> extends Vector3<T> {
    public Vector4() {
        super(4, (Collection<T>) List.of(0, 0, 0, 0), Vector4.class);
    }

    public Vector4(Collection<T> initialElements) {
        super(4, initialElements, Vector4.class);
    }

    protected Vector4(int capacity, Collection<T> initialElements, Class<? extends Vector> classType) {
        super(capacity, initialElements, classType);
    }

    public void setW(T val) {
        this.set(3, val);
    }

    public T getW() {
        return this.get(3);
    }
}
