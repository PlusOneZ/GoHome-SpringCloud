package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;

/**
 * TODO
 *
 * @className: RoomPhotoEntity
 * @author: loey
 * @date: 2021-11-19 21:18
 **/
@Entity
@Table(name = "room_photo", schema = "GoHome", catalog = "")
@IdClass(RoomPhotoEntityPK.class)
public class RoomPhotoEntity {
    private long stayId;
    private int roomId;
    private String roomPhotoLink;

    @Id
    @Column(name = "stay_id", nullable = false)
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "room_id", nullable = false)
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Id
    @Column(name = "room_photo_link", nullable = false, length = 256)
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

        if (stayId != that.stayId) return false;
        if (roomId != that.roomId) return false;
        if (roomPhotoLink != null ? !roomPhotoLink.equals(that.roomPhotoLink) : that.roomPhotoLink != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + roomId;
        result = 31 * result + (roomPhotoLink != null ? roomPhotoLink.hashCode() : 0);
        return result;
    }
}