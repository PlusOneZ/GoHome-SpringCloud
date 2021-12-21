package cn.edu.tongji.gohome.admin.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RoomBedEntityPK implements Serializable {
    private Long stayId;
    private Integer roomId;
    private String bedType;

    @Column(name = "stay_id")
    @Id
    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    @Column(name = "room_id")
    @Id
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Column(name = "bed_type")
    @Id
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBedEntityPK that = (RoomBedEntityPK) o;
        return Objects.equals(stayId, that.stayId) && Objects.equals(roomId, that.roomId) && Objects.equals(bedType, that.bedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, bedType);
    }
}
