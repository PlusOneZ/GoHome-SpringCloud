package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/30
 **/

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 此处写CouponTypeEntity类的描述
 * @author 梁乔
 * @since 2021/11/30 18:50 
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
        return couponTypeId == that.couponTypeId && Objects.equals(couponAmount, that.couponAmount) && Objects.equals(couponLimit, that.couponLimit) && Objects.equals(couponName, that.couponName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponTypeId, couponAmount, couponLimit, couponName);
    }
}