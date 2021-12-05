package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto;/**
 * @author 梁乔 2021/11/29
 **/

import java.math.BigDecimal;
import java.util.List;

/**
 * 此处写FavoriteStayInfo类的描述
 * @author 梁乔
 * @since 2021/11/29 12:50 
 */
public class FavoriteStayInfoDto {
    private long stayID;
    private String stayName;
    private String stayCharacteristic;
    private Boolean stayHasPath;
    private Boolean stayHasWashRoom;
    private Boolean stayHasFacility;
    private BigDecimal stayRate;
    private BigDecimal stayMinPrice;
    private List<String> stayPhotoList;
    private int commentNum;
    private String hostAvatar;

    public long getStayID() {
        return stayID;
    }

    public void setStayID(long stayID) {
        this.stayID = stayID;
    }

    public String getStayName() {
        return stayName;
    }

    public String getStayCharacteristic() {
        return stayCharacteristic;
    }

    public String getHostAvatar() {
        return hostAvatar;
    }

    public void setHostAvatar(String hostAvatar) {
        this.hostAvatar = hostAvatar;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public List<String> getStayPhotoList() {
        return stayPhotoList;
    }

    public void setStayPhotoList(List<String> stayPhotoList) {
        this.stayPhotoList = stayPhotoList;
    }

    public BigDecimal getStayMinPrice() {
        return stayMinPrice;
    }

    public void setStayMinPrice(BigDecimal stayMinPrice) {
        this.stayMinPrice = stayMinPrice;
    }

    public BigDecimal getStayRate() {
        return stayRate;
    }

    public void setStayRate(BigDecimal stayRate) {
        this.stayRate = stayRate;
    }

    public Boolean getStayHasFacility() {
        return stayHasFacility;
    }

    public void setStayHasFacility(Boolean stayHasFacility) {
        this.stayHasFacility = stayHasFacility;
    }

    public Boolean getStayHasWashRoom() {
        return stayHasWashRoom;
    }

    public void setStayHasWashRoom(Boolean stayHasWashRoom) {
        this.stayHasWashRoom = stayHasWashRoom;
    }

    public Boolean getStayHasPath() {
        return stayHasPath;
    }

    public void setStayHasPath(Boolean stayHasPath) {
        this.stayHasPath = stayHasPath;
    }

    public void setStayCharacteristic(String stayCharacteristic) {
        this.stayCharacteristic = stayCharacteristic;
    }

    public void setStayName(String stayName) {
        this.stayName = stayName;
    }
}