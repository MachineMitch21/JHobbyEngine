package JHobbyEngine.math;

import java.math.BigDecimal;

public class NumberUtilities {
    public static <T extends Number> T add(T n1, T n2) {
        return (T) new BigDecimal(n1.toString()).add(new BigDecimal(n2.toString()));
    }

    public static <T extends Number> T subtract(T n1, T n2) {
        return (T) new BigDecimal(n1.toString()).subtract(new BigDecimal(n2.toString()));
    }

    public static <T extends Number> T multiply(T n1, T n2) {
        return (T) new BigDecimal(n1.toString()).multiply(new BigDecimal(n2.toString()));
    }

    public static <T extends Number> T divide(T n1, T n2) {
        return (T) new BigDecimal(n1.toString()).divide(new BigDecimal(n2.toString()));
    }

    public static <T extends Number> T pow(T n, int pow) {
        return (T) new BigDecimal(n.toString()).pow(pow);
    }
}
