package
        cn.edu.tongji.gohome.payment.Dto;

import java.math.BigDecimal;

/**
 * This API contains some information about order payment...
 *
 * @author : loey
 * @className : OrderPaymentInfo
 * @since : 2021-11-24 19:04
 **/
public class OrderPaymentInfo {
    private long orderId;
    private BigDecimal totalCost;
    private String orderName;
    private String orderInfo;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
}