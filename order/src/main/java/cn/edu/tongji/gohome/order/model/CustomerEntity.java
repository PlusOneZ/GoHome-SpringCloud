package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * TODO
 *
 * @className: CustomerEntity
 * @author: loey
 * @date: 2021-11-19 21:18
 **/
@Entity
@Table(name = "customer", schema = "GoHome", catalog = "")
public class CustomerEntity {
    private long customerId;
    private String customerName;
    private String customerPassword;
    private String customerPhone;
    private String customerEmail;
    private String customerPhoneCode;
    private Timestamp customerCreateTime;
    private String customerAvatarLink;
    private String customerGender;
    private Date customerBirthday;
    private Integer customerState;
    private Integer customerDegree;
    private Integer customerMood;

    @Id
    @Column(name = "customer_id", nullable = false)
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "customer_name", nullable = false, length = 40)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_password", nullable = false, length = 100)
    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    @Basic
    @Column(name = "customer_phone", nullable = false, length = 11)
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Basic
    @Column(name = "customer_email", nullable = true, length = 64)
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Basic
    @Column(name = "customer_phone_code", nullable = true, length = 10)
    public String getCustomerPhoneCode() {
        return customerPhoneCode;
    }

    public void setCustomerPhoneCode(String customerPhoneCode) {
        this.customerPhoneCode = customerPhoneCode;
    }

    @Basic
    @Column(name = "customer_create_time", nullable = true)
    public Timestamp getCustomerCreateTime() {
        return customerCreateTime;
    }

    public void setCustomerCreateTime(Timestamp customerCreateTime) {
        this.customerCreateTime = customerCreateTime;
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
    @Column(name = "customer_gender", nullable = true, length = 1)
    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    @Basic
    @Column(name = "customer_birthday", nullable = true)
    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    @Basic
    @Column(name = "customer_state", nullable = true, precision = 0)
    public Integer getCustomerState() {
        return customerState;
    }

    public void setCustomerState(Integer customerState) {
        this.customerState = customerState;
    }

    @Basic
    @Column(name = "customer_degree", nullable = true, precision = 0)
    public Integer getCustomerDegree() {
        return customerDegree;
    }

    public void setCustomerDegree(Integer customerDegree) {
        this.customerDegree = customerDegree;
    }

    @Basic
    @Column(name = "customer_mood", nullable = true, precision = 0)
    public Integer getCustomerMood() {
        return customerMood;
    }

    public void setCustomerMood(Integer customerMood) {
        this.customerMood = customerMood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (customerId != that.customerId) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (customerPassword != null ? !customerPassword.equals(that.customerPassword) : that.customerPassword != null)
            return false;
        if (customerPhone != null ? !customerPhone.equals(that.customerPhone) : that.customerPhone != null)
            return false;
        if (customerEmail != null ? !customerEmail.equals(that.customerEmail) : that.customerEmail != null)
            return false;
        if (customerPhoneCode != null ? !customerPhoneCode.equals(that.customerPhoneCode) : that.customerPhoneCode != null)
            return false;
        if (customerCreateTime != null ? !customerCreateTime.equals(that.customerCreateTime) : that.customerCreateTime != null)
            return false;
        if (customerAvatarLink != null ? !customerAvatarLink.equals(that.customerAvatarLink) : that.customerAvatarLink != null)
            return false;
        if (customerGender != null ? !customerGender.equals(that.customerGender) : that.customerGender != null)
            return false;
        if (customerBirthday != null ? !customerBirthday.equals(that.customerBirthday) : that.customerBirthday != null)
            return false;
        if (customerState != null ? !customerState.equals(that.customerState) : that.customerState != null)
            return false;
        if (customerDegree != null ? !customerDegree.equals(that.customerDegree) : that.customerDegree != null)
            return false;
        if (customerMood != null ? !customerMood.equals(that.customerMood) : that.customerMood != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerPassword != null ? customerPassword.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        result = 31 * result + (customerPhoneCode != null ? customerPhoneCode.hashCode() : 0);
        result = 31 * result + (customerCreateTime != null ? customerCreateTime.hashCode() : 0);
        result = 31 * result + (customerAvatarLink != null ? customerAvatarLink.hashCode() : 0);
        result = 31 * result + (customerGender != null ? customerGender.hashCode() : 0);
        result = 31 * result + (customerBirthday != null ? customerBirthday.hashCode() : 0);
        result = 31 * result + (customerState != null ? customerState.hashCode() : 0);
        result = 31 * result + (customerDegree != null ? customerDegree.hashCode() : 0);
        result = 31 * result + (customerMood != null ? customerMood.hashCode() : 0);
        return result;
    }
}