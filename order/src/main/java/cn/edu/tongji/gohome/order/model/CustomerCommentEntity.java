package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * TODO
 *
 * @className: CustomerCommentEntity
 * @author: loey
 * @date: 2021-11-19 21:18
 **/
@Entity
@Table(name = "customer_comment", schema = "GoHome", catalog = "")
public class CustomerCommentEntity {
    private int customerCommentId;
    private long orderId;
    private Timestamp customerCommentTime;
    private String customerCommentContent;
    private int stayScore;

    @Id
    @Column(name = "customer_comment_id", nullable = false)
    public int getCustomerCommentId() {
        return customerCommentId;
    }

    public void setCustomerCommentId(int customerCommentId) {
        this.customerCommentId = customerCommentId;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "customer_comment_time", nullable = false)
    public Timestamp getCustomerCommentTime() {
        return customerCommentTime;
    }

    public void setCustomerCommentTime(Timestamp customerCommentTime) {
        this.customerCommentTime = customerCommentTime;
    }

    @Basic
    @Column(name = "customer_comment_content", nullable = false, length = 400)
    public String getCustomerCommentContent() {
        return customerCommentContent;
    }

    public void setCustomerCommentContent(String customerCommentContent) {
        this.customerCommentContent = customerCommentContent;
    }

    @Basic
    @Column(name = "stay_score", nullable = false)
    public int getStayScore() {
        return stayScore;
    }

    public void setStayScore(int stayScore) {
        this.stayScore = stayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerCommentEntity that = (CustomerCommentEntity) o;

        if (customerCommentId != that.customerCommentId) return false;
        if (orderId != that.orderId) return false;
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
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (customerCommentTime != null ? customerCommentTime.hashCode() : 0);
        result = 31 * result + (customerCommentContent != null ? customerCommentContent.hashCode() : 0);
        result = 31 * result + stayScore;
        return result;
    }
}