package gpb.service;

import gpb.web.dto.Payment;
import gpb.web.service.PaymentSender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {

    public void process(ContextService ctx) throws IOException {
        OfficeService officeService = new OfficeService(ctx.getOfficesFileName());
        List<Payment> paymentList = new ArrayList<>();

        PaymentSender paymentSender = new PaymentSender(ctx.getUrl());
        for (int i=0; i<ctx.getN(); i++) {
            Payment payment = PaymentGenerator.generatePayment(officeService.getRandomOffice());
            if (paymentSender.sendPayment(payment))
                paymentList.add(payment);
        }
        PaymentSaveService.save(ctx.getPaymentsFileName(), paymentList);
    }

}
