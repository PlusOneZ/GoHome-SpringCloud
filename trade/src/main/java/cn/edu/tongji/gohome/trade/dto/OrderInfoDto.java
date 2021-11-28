package
        cn.edu.tongji.gohome.trade.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

/**
 * class description
 *
 * @author : loey
 * @className : OrderInfoDto
 * @since : 2021-11-25 23:11
 **/
public class OrderInfoDto {
    private long customerId;
    private Timestamp orderTime;
    private BigInteger memberAmount;
    private BigDecimal totalCost;
    private List<RoomInfoDto> orderStayEntityList;
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

    public List<RoomInfoDto> getOrderStayEntityList() {
        return orderStayEntityList;
    }

    public void setOrderStayEntityList(List<RoomInfoDto> orderStayEntityList) {
        this.orderStayEntityList = orderStayEntityList;
    }
}