package
        cn.edu.tongji.gohome.trade.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * class description
 *
 * @author : loey
 * @className : RoomInfoDto
 * @since : 2021-11-25 23:23
 **/
public class RoomInfoDto {

    private long stayId;
    private int roomId;
    private Timestamp startTime;
    private Timestamp endTime;
    private BigDecimal moneyAmount;

    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
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

    @Override
    public String toString() {
        return "RoomInfoDto{" +
                "stayId=" + stayId +
                ", roomId=" + roomId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", moneyAmount=" + moneyAmount +
                '}';
    }
}