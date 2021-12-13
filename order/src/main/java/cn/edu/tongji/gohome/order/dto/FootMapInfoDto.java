package
        cn.edu.tongji.gohome.order.dto;

/**
 * class description
 *
 * @author : loey
 * @className : FootMapInfoDto
 * @since : 2021-12-12 23:37
 **/
public class FootMapInfoDto {
    private long orderId;
    private String stayProvince;
    private String stayCity;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getStayProvince() {
        return stayProvince;
    }

    public void setStayProvince(String stayProvince) {
        this.stayProvince = stayProvince;
    }

    public String getStayCity() {
        return stayCity;
    }

    public void setStayCity(String stayCity) {
        this.stayCity = stayCity;
    }
}