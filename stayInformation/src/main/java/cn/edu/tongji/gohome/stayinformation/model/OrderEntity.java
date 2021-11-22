package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * TODO:此处写OrderEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "order", schema = "GoHome", catalog = "")
public class OrderEntity {
    private long orderId;
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

        if (orderId != that.orderId) return false;
        if (orderTime != null ? !orderTime.equals(that.orderTime) : that.orderTime != null) return false;
        if (memberAmount != null ? !memberAmount.equals(that.memberAmount) : that.memberAmount != null) return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        result = 31 * result + (memberAmount != null ? memberAmount.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        return result;
    }
}
