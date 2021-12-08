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
    private Timestamp orderStartTime;
    private Timestamp orderEndTime;
    private String stayName;
    private String detailedAddress;
    private String hostAvatarLink;
    private String hostName;
    private String stayProvince;
    private String stayCity;
    private BigDecimal totalCost;
    private int orderStatus;
    private int stayScore;
    private long stayId;
    private String customerCommentContent;
    private String roomPhotoLink;

    private int reportStatus;
    private String reportReason;
    private String reportReply;

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

    public Timestamp getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Timestamp orderStartTime) {
        this.orderStartTime = orderStartTime;
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

    public String getCustomerCommentContent() {
        return customerCommentContent;
    }

    public void setCustomerCommentContent(String customerCommentContent) {
        this.customerCommentContent = customerCommentContent;
    }

    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    public int getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(int reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public String getReportReply() {
        return reportReply;
    }

    public void setReportReply(String reportReply) {
        this.reportReply = reportReply;
    }

    public String getStayProvince() {
        return stayProvince;
    }

    public void setStayProvince(String stayProvince) {
        this.stayProvince = stayProvince;
    }

    public String getStayCity() {
        return stayCity;
    }

    public void setStayCity(String stayCity) {
        this.stayCity = stayCity;
    }
}