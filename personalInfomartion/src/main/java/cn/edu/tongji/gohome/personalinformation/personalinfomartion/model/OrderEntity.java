package cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * OrderEntity类
 * @author 梁乔
 * @date 2021/11/23 16:17 
 */
@Entity
@Table(name = "`order`", schema = "GoHome", catalog = "")
public class OrderEntity {
    private long orderId;
    private long customerId;
    private Timestamp orderTime;
    private BigInteger memberAmount;
    private BigDecimal totalCost;

    @Id
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "order_time")
    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "member_amount")
    public BigInteger getMemberAmount() {
        return memberAmount;
    }

    public void setMemberAmount(BigInteger memberAmount) {
        this.memberAmount = memberAmount;
    }

    @Basic
    @Column(name = "total_cost")
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return orderId == that.orderId && customerId == that.customerId && Objects.equals(orderTime, that.orderTime) && Objects.equals(memberAmount, that.memberAmount) && Objects.equals(totalCost, that.totalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, orderTime, memberAmount, totalCost);
    }
}