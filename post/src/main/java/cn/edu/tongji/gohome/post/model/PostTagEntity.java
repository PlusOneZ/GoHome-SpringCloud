package cn.edu.tongji.gohome.post.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_tag", schema = "GoHome", catalog = "")
@IdClass(PostTagEntityPK.class)
public class PostTagEntity {
    private long postId;
    private String postTag;

    @Id
    @Column(name = "post_id")
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Id
    @Column(name = "post_tag")
    public String getPostTag() {
        return postTag;
    }

    public void setPostTag(String postTag) {
        this.postTag = postTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTagEntity that = (PostTagEntity) o;
        return postId == that.postId && Objects.equals(postTag, that.postTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postTag);
    }
}
