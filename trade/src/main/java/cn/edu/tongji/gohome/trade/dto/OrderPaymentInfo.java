package
        cn.edu.tongji.gohome.trade.dto;

import java.math.BigDecimal;

/**
 * class description
 *
 * @author : loey
 * @className : OrderPaymentInfo
 * @since : 2021-12-04 01:57
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