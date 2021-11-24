package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO
 *
 * @className: RoomPhotoEntityPK
 * @author: loey
 * @date: 2021-11-19 21:18
 **/
public class RoomPhotoEntityPK implements Serializable {
    private long stayId;
    private int roomId;
    private String roomPhotoLink;

    @Column(name = "stay_id", nullable = false)
    @Id
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Column(name = "room_id", nullable = false)
    @Id
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Column(name = "room_photo_link", nullable = false, length = 256)
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