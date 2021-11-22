package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * TODO:此处写CustomerCommentEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "customer_comment", schema = "GoHome", catalog = "")
public class CustomerCommentEntity {
    private int customerCommentId;
    private Timestamp customerCommentTime;
    private String customerCommentContent;
    private byte stayScore;
    private long orderId;

    @Id
    @Column(name = "customer_comment_id")
    public int getCustomerCommentId() {
        return customerCommentId;
    }

    public void setCustomerCommentId(int customerCommentId) {
        this.customerCommentId = customerCommentId;
    }

    @Basic
    @Column(name = "customer_comment_time")
    public Timestamp getCustomerCommentTime() {
        return customerCommentTime;
    }

    public void setCustomerCommentTime(Timestamp customerCommentTime) {
        this.customerCommentTime = customerCommentTime;
    }

    @Basic
    @Column(name = "customer_comment_content")
    public String getCustomerCommentContent() {
        return customerCommentContent;
    }

    public void setCustomerCommentContent(String customerCommentContent) {
        this.customerCommentContent = customerCommentContent;
    }

    @Basic
    @Column(name = "stay_score")
    public byte getStayScore() {
        return stayScore;
    }

    public void setStayScore(byte stayScore) {
        this.stayScore = stayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerCommentEntity that = (CustomerCommentEntity) o;

        if (customerCommentId != that.customerCommentId) return false;
        if (stayScore != that.stayScore) return false;
        if (customerCommentTime != null ? !customerCommentTime.equals(that.customerCommentTime) : that.customerCommentTime != null)
            return false;
        if (customerCommentContent != null ? !customerCommentContent.equals(that.customerCommentContent) : that.customerCommentContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerCommentId;
        result = 31 * result + (customerCommentTime != null ? customerCommentTime.hashCode() : 0);
        result = 31 * result + (customerCommentContent != null ? customerCommentContent.hashCode() : 0);
        result = 31 * result + (int) stayScore;
        return result;
    }

    @Basic
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
