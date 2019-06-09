package gpb;

import gpb.service.ContextService;
import gpb.service.PaymentProcessor;

import java.io.IOException;

public class PaymentClient {

    public static void main(String[] args) {
        ContextService ctx = new ContextService(args);
        if (ctx.isValid()) {
            PaymentProcessor paymentProcessor = new PaymentProcessor();
            try {
                paymentProcessor.process(ctx);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}