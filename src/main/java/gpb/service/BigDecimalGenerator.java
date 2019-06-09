package gpb.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalGenerator {
    public static BigDecimal generateRandom(BigDecimal range_min, BigDecimal range_max, int scale) {
        if (range_min == null || range_max == null) {
            throw new IllegalArgumentException("Range limit is null");
        }

        if (range_max.compareTo(range_min) < 0) {
            throw new IllegalArgumentException("Range is empty");
        }
        BigDecimal range = range_max.subtract(range_min);
        BigDecimal result = range_min.add(range.multiply(new BigDecimal(Math.random()))).setScale(scale, RoundingMode.HALF_EVEN);
        return result;
    }
}
