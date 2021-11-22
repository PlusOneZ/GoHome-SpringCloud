package
        cn.edu.tongji.gohome.order.model;



import javax.persistence.*;

/**
 * TODO
 *
 * @className: VOrderStayEntity
 * @author: loey
 * @date: 2021-11-22 16:32
 **/
@Entity
@Table(name = "v_order_stay", schema = "GoHome", catalog = "")
public class VOrderStayEntity {
    private long stayId;
    private long orderId;

    @Basic
    @Column(name = "stay_id", nullable = false)
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VOrderStayEntity that = (VOrderStayEntity) o;

        if (stayId != that.stayId) return false;
        if (orderId != that.orderId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        return result;
    }
}