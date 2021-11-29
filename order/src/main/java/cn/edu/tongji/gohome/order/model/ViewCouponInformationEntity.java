package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * class description
 *
 * @author : loey
 * @className : ViewCouponInformationEntity
 * @since : 2021-11-27 21:55
 **/
@Entity
@Table(name = "view_coupon_information", schema = "GoHome", catalog = "")
public class ViewCouponInformationEntity {
    private long couponId;
    private Long customerId;
    private Date couponStartDate;
    private Date couponEndDate;
    private Integer couponStatus;
    private BigDecimal couponAmount;
    private BigDecimal couponLimit;
    private String couponName;

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

    @Basic
    @Column(name = "coupon_status", nullable = true)
    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    @Basic
    @Column(name = "coupon_amount", nullable = false, precision = 2)
    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    @Basic
    @Column(name = "coupon_limit", nullable = false, precision = 2)
    public BigDecimal getCouponLimit() {
        return couponLimit;
    }

    public void setCouponLimit(BigDecimal couponLimit) {
        this.couponLimit = couponLimit;
    }

    @Basic
    @Column(name = "coupon_name", nullable = false, length = 64)
    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewCouponInformationEntity that = (ViewCouponInformationEntity) o;

        if (couponId != that.couponId) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (couponStartDate != null ? !couponStartDate.equals(that.couponStartDate) : that.couponStartDate != null)
            return false;
        if (couponEndDate != null ? !couponEndDate.equals(that.couponEndDate) : that.couponEndDate != null)
            return false;
        if (couponStatus != null ? !couponStatus.equals(that.couponStatus) : that.couponStatus != null) return false;
        if (couponAmount != null ? !couponAmount.equals(that.couponAmount) : that.couponAmount != null) return false;
        if (couponLimit != null ? !couponLimit.equals(that.couponLimit) : that.couponLimit != null) return false;
        if (couponName != null ? !couponName.equals(that.couponName) : that.couponName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (couponId ^ (couponId >>> 32));
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (couponStartDate != null ? couponStartDate.hashCode() : 0);
        result = 31 * result + (couponEndDate != null ? couponEndDate.hashCode() : 0);
        result = 31 * result + (couponStatus != null ? couponStatus.hashCode() : 0);
        result = 31 * result + (couponAmount != null ? couponAmount.hashCode() : 0);
        result = 31 * result + (couponLimit != null ? couponLimit.hashCode() : 0);
        result = 31 * result + (couponName != null ? couponName.hashCode() : 0);
        return result;
    }
}