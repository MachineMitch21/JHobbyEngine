package JHobbyEngine.math;

import java.util.Collection;
import java.util.List;

public class Vector2<T extends Number> extends Vector<T> {
    public Vector2() {
        super(2, (Collection<T>) List.of(0, 0));
    }

    public Vector2(Collection<T> initialElements) {
        super(2, initialElements);
    }

    protected Vector2(int numElements, Collection<T> initialElements) {
        super(numElements, initialElements);
    }
}
