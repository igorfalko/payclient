package gpb.service;

import gpb.web.dto.Payment;
import gpb.web.service.PaymentSender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {
    private ContextService ctx;
    public PaymentProcessor(ContextService ctx) {
        this.ctx = ctx;
    }

    public void process() throws IOException {
        OfficeNameProvider officeNameProvider = new OfficeNameProvider(ctx.getOfficesFileName());
        List<Payment> paymentList = new ArrayList<>();

        try(PaymentSender paymentSender = new PaymentSender(ctx.getUrl())) {
            for (int i = 0; i < ctx.getN(); i++) {
                Payment payment = PaymentGenerator.generatePayment(officeNameProvider.getRandomOffice());
                if (paymentSender.sendPayment(payment))
                    paymentList.add(payment);
            }
            PaymentSaveService.save(ctx.getPaymentsFileName(), paymentList);
        }
    }

}
