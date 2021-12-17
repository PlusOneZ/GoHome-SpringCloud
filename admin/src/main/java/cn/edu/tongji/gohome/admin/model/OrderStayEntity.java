package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_stay", schema = "GoHome", catalog = "")
@IdClass(OrderStayEntityPK.class)
public class OrderStayEntity {
    private Long orderId;
    private Long stayId;
    private Integer roomId;
    private Timestamp startTime;
    private Timestamp endTime;
    private BigDecimal moneyAmount;

    @Id
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "stay_id")
    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
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
        return Objects.equals(orderId, that.orderId) && Objects.equals(stayId, that.stayId) && Objects.equals(roomId, that.roomId) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(moneyAmount, that.moneyAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, stayId, roomId, startTime, endTime, moneyAmount);
    }
}
