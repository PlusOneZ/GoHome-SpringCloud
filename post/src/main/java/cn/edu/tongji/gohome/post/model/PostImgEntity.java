package cn.edu.tongji.gohome.post.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_img", schema = "GoHome", catalog = "")
@IdClass(PostImgEntityPK.class)
public class PostImgEntity {
    private long postId;
    private String postImgLink;

    @Id
    @Column(name = "post_id")
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Id
    @Column(name = "post_img_link")
    public String getPostImgLink() {
        return postImgLink;
    }

    public void setPostImgLink(String postImgLink) {
        this.postImgLink = postImgLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostImgEntity that = (PostImgEntity) o;
        return postId == that.postId && Objects.equals(postImgLink, that.postImgLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postImgLink);
    }
}
