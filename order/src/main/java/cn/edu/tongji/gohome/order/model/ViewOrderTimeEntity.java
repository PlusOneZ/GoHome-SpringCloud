package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * class description
 *
 * @author : loey
 * @className : ViewOrderTimeEntity
 * @since : 2021-11-29 16:22
 **/
@Entity
@Table(name = "view_order_time", schema = "GoHome", catalog = "")
public class ViewOrderTimeEntity {
    private long orderId;
    private Timestamp minStartTime;
    private Timestamp maxEndTime;

    @Id
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "min_start_time", nullable = true)
    public Timestamp getMinStartTime() {
        return minStartTime;
    }

    public void setMinStartTime(Timestamp minStartTime) {
        this.minStartTime = minStartTime;
    }

    @Basic
    @Column(name = "max_end_time", nullable = true)
    public Timestamp getMaxEndTime() {
        return maxEndTime;
    }

    public void setMaxEndTime(Timestamp maxEndTime) {
        this.maxEndTime = maxEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewOrderTimeEntity that = (ViewOrderTimeEntity) o;

        if (orderId != that.orderId) return false;
        if (minStartTime != null ? !minStartTime.equals(that.minStartTime) : that.minStartTime != null) return false;
        if (maxEndTime != null ? !maxEndTime.equals(that.maxEndTime) : that.maxEndTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (minStartTime != null ? minStartTime.hashCode() : 0);
        result = 31 * result + (maxEndTime != null ? maxEndTime.hashCode() : 0);
        return result;
    }
}