package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写CustomerGroupCouponEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "customer_group_coupon", schema = "GoHome", catalog = "")
@IdClass(CustomerGroupCouponEntityPK.class)
public class CustomerGroupCouponEntity {
    private int customerLevel;
    private int couponTypeId;
    private Integer couponAmount;

    @Id
    @Column(name = "customer_level")
    public int getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(int customerLevel) {
        this.customerLevel = customerLevel;
    }

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
    public Integer getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Integer couponAmount) {
        this.couponAmount = couponAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerGroupCouponEntity that = (CustomerGroupCouponEntity) o;

        if (customerLevel != that.customerLevel) return false;
        if (couponTypeId != that.couponTypeId) return false;
        if (couponAmount != null ? !couponAmount.equals(that.couponAmount) : that.couponAmount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerLevel;
        result = 31 * result + couponTypeId;
        result = 31 * result + (couponAmount != null ? couponAmount.hashCode() : 0);
        return result;
    }
}
