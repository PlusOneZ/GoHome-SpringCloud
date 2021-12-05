package cn.edu.tongji.gohome.statistics.model;

import javax.persistence.*;

/**
 * TODO:此处写ViewStayCustomerGenderAgeEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/6 1:33
 */
@Entity
@Table(name = "view_stay_customer_gender_age", schema = "GoHome", catalog = "")
public class ViewStayCustomerGenderAgeEntity {
    private long stayId;
    private long customerId;
    private String gender;
    private Long age;


    @Id
    @Basic
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Basic
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "age")
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewStayCustomerGenderAgeEntity that = (ViewStayCustomerGenderAgeEntity) o;

        if (stayId != that.stayId) return false;
        if (customerId != that.customerId) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
