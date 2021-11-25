package cn.edu.tongji.gohome.stayinformation.dto;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

/**
 * 用于插入、修改房源的实体
 *
 * @author 汪明杰
 * @date 2021/11/23 16:15
 */
public class HostStay {
    private String stayType;
    private int maxTenantNum;
    private int roomNum;
    private int bedNum;
    private int pubRestNum;
    private int pubBathNum;
    private int barrierFree;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String stayName;
    private String stayChars;
    private String startTime;
    private String endTime;
    private int minDay;
    private int maxDay;
    private String struPos;
    private int stayStatus;
    private List<HostStayRoom> roomInfo;
    private List<String> stayTags;

    public String getStayType() {
        return stayType;
    }

    public void setStayType(String stayType) {
        this.stayType = stayType;
    }

    public int getMaxTenantNum() {
        return maxTenantNum;
    }

    public void setMaxTenantNum(int maxTenantNum) {
        this.maxTenantNum = maxTenantNum;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public int getPubRestNum() {
        return pubRestNum;
    }

    public void setPubRestNum(int pubRestNum) {
        this.pubRestNum = pubRestNum;
    }

    public int getPubBathNum() {
        return pubBathNum;
    }

    public void setPubBathNum(int pubBathNum) {
        this.pubBathNum = pubBathNum;
    }

    public int getBarrierFree() {
        return barrierFree;
    }

    public void setBarrierFree(int barrierFree) {
        this.barrierFree = barrierFree;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getStayName() {
        return stayName;
    }

    public void setStayName(String stayName) {
        this.stayName = stayName;
    }

    public String getStayChars() {
        return stayChars;
    }

    public void setStayChars(String stayChars) {
        this.stayChars = stayChars;
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

    public int getMinDay() {
        return minDay;
    }

    public void setMinDay(int minDay) {
        this.minDay = minDay;
    }

    public int getMaxDay() {
        return maxDay;
    }

    public void setMaxDay(int maxDay) {
        this.maxDay = maxDay;
    }

    public String getStruPos() {
        return struPos;
    }

    public void setStruPos(String struPos) {
        this.struPos = struPos;
    }

    public int getStayStatus() {
        return stayStatus;
    }

    public void setStayStatus(int stayStatus) {
        this.stayStatus = stayStatus;
    }

    public List<HostStayRoom> getRoomInfo() {
        return roomInfo;
    }

    public void setRoomInfo(List<HostStayRoom> roomInfo) {
        this.roomInfo = roomInfo;
    }

    public List<String> getStayTags() {
        return stayTags;
    }

    public void setStayTags(List<String> stayTags) {
        this.stayTags = stayTags;
    }
}
