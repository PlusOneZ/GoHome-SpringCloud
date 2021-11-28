package
        cn.edu.tongji.gohome.sale.sale.model;/**
 * @author 梁乔 2021/11/24
 **/

import javax.persistence.*;
import java.sql.Date;

/**
 * 此处写CouponEntity类的描述
 * @author 梁乔
 * @since 2021/11/24 21:30 
 */
@Entity
@Table(name = "coupon", schema = "GoHome", catalog = "")
public class CouponEntity {
    private long couponId;
    private Integer couponTypeId;
    private Long customerId;
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
    @Column(name = "coupon_type_id")
    public Integer getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(Integer couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    @Basic
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
        if (couponTypeId != null ? !couponTypeId.equals(that.couponTypeId) : that.couponTypeId != null) return false;
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
        result = 31 * result + (couponTypeId != null ? couponTypeId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (couponStartDate != null ? couponStartDate.hashCode() : 0);
        result = 31 * result + (couponEndDate != null ? couponEndDate.hashCode() : 0);
        return result;
    }
}