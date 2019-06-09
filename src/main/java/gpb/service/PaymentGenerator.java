package gpb.service;

import gpb.web.dto.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PaymentGenerator {
    static BigDecimal MIN_AMOUNT = new BigDecimal("10000.12");
    static BigDecimal MAX_AMOUNT = new BigDecimal("100000.50");
    LocalDateTime MIN_TIME;
    LocalDateTime MAX_TIME;

    public static Payment generatePayment(String office) {
        BigDecimal amount = BigDecimalGenerator.generateRandom(MIN_AMOUNT, MAX_AMOUNT, 2);
        return new Payment(LocalDate.now(), LocalTime.now(), amount, office);
    }

}
