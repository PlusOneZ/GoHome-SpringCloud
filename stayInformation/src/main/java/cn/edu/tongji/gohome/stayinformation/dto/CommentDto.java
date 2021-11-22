package cn.edu.tongji.gohome.stayinformation.dto;

import java.sql.Timestamp;

/**
 * CommentDto 类
 *
 * @author 汪明杰
 * @date 2021/11/22 18:27
 */
public class CommentDto{
    private long id;
    private String nickName;
    private String avatar;
    private Timestamp date;
    private String commentContent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
