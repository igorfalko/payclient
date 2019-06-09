package gpb.web.service;

import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;

public class PaymentSender implements Closeable {
    private String url;
    private CloseableHttpClient httpClient;

    public PaymentSender(String url) {
        this.url = url;
    }

    public boolean sendPayment(Payment payment) {
        if (payment == null)
            return false;
        PaymentInfo paymentInfo = sendToUrl(payment);
        if (paymentInfo != null) {
            payment.setCommissionAmount(paymentInfo.getCommissionAmount());
            payment.setId(paymentInfo.getId());
            return true;
        }
        return false;
    }

    private PaymentInfo sendToUrl(Payment payment) {
        PaymentInfo paymentInfo = null;
        if (httpClient == null) {
            httpClient = HttpClientBuilder.create().build();
        }
        try {
            HttpPost request = new HttpPost(url);

            StringEntity params = new StringEntity(payment.toJson(), ContentType.APPLICATION_JSON);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            try (JsonReader jsonReader = Json.createReader(response.getEntity().getContent())) {
                JsonObject object = jsonReader.readObject();
                Long id = (long) object.getInt("id");
                BigDecimal commissionAmount = new BigDecimal(object.get("commissionAmount").toString());
                paymentInfo = new PaymentInfo(id, commissionAmount);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return paymentInfo;
    }

    @Override
    public void close() throws IOException {
        if (httpClient != null) {
            httpClient.close();
        }
        httpClient = null;
    }
}
