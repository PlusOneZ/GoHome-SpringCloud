package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto;/**
 * @author 梁乔 2021/11/30
 **/

import java.util.List;

/**
 * 此处写CustomerGroupDto类的描述
 * @author 梁乔
 * @since 2021/11/30 18:36 
 */
public class CustomerGroupDto {
    private int customerGroupLevel;
    private String customerLevelName;
    private long customerNextLevelDegree;
    private List<CustomerCouponInfoDto> couponInfoDtoList;

    public int getCustomerGroupLevel() {
        return customerGroupLevel;
    }

    public void setCustomerGroupLevel(int customerGroupLevel) {
        this.customerGroupLevel = customerGroupLevel;
    }

    public List<CustomerCouponInfoDto> getCouponInfoDtoList() {
        return couponInfoDtoList;
    }

    public void setCouponInfoDtoList(List<CustomerCouponInfoDto> couponInfoDtoList) {
        this.couponInfoDtoList = couponInfoDtoList;
    }

    public long getCustomerNextLevelDegree() {
        return customerNextLevelDegree;
    }

    public void setCustomerNextLevelDegree(long customerNextLevelDegree) {
        this.customerNextLevelDegree = customerNextLevelDegree;
    }

    public String getCustomerLevelName() {
        return customerLevelName;
    }

    public void setCustomerLevelName(String customerLevelName) {
        this.customerLevelName = customerLevelName;
    }
}