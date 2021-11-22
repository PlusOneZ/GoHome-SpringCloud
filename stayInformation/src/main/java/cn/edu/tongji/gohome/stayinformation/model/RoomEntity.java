package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * TODO:此处写RoomEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "room", schema = "GoHome", catalog = "")
@IdClass(RoomEntityPK.class)
public class RoomEntity {
    private long stayId;
    private int roomId;
    private BigDecimal price;
    private BigDecimal roomArea;
    private Integer bathroomAmount;

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "room_area")
    public BigDecimal getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(BigDecimal roomArea) {
        this.roomArea = roomArea;
    }

    @Basic
    @Column(name = "bathroom_amount")
    public Integer getBathroomAmount() {
        return bathroomAmount;
    }

    public void setBathroomAmount(Integer bathroomAmount) {
        this.bathroomAmount = bathroomAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (stayId != that.stayId) return false;
        if (roomId != that.roomId) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (roomArea != null ? !roomArea.equals(that.roomArea) : that.roomArea != null) return false;
        if (bathroomAmount != null ? !bathroomAmount.equals(that.bathroomAmount) : that.bathroomAmount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + roomId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (roomArea != null ? roomArea.hashCode() : 0);
        result = 31 * result + (bathroomAmount != null ? bathroomAmount.hashCode() : 0);
        return result;
    }
}
