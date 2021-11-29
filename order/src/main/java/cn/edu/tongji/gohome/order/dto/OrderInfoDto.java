package
        cn.edu.tongji.gohome.order.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * This is a Dto which contains the information of order, comments and room...
 * @className: OrderInfoDto
 * @author: loey
 * @date: 2021-11-21 15:00
 **/
public class OrderInfoDto {

    private long orderId;
    private Timestamp orderTime;
    private Timestamp orderStarTime;
    private Timestamp orderEndTime;
    private String stayName;
    private String detailedAddress;
    private String hostAvatarLink;
    private String hostName;
    private BigDecimal totalCost;
    private int orderStatus;
    private int stayScore;
    private String roomPhotoLink;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getStayScore() {
        return stayScore;
    }

    public void setStayScore(int stayScore) {
        this.stayScore = stayScore;
    }

    public String getRoomPhotoLink() {
        return roomPhotoLink;
    }

    public void setRoomPhotoLink(String roomPhotoLink) {
        this.roomPhotoLink = roomPhotoLink;
    }

    public Timestamp getOrderStarTime() {
        return orderStarTime;
    }

    public void setOrderStarTime(Timestamp orderStarTime) {
        this.orderStarTime = orderStarTime;
    }

    public Timestamp getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Timestamp orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public String getStayName() {
        return stayName;
    }

    public void setStayName(String stayName) {
        this.stayName = stayName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getHostAvatarLink() {
        return hostAvatarLink;
    }

    public void setHostAvatarLink(String hostAvatarLink) {
        this.hostAvatarLink = hostAvatarLink;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}