package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "stay", schema = "GoHome", catalog = "")
public class StayEntity {
    private Long stayId;
    private Integer hostId;
    private String stayName;
    private String stayTypeName;
    private String detailedAddress;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Integer stayCapacity;
    private Integer roomAmount;
    private Integer bedAmount;
    private Integer publicBathroom;
    private Integer publicToilet;
    private Integer nonBarrierFacility;
    private String characteristic;
    private Time checkInTime;
    private Time checkOutTime;
    private Integer durationMin;
    private Integer durationMax;
    private BigInteger stayStatus;
    private Integer commentAmount;
    private BigDecimal commentScore;

    @Id
    @Column(name = "stay_id")
    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    @Basic
    @Column(name = "host_id")
    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
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
    public Integer getStayCapacity() {
        return stayCapacity;
    }

    public void setStayCapacity(Integer stayCapacity) {
        this.stayCapacity = stayCapacity;
    }

    @Basic
    @Column(name = "room_amount")
    public Integer getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    @Basic
    @Column(name = "bed_amount")
    public Integer getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(Integer bedAmount) {
        this.bedAmount = bedAmount;
    }

    @Basic
    @Column(name = "public_bathroom")
    public Integer getPublicBathroom() {
        return publicBathroom;
    }

    public void setPublicBathroom(Integer publicBathroom) {
        this.publicBathroom = publicBathroom;
    }

    @Basic
    @Column(name = "public_toilet")
    public Integer getPublicToilet() {
        return publicToilet;
    }

    public void setPublicToilet(Integer publicToilet) {
        this.publicToilet = publicToilet;
    }

    @Basic
    @Column(name = "non_barrier_facility")
    public Integer getNonBarrierFacility() {
        return nonBarrierFacility;
    }

    public void setNonBarrierFacility(Integer nonBarrierFacility) {
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
    public Integer getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Integer durationMin) {
        this.durationMin = durationMin;
    }

    @Basic
    @Column(name = "duration_max")
    public Integer getDurationMax() {
        return durationMax;
    }

    public void setDurationMax(Integer durationMax) {
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
    public Integer getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(Integer commentAmount) {
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
        return Objects.equals(stayId, that.stayId) && Objects.equals(hostId, that.hostId) && Objects.equals(stayName, that.stayName) && Objects.equals(stayTypeName, that.stayTypeName) && Objects.equals(detailedAddress, that.detailedAddress) && Objects.equals(longitude, that.longitude) && Objects.equals(latitude, that.latitude) && Objects.equals(stayCapacity, that.stayCapacity) && Objects.equals(roomAmount, that.roomAmount) && Objects.equals(bedAmount, that.bedAmount) && Objects.equals(publicBathroom, that.publicBathroom) && Objects.equals(publicToilet, that.publicToilet) && Objects.equals(nonBarrierFacility, that.nonBarrierFacility) && Objects.equals(characteristic, that.characteristic) && Objects.equals(checkInTime, that.checkInTime) && Objects.equals(checkOutTime, that.checkOutTime) && Objects.equals(durationMin, that.durationMin) && Objects.equals(durationMax, that.durationMax) && Objects.equals(stayStatus, that.stayStatus) && Objects.equals(commentAmount, that.commentAmount) && Objects.equals(commentScore, that.commentScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, hostId, stayName, stayTypeName, detailedAddress, longitude, latitude, stayCapacity, roomAmount, bedAmount, publicBathroom, publicToilet, nonBarrierFacility, characteristic, checkInTime, checkOutTime, durationMin, durationMax, stayStatus, commentAmount, commentScore);
    }
}
