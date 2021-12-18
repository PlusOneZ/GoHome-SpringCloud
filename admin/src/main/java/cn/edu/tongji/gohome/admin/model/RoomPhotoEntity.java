package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_photo", schema = "GoHome", catalog = "")
@IdClass(RoomPhotoEntityPK.class)
public class RoomPhotoEntity {
    private Long stayId;
    private Integer roomId;
    private String roomPhotoLink;

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
    @Column(name = "room_photo_link")
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
        RoomPhotoEntity that = (RoomPhotoEntity) o;
        return Objects.equals(stayId, that.stayId) && Objects.equals(roomId, that.roomId) && Objects.equals(roomPhotoLink, that.roomPhotoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, roomPhotoLink);
    }
}
