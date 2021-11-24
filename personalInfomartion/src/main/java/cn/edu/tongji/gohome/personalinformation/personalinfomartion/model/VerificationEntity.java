package cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * verificationEntity类
 * @author 梁乔
 * @since 2021/11/23 16:59
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
        return verificationId == that.verificationId && Objects.equals(adminId, that.adminId) && Objects.equals(verificationResult, that.verificationResult) && Objects.equals(verificationReply, that.verificationReply) && Objects.equals(replyTime, that.replyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verificationId, adminId, verificationResult, verificationReply, replyTime);
    }
}