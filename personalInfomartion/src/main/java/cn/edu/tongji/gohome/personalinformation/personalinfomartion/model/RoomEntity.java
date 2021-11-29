package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/29
 **/

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 此处写RoomEntity类的描述
 * @author 梁乔
 * @since 2021/11/29 13:05 
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
        return stayId == that.stayId && roomId == that.roomId && Objects.equals(price, that.price) && Objects.equals(roomArea, that.roomArea) && Objects.equals(bathroomAmount, that.bathroomAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, price, roomArea, bathroomAmount);
    }
}