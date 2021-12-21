package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "GoHome", catalog = "")
@IdClass(RoomEntityPK.class)
public class RoomEntity {
    private Long stayId;
    private Integer roomId;
    private BigDecimal price;
    private BigDecimal roomArea;
    private Integer bathroomAmount;

    @Id
    @Column(name = "stay_id")
    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
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
        return Objects.equals(stayId, that.stayId) && Objects.equals(roomId, that.roomId) && Objects.equals(price, that.price) && Objects.equals(roomArea, that.roomArea) && Objects.equals(bathroomAmount, that.bathroomAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, price, roomArea, bathroomAmount);
    }
}
