package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/29
 **/

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Objects;

/**
 * 此处写StayEntity类的描述
 * @author 梁乔
 * @since 2021/11/29 12:58 
 */
@Entity
@Table(name = "stay", schema = "GoHome", catalog = "")
public class StayEntity {
    private long stayId;
    private int hostId;
    private String stayName;
    private String stayTypeName;
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
    private BigDecimal commentScore;

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Basic
    @Column(name = "host_id")
    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
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
    @Column(name = "stay_type_name")
    public String getStayTypeName() {
        return stayTypeName;
    }

    public void setStayTypeName(String stayTypeName) {
        this.stayTypeName = stayTypeName;
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

    public void setPublicBathroom(int publicBathroom) {
        this.publicBathroom = publicBathroom;
    }

    @Basic
    @Column(name = "public_toilet")
    public int getPublicToilet() {
        return publicToilet;
    }

    public void setPublicToilet(int publicToilet) {
        this.publicToilet = publicToilet;
    }

    @Basic
    @Column(name = "non_barrier_facility")
    public int getNonBarrierFacility() {
        return nonBarrierFacility;
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
    public BigDecimal getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(BigDecimal commentScore) {
        this.commentScore = commentScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StayEntity that = (StayEntity) o;
        return stayId == that.stayId && hostId == that.hostId && stayCapacity == that.stayCapacity && roomAmount == that.roomAmount && bedAmount == that.bedAmount && publicBathroom == that.publicBathroom && publicToilet == that.publicToilet && nonBarrierFacility == that.nonBarrierFacility && durationMin == that.durationMin && durationMax == that.durationMax && commentAmount == that.commentAmount && Objects.equals(stayName, that.stayName) && Objects.equals(stayTypeName, that.stayTypeName) && Objects.equals(detailedAddress, that.detailedAddress) && Objects.equals(longitude, that.longitude) && Objects.equals(latitude, that.latitude) && Objects.equals(characteristic, that.characteristic) && Objects.equals(checkInTime, that.checkInTime) && Objects.equals(checkOutTime, that.checkOutTime) && Objects.equals(stayStatus, that.stayStatus) && Objects.equals(commentScore, that.commentScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, hostId, stayName, stayTypeName, detailedAddress, longitude, latitude, stayCapacity, roomAmount, bedAmount, publicBathroom, publicToilet, nonBarrierFacility, characteristic, checkInTime, checkOutTime, durationMin, durationMax, stayStatus, commentAmount, commentScore);
    }
}