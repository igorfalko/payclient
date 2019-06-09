package gpb.web.dto;

import java.math.BigDecimal;

public class PaymentInfo {
    private Long id;
    private BigDecimal commissionAmount;

    public PaymentInfo(Long id, BigDecimal commissionAmount) {
        this.id = id;
        this.commissionAmount = commissionAmount;
    }

    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public Long getId() {
        return id;
    }
}
