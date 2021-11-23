package cn.edu.tongji.gohome.login.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * CustomerEntity
 *
 * @author 卓正一
 * @since 2021/11/22 9:35 PM
 */
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
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_password")
    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    @Basic
    @Column(name = "customer_phone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Basic
    @Column(name = "customer_email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Basic
    @Column(name = "customer_phone_code")
    public String getCustomerPhoneCode() {
        return customerPhoneCode;
    }

    public void setCustomerPhoneCode(String customerPhoneCode) {
        this.customerPhoneCode = customerPhoneCode;
    }

    @Basic
    @Column(name = "customer_create_time")
    public Timestamp getCustomerCreateTime() {
        return customerCreateTime;
    }

    public void setCustomerCreateTime(Timestamp customerCreateTime) {
        this.customerCreateTime = customerCreateTime;
    }

    @Basic
    @Column(name = "customer_avatar_link")
    public String getCustomerAvatarLink() {
        return customerAvatarLink;
    }

    public void setCustomerAvatarLink(String customerAvatarLink) {
        this.customerAvatarLink = customerAvatarLink;
    }

    @Basic
    @Column(name = "customer_gender")
    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    @Basic
    @Column(name = "customer_birthday")
    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    @Basic
    @Column(name = "customer_state")
    public Integer getCustomerState() {
        return customerState;
    }

    public void setCustomerState(Integer customerState) {
        this.customerState = customerState;
    }

    @Basic
    @Column(name = "customer_degree")
    public Integer getCustomerDegree() {
        return customerDegree;
    }

    public void setCustomerDegree(Integer customerDegree) {
        this.customerDegree = customerDegree;
    }

    @Basic
    @Column(name = "customer_mood")
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
        return customerId == that.customerId && Objects.equals(customerName, that.customerName) && Objects.equals(customerPassword, that.customerPassword) && Objects.equals(customerPhone, that.customerPhone) && Objects.equals(customerEmail, that.customerEmail) && Objects.equals(customerPhoneCode, that.customerPhoneCode) && Objects.equals(customerCreateTime, that.customerCreateTime) && Objects.equals(customerAvatarLink, that.customerAvatarLink) && Objects.equals(customerGender, that.customerGender) && Objects.equals(customerBirthday, that.customerBirthday) && Objects.equals(customerState, that.customerState) && Objects.equals(customerDegree, that.customerDegree) && Objects.equals(customerMood, that.customerMood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerPassword, customerPhone, customerEmail, customerPhoneCode, customerCreateTime, customerAvatarLink, customerGender, customerBirthday, customerState, customerDegree, customerMood);
    }
}
