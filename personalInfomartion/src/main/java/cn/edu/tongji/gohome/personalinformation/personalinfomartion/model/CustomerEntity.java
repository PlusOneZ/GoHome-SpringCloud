package cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * CustomerEntity
 * @author 梁乔
 * @date 2021/11/23 17:09 
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
    private Integer customerLevel;

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

    @Basic
    @Column(name = "customer_level")
    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity customer = (CustomerEntity) o;
        return customerId == customer.customerId && Objects.equals(customerName, customer.customerName) && Objects.equals(customerPassword, customer.customerPassword) && Objects.equals(customerPhone, customer.customerPhone) && Objects.equals(customerEmail, customer.customerEmail) && Objects.equals(customerPhoneCode, customer.customerPhoneCode) && Objects.equals(customerCreateTime, customer.customerCreateTime) && Objects.equals(customerAvatarLink, customer.customerAvatarLink) && Objects.equals(customerGender, customer.customerGender) && Objects.equals(customerBirthday, customer.customerBirthday) && Objects.equals(customerState, customer.customerState) && Objects.equals(customerDegree, customer.customerDegree) && Objects.equals(customerMood, customer.customerMood) && Objects.equals(customerLevel, customer.customerLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerPassword, customerPhone, customerEmail, customerPhoneCode, customerCreateTime, customerAvatarLink, customerGender, customerBirthday, customerState, customerDegree, customerMood, customerLevel);
    }
}