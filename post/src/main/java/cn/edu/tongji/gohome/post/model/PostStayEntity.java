package cn.edu.tongji.gohome.post.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_stay", schema = "GoHome", catalog = "")
@IdClass(PostStayEntityPK.class)
public class PostStayEntity {
    private long postId;
    private long stayId;

    @Id
    @Column(name = "post_id")
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostStayEntity that = (PostStayEntity) o;
        return postId == that.postId && stayId == that.stayId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, stayId);
    }
}
