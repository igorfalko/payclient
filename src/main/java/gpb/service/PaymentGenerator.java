package gpb.service;

import gpb.web.dto.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class PaymentGenerator {
    private static BigDecimal MIN_AMOUNT = new BigDecimal("10000.12");
    private static BigDecimal MAX_AMOUNT = new BigDecimal("100000.50");
    private static LocalDate MIN_DATE;
    private static LocalDate MAX_DATE;

    static {
        MIN_DATE = LocalDate.now().minusYears(1).with(TemporalAdjusters.firstDayOfYear());
        MAX_DATE = MIN_DATE.plusYears(1);
    }

    public static Payment generatePayment(String office) {
        if (office == null)
            return null;
        BigDecimal amount = BigDecimalGenerator.generateRandom(MIN_AMOUNT, MAX_AMOUNT, 2);
        LocalDateTime paymentDateTime = LocalDateTimeGenerator.generateRandom(MIN_DATE, MAX_DATE);
        return new Payment(paymentDateTime.toLocalDate(), paymentDateTime.toLocalTime(), amount, office);
    }
}
