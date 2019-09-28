package JHobbyEngine.math;

import java.util.Collection;

public class VectorFactory {
    public VectorFactory() {

    }

    public static <T extends Number> Vector<T> create(int numElements, Collection<T> initialElements) {
        switch (numElements) {
            case 2: {
                return new Vector2<T>(numElements, initialElements);
            }
        }
        return null;
    }
}
