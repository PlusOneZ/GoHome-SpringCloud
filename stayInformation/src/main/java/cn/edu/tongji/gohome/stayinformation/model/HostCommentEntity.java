package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * TODO:此处写HostCommentEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "host_comment", schema = "GoHome", catalog = "")
public class HostCommentEntity {
    private int hostCommentId;
    private Timestamp hostCommentTime;
    private String hostCommentContent;
    private byte customerScore;

    @Id
    @Column(name = "host_comment_id")
    public int getHostCommentId() {
        return hostCommentId;
    }

    public void setHostCommentId(int hostCommentId) {
        this.hostCommentId = hostCommentId;
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
    public byte getCustomerScore() {
        return customerScore;
    }

    public void setCustomerScore(byte customerScore) {
        this.customerScore = customerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HostCommentEntity that = (HostCommentEntity) o;

        if (hostCommentId != that.hostCommentId) return false;
        if (customerScore != that.customerScore) return false;
        if (hostCommentTime != null ? !hostCommentTime.equals(that.hostCommentTime) : that.hostCommentTime != null)
            return false;
        if (hostCommentContent != null ? !hostCommentContent.equals(that.hostCommentContent) : that.hostCommentContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hostCommentId;
        result = 31 * result + (hostCommentTime != null ? hostCommentTime.hashCode() : 0);
        result = 31 * result + (hostCommentContent != null ? hostCommentContent.hashCode() : 0);
        result = 31 * result + (int) customerScore;
        return result;
    }
}
