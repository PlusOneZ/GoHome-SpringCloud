package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto;/**
 * @author 梁乔 2021/11/23
 **/

/**
 * 用户评论Dto
 * @author 梁乔
 * @date 2021/11/23 10:06 
 */
public class HostCommentDto {
    private String commentTime;
    private String hostNickName;
    private String hostRegisterDate;
    private String hostAvatar;
    private String comment;
    private int commentStar;
    private int hostId;

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getHostRegisterDate() {
        return hostRegisterDate;
    }

    public void setHostRegisterDate(String hostRegisterDate) {
        this.hostRegisterDate = hostRegisterDate;
    }

    public String getHostNickName() {
        return hostNickName;
    }

    public void setHostNickName(String hostNickName) {
        this.hostNickName = hostNickName;
    }

    public String getHostAvatar() {
        return hostAvatar;
    }

    public void setHostAvatar(String hostAvatar) {
        this.hostAvatar = hostAvatar;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCommentStar() {
        return commentStar;
    }

    public void setCommentStar(int commentStar) {
        this.commentStar = commentStar;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }
}
