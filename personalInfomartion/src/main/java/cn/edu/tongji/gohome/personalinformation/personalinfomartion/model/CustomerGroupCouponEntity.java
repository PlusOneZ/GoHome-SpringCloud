package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/30
 **/

import javax.persistence.*;
import java.util.Objects;

/**
 * 此处写CustomerGroupCouponEntity类的描述
 * @author 梁乔
 * @since 2021/11/30 18:38 
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
        return customerLevel == that.customerLevel && couponTypeId == that.couponTypeId && Objects.equals(couponAmount, that.couponAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerLevel, couponTypeId, couponAmount);
    }
}