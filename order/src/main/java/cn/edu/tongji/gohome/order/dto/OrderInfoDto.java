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
}