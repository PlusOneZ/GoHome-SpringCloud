package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;

/**
 * class description
 *
 * @author : loey
 * @className : ViewStayCustomerEntity
 * @since : 2021-11-29 16:58
 **/
@Entity
@Table(name = "view_stay_customer", schema = "GoHome", catalog = "")
public class ViewStayCustomerEntity {
    private long stayId;
    private long customerId;
    private String customerAvatarLink;
    private String customerName;

    @Id
    @Column(name = "stay_id", nullable = false)
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Basic
    @Column(name = "customer_id", nullable = false)
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "customer_avatar_link", nullable = true, length = 256)
    public String getCustomerAvatarLink() {
        return customerAvatarLink;
    }

    public void setCustomerAvatarLink(String customerAvatarLink) {
        this.customerAvatarLink = customerAvatarLink;
    }

    @Basic
    @Column(name = "customer_name", nullable = false, length = 40)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewStayCustomerEntity that = (ViewStayCustomerEntity) o;

        if (stayId != that.stayId) return false;
        if (customerId != that.customerId) return false;
        if (customerAvatarLink != null ? !customerAvatarLink.equals(that.customerAvatarLink) : that.customerAvatarLink != null)
            return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (customerAvatarLink != null ? customerAvatarLink.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        return result;
    }
}