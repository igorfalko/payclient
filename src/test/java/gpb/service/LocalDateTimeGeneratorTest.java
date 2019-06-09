package gpb.service;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class LocalDateTimeGeneratorTest {

    @Test
    public void whenRangeIsDayThenResultIsStartOfTheRange() {
        LocalDate ld_min = LocalDate.of(2010, 1, 1);
        LocalDateTime ldt = LocalDateTimeGenerator.generateRandom(ld_min, ld_min);
        assertEquals(0, ldt.compareTo(ld_min.atStartOfDay()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenRangeIsNullThenThrowException() {
        LocalDate ld_min = null;
        LocalDateTime ldt = LocalDateTimeGenerator.generateRandom(ld_min, ld_min);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenRangeIsEmptyThenThrowException() {
        LocalDate ld_min = LocalDate.of(2010, 1, 1);
        LocalDateTime ldt = LocalDateTimeGenerator.generateRandom(ld_min, ld_min.minusDays(1));
    }

}