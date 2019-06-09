package gpb.service;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class BigDecimalGeneratorTest {
    @Test
    public void whenRangeIsOneNumberThenOnlyOneResultIsPossible() {
        BigDecimal MIN_AMOUNT = new BigDecimal("0");
        BigDecimal value = BigDecimalGenerator.generateRandom(MIN_AMOUNT, MIN_AMOUNT, 2);
        assertTrue(MIN_AMOUNT.compareTo(value) == 0);
    }

    @Test
    public void scaleIsUsed() {
        BigDecimal MIN_AMOUNT = new BigDecimal("0.0");
        BigDecimal MAX_AMOUNT = new BigDecimal("1");
        int scale = 5;
        BigDecimal value = BigDecimalGenerator.generateRandom(MIN_AMOUNT, MAX_AMOUNT, scale);
        assertTrue(value.scale() == scale);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMinGTMaxThenExceptionThrown() {
        BigDecimal MIN_AMOUNT = new BigDecimal("1");
        BigDecimal MAX_AMOUNT = new BigDecimal("0");
        BigDecimalGenerator.generateRandom(MIN_AMOUNT, MAX_AMOUNT, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMinOrMaxIsNullThenExceptionThrown() {
        BigDecimalGenerator.generateRandom(null, null, 2);
    }
}
