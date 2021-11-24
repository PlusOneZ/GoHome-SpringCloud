package
        cn.edu.tongji.gohome.order.dto;

import cn.edu.tongji.gohome.order.model.OrderStayEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

/**
 * this class is used to insert an order...
 * this order contains order information and room information...
 *
 * @author : loey
 * @className : OrderContent
 * @since : 2021-11-23 22:15
 **/
public class OrderContent {

    private long customerId;
    private Timestamp orderTime;
    private BigInteger memberAmount;
    private BigDecimal totalCost;
    private List<OrderStayInfoDto> orderStayEntityList;
    private int orderStatus;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public BigInteger getMemberAmount() {
        return memberAmount;
    }

    public void setMemberAmount(BigInteger memberAmount) {
        this.memberAmount = memberAmount;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderStayInfoDto> getOrderStayEntityList() {
        return orderStayEntityList;
    }

    public void setOrderStayEntityList(List<OrderStayInfoDto> orderStayEntityList) {
        this.orderStayEntityList = orderStayEntityList;
    }
}