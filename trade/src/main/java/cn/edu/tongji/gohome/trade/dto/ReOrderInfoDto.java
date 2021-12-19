package
        cn.edu.tongji.gohome.trade.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * class description
 *
 * @author : loey
 * @className : RefundInfoDto
 * @since : 2021-12-19 14:59
 **/
public class ReOrderInfoDto {
    private long orderId;
    private Timestamp orderTime;
    private BigDecimal totalCost;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}