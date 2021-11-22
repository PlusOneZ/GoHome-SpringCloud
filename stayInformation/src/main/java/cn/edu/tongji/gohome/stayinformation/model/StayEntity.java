package cn.edu.tongji.gohome.stayinformation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;

/**
 * TODO:此处写StayEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Table(name = "stay", schema = "GoHome", catalog = "")
public class StayEntity {
    private long stayId;
    private String stayName;
    private String detailedAddress;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private int stayCapacity;
    private int roomAmount;
    private int bedAmount;
    private int publicBathroom;
    private int publicToilet;
    private int nonBarrierFacility;
    private String characteristic;
    private Time checkInTime;
    private Time checkOutTime;
    private int durationMin;
    private int durationMax;
    private BigInteger stayStatus;
    private int commentAmount;
    private int commentScore;
    private int hostId;

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Basic
    @Column(name = "stay_name")
    public String getStayName() {
        return stayName;
    }

    public void setStayName(String stayName) {
        this.stayName = stayName;
    }

    @Basic
    @Column(name = "detailed_address")
    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    @Basic
    @Column(name = "longitude")
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "stay_capacity")
    public int getStayCapacity() {
        return stayCapacity;
    }

    public void setStayCapacity(int stayCapacity) {
        this.stayCapacity = stayCapacity;
    }

    @Basic
    @Column(name = "room_amount")
    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    @Basic
    @Column(name = "bed_amount")
    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    @Basic
    @Column(name = "public_bathroom")
    public int getPublicBathroom() {
        return publicBathroom;
    }

    public void setPublicBathroom(byte publicBathroom) {
        this.publicBathroom = publicBathroom;
    }

    public void setPublicBathroom(int publicBathroom) {
        this.publicBathroom = publicBathroom;
    }

    @Basic
    @Column(name = "public_toilet")
    public int getPublicToilet() {
        return publicToilet;
    }

    public void setPublicToilet(byte publicToilet) {
        this.publicToilet = publicToilet;
    }

    public void setPublicToilet(int publicToilet) {
        this.publicToilet = publicToilet;
    }

    @Basic
    @Column(name = "non_barrier_facility")
    public int getNonBarrierFacility() {
        return nonBarrierFacility;
    }

    public void setNonBarrierFacility(byte nonBarrierFacility) {
        this.nonBarrierFacility = nonBarrierFacility;
    }

    public void setNonBarrierFacility(int nonBarrierFacility) {
        this.nonBarrierFacility = nonBarrierFacility;
    }

    @Basic
    @Column(name = "characteristic")
    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    @Basic
    @Column(name = "check_in_time")
    public Time getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Time checkInTime) {
        this.checkInTime = checkInTime;
    }

    @Basic
    @Column(name = "check_out_time")
    public Time getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Time checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    @Basic
    @Column(name = "duration_min")
    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    @Basic
    @Column(name = "duration_max")
    public int getDurationMax() {
        return durationMax;
    }

    public void setDurationMax(int durationMax) {
        this.durationMax = durationMax;
    }

    @Basic
    @Column(name = "stay_status")
    public BigInteger getStayStatus() {
        return stayStatus;
    }

    public void setStayStatus(BigInteger stayStatus) {
        this.stayStatus = stayStatus;
    }

    @Basic
    @Column(name = "comment_amount")
    public int getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(int commentAmount) {
        this.commentAmount = commentAmount;
    }

    @Basic
    @Column(name = "comment_score")
    public int getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(int commentScore) {
        this.commentScore = commentScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StayEntity that = (StayEntity) o;

        if (stayId != that.stayId) return false;
        if (stayCapacity != that.stayCapacity) return false;
        if (roomAmount != that.roomAmount) return false;
        if (bedAmount != that.bedAmount) return false;
        if (publicBathroom != that.publicBathroom) return false;
        if (publicToilet != that.publicToilet) return false;
        if (nonBarrierFacility != that.nonBarrierFacility) return false;
        if (durationMin != that.durationMin) return false;
        if (durationMax != that.durationMax) return false;
        if (commentAmount != that.commentAmount) return false;
        if (commentScore != that.commentScore) return false;
        if (stayName != null ? !stayName.equals(that.stayName) : that.stayName != null) return false;
        if (detailedAddress != null ? !detailedAddress.equals(that.detailedAddress) : that.detailedAddress != null)
            return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (characteristic != null ? !characteristic.equals(that.characteristic) : that.characteristic != null)
            return false;
        if (checkInTime != null ? !checkInTime.equals(that.checkInTime) : that.checkInTime != null) return false;
        if (checkOutTime != null ? !checkOutTime.equals(that.checkOutTime) : that.checkOutTime != null) return false;
        if (stayStatus != null ? !stayStatus.equals(that.stayStatus) : that.stayStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (stayName != null ? stayName.hashCode() : 0);
        result = 31 * result + (detailedAddress != null ? detailedAddress.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + stayCapacity;
        result = 31 * result + roomAmount;
        result = 31 * result + bedAmount;
        result = 31 * result + (int) publicBathroom;
        result = 31 * result + (int) publicToilet;
        result = 31 * result + (int) nonBarrierFacility;
        result = 31 * result + (characteristic != null ? characteristic.hashCode() : 0);
        result = 31 * result + (checkInTime != null ? checkInTime.hashCode() : 0);
        result = 31 * result + (checkOutTime != null ? checkOutTime.hashCode() : 0);
        result = 31 * result + durationMin;
        result = 31 * result + durationMax;
        result = 31 * result + (stayStatus != null ? stayStatus.hashCode() : 0);
        result = 31 * result + commentAmount;
        result = 31 * result + commentScore;
        return result;
    }

    @Basic
    @Column(name = "host_id")
    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }
}
