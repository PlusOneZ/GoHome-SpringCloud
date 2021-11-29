package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/29
 **/

import javax.persistence.*;
import java.util.Objects;

/**
 * 此处写ViewHostStayCommentEntity类的描述
 * @author 梁乔
 * @since 2021/11/29 20:57 
 */
@Entity
@Table(name = "view_host_stay_comment", schema = "GoHome", catalog = "")
public class ViewHostStayCommentEntity {
    private int hostId;
    private long stayId;
    private long customerCommentId;
    private int stayScore;

    @Basic
    @Column(name = "host_id")
    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

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
    @Column(name = "customer_comment_id")
    public long getCustomerCommentId() {
        return customerCommentId;
    }

    public void setCustomerCommentId(long customerCommentId) {
        this.customerCommentId = customerCommentId;
    }

    @Basic
    @Column(name = "stay_score")
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
        ViewHostStayCommentEntity that = (ViewHostStayCommentEntity) o;
        return hostId == that.hostId && stayId == that.stayId && customerCommentId == that.customerCommentId && stayScore == that.stayScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostId, stayId, customerCommentId, stayScore);
    }
}