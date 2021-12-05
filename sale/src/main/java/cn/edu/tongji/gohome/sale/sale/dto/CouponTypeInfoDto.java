package
        cn.edu.tongji.gohome.sale.sale.dto;/**
 * @author 梁乔 2021/12/1
 **/

/**
 * 此处写CouponTypeInfoDto类的描述
 * @author 梁乔
 * @since 2021/12/1 11:04 
 */
public class CouponTypeInfoDto {
    private float couponAmount;
    private float couponLimit;
    private String couponName;

    public float getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(float couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public float getCouponLimit() {
        return couponLimit;
    }

    public void setCouponLimit(float couponLimit) {
        this.couponLimit = couponLimit;
    }
}