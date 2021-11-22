package
        cn.edu.tongji.gohome.order.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * This is a class for order detailed information about room...
 *
 * @className: OrderDetailedInfoDto
 * @author: loey
 * @date: 2021-11-22 19:58
 **/
public class OrderDetailedInfoDto {
    private long stayId;
    private long roomId;
    private Timestamp startTime;
    private Timestamp endTime;
    private BigDecimal moneyAmount;
    private String roomPhotoLink;

    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public String getRoomPhotoLink() {
        return roomPhotoLink;
    }

    public void setRoomPhotoLink(String roomPhotoLink) {
        this.roomPhotoLink = roomPhotoLink;
    }
}