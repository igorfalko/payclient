package gpb.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Payment {

    private LocalDate paymentDate;
    private LocalTime paymentTime;
    private BigDecimal amount;
    private String office;

    private BigDecimal commissionAmount;
    private Long id;

    public Payment() {}

    public Payment(LocalDate paymentDate, LocalTime paymentTime, BigDecimal amount, String office) {
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.office = office;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public String toJson() {
        return
            "{" +
                    "\"paymentDate\":\"" + paymentDate + "\"," +
                    "\"paymentTime\":\""+ paymentTime +"\"," +
                    "\"amount\":" + amount + "," +
                    "\"office\":\"" + office + "\"" +
            "}";

    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentDate=" + paymentDate +
                ", paymentTime=" + paymentTime +
                ", amount=" + amount +
                ", office='" + office + '\'' +
                ", commissionAmount=" + commissionAmount +
                ", id=" + id +
                '}';
    }
}
