package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post_reply", schema = "GoHome", catalog = "")
public class PostReplyEntity {
    private Long replyId;
    private Long postId;
    private Long customerId;
    private Timestamp replyTime;
    private String replyContent;
    private Integer replyLikeCount;
    private Long preReplyId;

    @Id
    @Column(name = "reply_id")
    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    @Basic
    @Column(name = "post_id")
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "reply_time")
    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

    @Basic
    @Column(name = "reply_content")
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "reply_like_count")
    public Integer getReplyLikeCount() {
        return replyLikeCount;
    }

    public void setReplyLikeCount(Integer replyLikeCount) {
        this.replyLikeCount = replyLikeCount;
    }

    @Basic
    @Column(name = "pre_reply_id")
    public Long getPreReplyId() {
        return preReplyId;
    }

    public void setPreReplyId(Long preReplyId) {
        this.preReplyId = preReplyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostReplyEntity that = (PostReplyEntity) o;
        return Objects.equals(replyId, that.replyId) && Objects.equals(postId, that.postId) && Objects.equals(customerId, that.customerId) && Objects.equals(replyTime, that.replyTime) && Objects.equals(replyContent, that.replyContent) && Objects.equals(replyLikeCount, that.replyLikeCount) && Objects.equals(preReplyId, that.preReplyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyId, postId, customerId, replyTime, replyContent, replyLikeCount, preReplyId);
    }
}
