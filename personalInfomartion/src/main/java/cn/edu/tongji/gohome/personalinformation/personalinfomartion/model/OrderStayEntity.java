package cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 此处写OrderStayEntity类
 * @author 梁乔
 * @date 2021/11/23 10:43 
 */
@Entity
@Table(name = "order_stay", schema = "GoHome", catalog = "")
@IdClass(OrderStayEntityPK.class)
public class OrderStayEntity {
    private long orderId;
    private long stayId;
    private int roomId;
    private Timestamp startTime;
    private Timestamp endTime;
    private BigDecimal moneyAmount;

    @Id
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "money_amount")
    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStayEntity that = (OrderStayEntity) o;
        return orderId == that.orderId && stayId == that.stayId && roomId == that.roomId && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(moneyAmount, that.moneyAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, stayId, roomId, startTime, endTime, moneyAmount);
    }
}