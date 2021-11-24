package cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * HostCommentEntity类
 * @author 梁乔
 * @date 2021/11/23 11:31 
 */
@Entity
@Table(name = "host_comment", schema = "GoHome", catalog = "")
public class HostCommentEntity {
    private long hostCommentId;
    private long orderId;
    private Timestamp hostCommentTime;
    private String hostCommentContent;
    private int customerScore;

    @Id
    @Column(name = "host_comment_id")
    public long getHostCommentId() {
        return hostCommentId;
    }

    public void setHostCommentId(long hostCommentId) {
        this.hostCommentId = hostCommentId;
    }

    @Basic
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "host_comment_time")
    public Timestamp getHostCommentTime() {
        return hostCommentTime;
    }

    public void setHostCommentTime(Timestamp hostCommentTime) {
        this.hostCommentTime = hostCommentTime;
    }

    @Basic
    @Column(name = "host_comment_content")
    public String getHostCommentContent() {
        return hostCommentContent;
    }

    public void setHostCommentContent(String hostCommentContent) {
        this.hostCommentContent = hostCommentContent;
    }

    @Basic
    @Column(name = "customer_score")
    public int getCustomerScore() {
        return customerScore;
    }

    public void setCustomerScore(int customerScore) {
        this.customerScore = customerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HostCommentEntity that = (HostCommentEntity) o;
        return hostCommentId == that.hostCommentId && orderId == that.orderId && customerScore == that.customerScore && Objects.equals(hostCommentTime, that.hostCommentTime) && Objects.equals(hostCommentContent, that.hostCommentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostCommentId, orderId, hostCommentTime, hostCommentContent, customerScore);
    }
}