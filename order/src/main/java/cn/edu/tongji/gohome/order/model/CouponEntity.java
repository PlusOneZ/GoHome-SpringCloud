package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * TODO
 *
 * @className: CouponEntity
 * @author: loey
 * @date: 2021-11-19 21:18
 **/
@Entity
@Table(name = "coupon", schema = "GoHome", catalog = "")
public class CouponEntity {
    private long couponId;
    private Long customerId;
    private Date couponStartDate;
    private Date couponEndDate;

    @Id
    @Column(name = "coupon_id", nullable = false)
    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    @Basic
    @Column(name = "customer_id", nullable = true)
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "coupon_start_date", nullable = false)
    public Date getCouponStartDate() {
        return couponStartDate;
    }

    public void setCouponStartDate(Date couponStartDate) {
        this.couponStartDate = couponStartDate;
    }

    @Basic
    @Column(name = "coupon_end_date", nullable = false)
    public Date getCouponEndDate() {
        return couponEndDate;
    }

    public void setCouponEndDate(Date couponEndDate) {
        this.couponEndDate = couponEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CouponEntity that = (CouponEntity) o;

        if (couponId != that.couponId) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (couponStartDate != null ? !couponStartDate.equals(that.couponStartDate) : that.couponStartDate != null)
            return false;
        if (couponEndDate != null ? !couponEndDate.equals(that.couponEndDate) : that.couponEndDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (couponId ^ (couponId >>> 32));
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (couponStartDate != null ? couponStartDate.hashCode() : 0);
        result = 31 * result + (couponEndDate != null ? couponEndDate.hashCode() : 0);
        return result;
    }
}