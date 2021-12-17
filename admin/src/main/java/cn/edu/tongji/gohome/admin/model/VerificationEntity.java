package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "verification", schema = "GoHome", catalog = "")
public class VerificationEntity {
    private Long verificationId;
    private Long stayId;
    private Integer adminId;
    private BigInteger verificationResult;
    private String verificationReply;
    private Timestamp replyTime;

    @Id
    @Column(name = "verification_id")
    public Long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    @Basic
    @Column(name = "stay_id")
    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
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
        return Objects.equals(verificationId, that.verificationId) && Objects.equals(stayId, that.stayId) && Objects.equals(adminId, that.adminId) && Objects.equals(verificationResult, that.verificationResult) && Objects.equals(verificationReply, that.verificationReply) && Objects.equals(replyTime, that.replyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verificationId, stayId, adminId, verificationResult, verificationReply, replyTime);
    }
}
