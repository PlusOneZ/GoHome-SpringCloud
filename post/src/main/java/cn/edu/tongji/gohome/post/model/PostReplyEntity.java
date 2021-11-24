package cn.edu.tongji.gohome.post.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post_reply", schema = "GoHome", catalog = "")
public class PostReplyEntity {
    private long replyId;
    private Timestamp replyTime;
    private String replyContent;
    private int replyLikeCount;
    private long postId;
    private long customerId;
    private Long preReplyId;

    @Id
    @Column(name = "reply_id")
    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
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
    public int getReplyLikeCount() {
        return replyLikeCount;
    }

    public void setReplyLikeCount(int replyLikeCount) {
        this.replyLikeCount = replyLikeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostReplyEntity that = (PostReplyEntity) o;
        return replyId == that.replyId && replyLikeCount == that.replyLikeCount && Objects.equals(replyTime, that.replyTime) && Objects.equals(replyContent, that.replyContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyId, replyTime, replyContent, replyLikeCount);
    }

    @Basic
    @Column(name = "post_id")
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "pre_reply_id")
    public Long getPreReplyId() {
        return preReplyId;
    }

    public void setPreReplyId(Long preReplyId) {
        this.preReplyId = preReplyId;
    }
}
