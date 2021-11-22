package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO
 *
 * @className: OrderStayEntityPK
 * @author: loey
 * @date: 2021-11-19 21:18
 **/
public class OrderStayEntityPK implements Serializable {
    private long orderId;
    private long stayId;
    private int roomId;

    @Column(name = "order_id", nullable = false)
    @Id
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "stay_id", nullable = false)
    @Id
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Column(name = "room_id", nullable = false)
    @Id
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStayEntityPK that = (OrderStayEntityPK) o;

        if (orderId != that.orderId) return false;
        if (stayId != that.stayId) return false;
        if (roomId != that.roomId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + roomId;
        return result;
    }
}