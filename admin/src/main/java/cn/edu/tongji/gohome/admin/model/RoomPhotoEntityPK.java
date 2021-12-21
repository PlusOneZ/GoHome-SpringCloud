package cn.edu.tongji.gohome.admin.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RoomPhotoEntityPK implements Serializable {
    private Long stayId;
    private Integer roomId;
    private String roomPhotoLink;

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

    @Column(name = "room_photo_link")
    @Id
    public String getRoomPhotoLink() {
        return roomPhotoLink;
    }

    public void setRoomPhotoLink(String roomPhotoLink) {
        this.roomPhotoLink = roomPhotoLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomPhotoEntityPK that = (RoomPhotoEntityPK) o;
        return Objects.equals(stayId, that.stayId) && Objects.equals(roomId, that.roomId) && Objects.equals(roomPhotoLink, that.roomPhotoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, roomPhotoLink);
    }
}
