package
        cn.edu.tongji.gohome.sale.sale.model;/**
 * @author 梁乔 2021/11/24
 **/

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 此处写CouponTypeEntity类的描述
 * @author 梁乔
 * @since 2021/11/24 21:30 
 */
@Entity
@Table(name = "coupon_type", schema = "GoHome", catalog = "")
public class CouponTypeEntity {
    private int couponTypeId;
    private BigDecimal couponAmount;
    private BigDecimal couponLimit;
    private String couponName;

    @Id
    @Column(name = "coupon_type_id")
    public int getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(int couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    @Basic
    @Column(name = "coupon_amount")
    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    @Basic
    @Column(name = "coupon_limit")
    public BigDecimal getCouponLimit() {
        return couponLimit;
    }

    public void setCouponLimit(BigDecimal couponLimit) {
        this.couponLimit = couponLimit;
    }

    @Basic
    @Column(name = "coupon_name")
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

        CouponTypeEntity that = (CouponTypeEntity) o;

        if (couponTypeId != that.couponTypeId) return false;
        if (couponAmount != null ? !couponAmount.equals(that.couponAmount) : that.couponAmount != null) return false;
        if (couponLimit != null ? !couponLimit.equals(that.couponLimit) : that.couponLimit != null) return false;
        if (couponName != null ? !couponName.equals(that.couponName) : that.couponName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couponTypeId;
        result = 31 * result + (couponAmount != null ? couponAmount.hashCode() : 0);
        result = 31 * result + (couponLimit != null ? couponLimit.hashCode() : 0);
        result = 31 * result + (couponName != null ? couponName.hashCode() : 0);
        return result;
    }
}