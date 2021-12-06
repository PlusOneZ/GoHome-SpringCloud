package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写ViewStayOrderNumberEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/5 20:54
 */
@Entity
@Table(name = "view_stay_order_number", schema = "GoHome", catalog = "")
public class ViewStayOrderNumberEntity {
    private long stayId;
    private long orderNumber;

    @Id
    @Basic
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Basic
    @Column(name = "order_number")
    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewStayOrderNumberEntity that = (ViewStayOrderNumberEntity) o;

        if (stayId != that.stayId) return false;
        if (orderNumber != that.orderNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (int) (orderNumber ^ (orderNumber >>> 32));
        return result;
    }
}
