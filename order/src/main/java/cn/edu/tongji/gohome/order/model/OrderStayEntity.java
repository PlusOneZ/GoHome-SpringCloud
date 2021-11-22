package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * TODO
 *
 * @className: OrderStayEntity
 * @author: loey
 * @date: 2021-11-19 21:18
 **/
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
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "stay_id", nullable = false)
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "room_id", nullable = false)
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "start_time", nullable = false)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time", nullable = false)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "money_amount", nullable = false, precision = 2)
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

        if (orderId != that.orderId) return false;
        if (stayId != that.stayId) return false;
        if (roomId != that.roomId) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (moneyAmount != null ? !moneyAmount.equals(that.moneyAmount) : that.moneyAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + roomId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (moneyAmount != null ? moneyAmount.hashCode() : 0);
        return result;
    }
}