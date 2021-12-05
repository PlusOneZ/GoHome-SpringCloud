package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto;/**
 * @author 梁乔 2021/11/30
 **/

/**
 * 此处写CustomerCouponInfoDto类的描述
 * @author 梁乔
 * @since 2021/11/30 18:48 
 */
public class CustomerCouponInfoDto {
    private Integer customerLevelCouponNum;
    private float customerLevelCouponAmount;

    public Integer getCustomerLevelCouponNum() {
        return customerLevelCouponNum;
    }

    public void setCustomerLevelCouponNum(Integer customerLevelCouponNum) {
        this.customerLevelCouponNum = customerLevelCouponNum;
    }

    public float getCustomerLevelCouponAmount() {
        return customerLevelCouponAmount;
    }

    public void setCustomerLevelCouponAmount(float customerLevelCouponAmount) {
        this.customerLevelCouponAmount = customerLevelCouponAmount;
    }
}