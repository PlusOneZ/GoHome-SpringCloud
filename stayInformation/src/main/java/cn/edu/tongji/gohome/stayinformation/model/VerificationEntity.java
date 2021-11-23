package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * TODO:此处写VerificationEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "verification", schema = "GoHome", catalog = "")
public class VerificationEntity {
    private long verificationId;
    private Integer adminId;
    private BigInteger verificationResult;
    private String verificationReply;
    private Timestamp replyTime;

    @Id
    @Column(name = "verification_id")
    public long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(long verificationId) {
        this.verificationId = verificationId;
    }

    @Basic
    @Column(name = "admin_id")
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "verification_result")
    public BigInteger getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(BigInteger verificationResult) {
        this.verificationResult = verificationResult;
    }

    @Basic
    @Column(name = "verification_reply")
    public String getVerificationReply() {
        return verificationReply;
    }

    public void setVerificationReply(String verificationReply) {
        this.verificationReply = verificationReply;
    }

    @Basic
    @Column(name = "reply_time")
    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerificationEntity that = (VerificationEntity) o;

        if (verificationId != that.verificationId) return false;
        if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null) return false;
        if (verificationResult != null ? !verificationResult.equals(that.verificationResult) : that.verificationResult != null)
            return false;
        if (verificationReply != null ? !verificationReply.equals(that.verificationReply) : that.verificationReply != null)
            return false;
        if (replyTime != null ? !replyTime.equals(that.replyTime) : that.replyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (verificationId ^ (verificationId >>> 32));
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        result = 31 * result + (verificationResult != null ? verificationResult.hashCode() : 0);
        result = 31 * result + (verificationReply != null ? verificationReply.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        return result;
    }
}
