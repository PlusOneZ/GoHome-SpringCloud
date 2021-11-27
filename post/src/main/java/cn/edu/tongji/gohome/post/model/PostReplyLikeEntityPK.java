package cn.edu.tongji.gohome.post.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostReplyLikeEntityPK implements Serializable {
    private long replyId;
    private long customerId;

    @Column(name = "reply_id")
    @Id
    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    @Column(name = "customer_id")
    @Id
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
        PostReplyLikeEntityPK that = (PostReplyLikeEntityPK) o;
        return replyId == that.replyId && customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyId, customerId);
    }
}
