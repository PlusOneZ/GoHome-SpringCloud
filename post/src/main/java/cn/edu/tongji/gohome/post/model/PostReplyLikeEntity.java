package cn.edu.tongji.gohome.post.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_reply_like", schema = "GoHome", catalog = "")
@IdClass(PostReplyLikeEntityPK.class)
public class PostReplyLikeEntity {
    private long replyId;
    private long customerId;

    @Id
    @Column(name = "reply_id")
    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    @Id
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostReplyLikeEntity that = (PostReplyLikeEntity) o;
        return replyId == that.replyId && customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyId, customerId);
    }
}
