package gpb.web.service;

import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;

import java.math.BigDecimal;

public class PaymentSender {
    private String url;

    public PaymentSender(String url) {
        this.url = url;
    }

    public boolean sendPayment(Payment payment) {
        PaymentInfo paymentInfo = new PaymentInfo(Long.parseLong("1"), new BigDecimal("0.1"));
        if (paymentInfo != null) {
            payment.setCommissionAmount(paymentInfo.getCommissionAmount());
            payment.setId(paymentInfo.getId());
            return true;
        }
        return false;
    }
}
