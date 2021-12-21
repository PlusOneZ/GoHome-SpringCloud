package cn.edu.tongji.gohome.admin.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderStayEntityPK implements Serializable {
    private Long orderId;
    private Long stayId;
    private Integer roomId;

    @Column(name = "order_id")
    @Id
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "stay_id")
    @Id
    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    @Column(name = "room_id")
    @Id
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStayEntityPK that = (OrderStayEntityPK) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(stayId, that.stayId) && Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, stayId, roomId);
    }
}
