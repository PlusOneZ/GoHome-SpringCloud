package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * TODO:此处写CouponEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "coupon", schema = "GoHome", catalog = "")
public class CouponEntity {
    private long couponId;
    private Date couponStartDate;
    private Date couponEndDate;

    @Id
    @Column(name = "coupon_id")
    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    @Basic
    @Column(name = "coupon_start_date")
    public Date getCouponStartDate() {
        return couponStartDate;
    }

    public void setCouponStartDate(Date couponStartDate) {
        this.couponStartDate = couponStartDate;
    }

    @Basic
    @Column(name = "coupon_end_date")
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
        if (couponStartDate != null ? !couponStartDate.equals(that.couponStartDate) : that.couponStartDate != null)
            return false;
        if (couponEndDate != null ? !couponEndDate.equals(that.couponEndDate) : that.couponEndDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (couponId ^ (couponId >>> 32));
        result = 31 * result + (couponStartDate != null ? couponStartDate.hashCode() : 0);
        result = 31 * result + (couponEndDate != null ? couponEndDate.hashCode() : 0);
        return result;
    }
}
