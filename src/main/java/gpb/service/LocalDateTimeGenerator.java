package gpb.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class LocalDateTimeGenerator {
    public static LocalDateTime generateRandom(LocalDate range_min, LocalDate range_max) {
        if (range_min == null || range_max == null) {
            throw new IllegalArgumentException("Range limit is null");
        }

        if (range_max.compareTo(range_min) < 0) {
            throw new IllegalArgumentException("Range is empty");
        }

        long minDay = range_min.toEpochDay();
        long maxDay = range_max.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay + 1);

        LocalTime randomTime = LocalTime
                .ofSecondOfDay(ThreadLocalRandom.current().nextLong(0, 24*60*60))
                .truncatedTo(ChronoUnit.MINUTES);
        if (randomDay==maxDay)
            randomTime = randomTime.truncatedTo(ChronoUnit.DAYS);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        return randomDate.atTime(randomTime);
    }
}
