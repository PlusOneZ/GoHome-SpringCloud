package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order", schema = "GoHome", catalog = "")
public class OrderEntity {
    private Long orderId;
    private Long customerId;
    private Timestamp orderTime;
    private BigInteger memberAmount;
    private BigDecimal totalCost;
    private Integer orderStatus;

    @Id
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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

    @Basic
    @Column(name = "order_status")
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(customerId, that.customerId) && Objects.equals(orderTime, that.orderTime) && Objects.equals(memberAmount, that.memberAmount) && Objects.equals(totalCost, that.totalCost) && Objects.equals(orderStatus, that.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, orderTime, memberAmount, totalCost, orderStatus);
    }
}
