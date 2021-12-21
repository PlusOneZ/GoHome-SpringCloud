package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_bed", schema = "GoHome", catalog = "")
@IdClass(RoomBedEntityPK.class)
public class RoomBedEntity {
    private Long stayId;
    private Integer roomId;
    private String bedType;
    private Integer bedAmount;

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

    @Id
    @Column(name = "bed_type")
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Basic
    @Column(name = "bed_amount")
    public Integer getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(Integer bedAmount) {
        this.bedAmount = bedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBedEntity that = (RoomBedEntity) o;
        return Objects.equals(stayId, that.stayId) && Objects.equals(roomId, that.roomId) && Objects.equals(bedType, that.bedType) && Objects.equals(bedAmount, that.bedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, bedType, bedAmount);
    }
}
