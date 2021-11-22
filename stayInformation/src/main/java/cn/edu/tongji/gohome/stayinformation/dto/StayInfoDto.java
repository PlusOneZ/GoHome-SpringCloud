package cn.edu.tongji.gohome.stayinformation.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * 民宿详细信息的Dto
 *
 * @author 汪明杰
 * @date 2021/11/22 15:48
 */
public class StayInfoDto {
    private long stayId;
    private List<String> stayImages;
    private String stayName;
    private String stayDescription;
    private String characteristic;
    private String hostAvatar;
    private String hostLevel;
    private long hostCommentNum;
    private List<BigDecimal> stayPosition;
    private String hostName;
    private long roomNum;
    private long bedNum;
    private long stayCapacity;
    private long publicBathroom;
    private long publicToilet;
    private boolean nonBarrierFacility;
    private String startTime;
    private String endTime;
    private BigInteger stayStatus;
    private List<RoomInfoDto> rooms;

    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    public List<String> getStayImages() {
        return stayImages;
    }

    public void setStayImages(List<String> stayImages) {
        this.stayImages = stayImages;
    }

    public String getStayName() {
        return stayName;
    }

    public void setStayName(String stayName) {
        this.stayName = stayName;
    }

    public String getStayDescription() {
        return stayDescription;
    }

    public void setStayDescription(String stayDescription) {
        this.stayDescription = stayDescription;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getHostAvatar() {
        return hostAvatar;
    }

    public void setHostAvatar(String hostAvatar) {
        this.hostAvatar = hostAvatar;
    }

    public String getHostLevel() {
        return hostLevel;
    }

    public void setHostLevel(String hostLevel) {
        this.hostLevel = hostLevel;
    }

    public long getHostCommentNum() {
        return hostCommentNum;
    }

    public void setHostCommentNum(long hostCommentNum) {
        this.hostCommentNum = hostCommentNum;
    }

    public List<BigDecimal> getStayPosition() {
        return stayPosition;
    }

    public void setStayPosition(List<BigDecimal> stayPosition) {
        this.stayPosition = stayPosition;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public long getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(long roomNum) {
        this.roomNum = roomNum;
    }

    public long getBedNum() {
        return bedNum;
    }

    public void setBedNum(long bedNum) {
        this.bedNum = bedNum;
    }

    public long getStayCapacity() {
        return stayCapacity;
    }

    public void setStayCapacity(long stayCapacity) {
        this.stayCapacity = stayCapacity;
    }

    public long getPublicBathroom() {
        return publicBathroom;
    }

    public void setPublicBathroom(long publicBathroom) {
        this.publicBathroom = publicBathroom;
    }

    public long getPublicToilet() {
        return publicToilet;
    }

    public void setPublicToilet(long publicToilet) {
        this.publicToilet = publicToilet;
    }

    public boolean isNonBarrierFacility() {
        return nonBarrierFacility;
    }

    public void setNonBarrierFacility(boolean nonBarrierFacility) {
        this.nonBarrierFacility = nonBarrierFacility;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public BigInteger getStayStatus() {
        return stayStatus;
    }

    public void setStayStatus(BigInteger stayStatus) {
        this.stayStatus = stayStatus;
    }

    public List<RoomInfoDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomInfoDto> rooms) {
        this.rooms = rooms;
    }
}
