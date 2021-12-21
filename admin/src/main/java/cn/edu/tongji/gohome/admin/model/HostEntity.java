package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "host", schema = "GoHome", catalog = "")
public class HostEntity {
    private Integer hostId;
    private Timestamp hostCreateTime;
    private String hostResidentId;
    private String hostRealName;
    private Integer hostScore;
    private Integer hostState;
    private Integer hostLevel;
    private Long customerId;

    @Id
    @Column(name = "host_id")
    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    @Basic
    @Column(name = "host_create_time")
    public Timestamp getHostCreateTime() {
        return hostCreateTime;
    }

    public void setHostCreateTime(Timestamp hostCreateTime) {
        this.hostCreateTime = hostCreateTime;
    }

    @Basic
    @Column(name = "host_resident_id")
    public String getHostResidentId() {
        return hostResidentId;
    }

    public void setHostResidentId(String hostResidentId) {
        this.hostResidentId = hostResidentId;
    }

    @Basic
    @Column(name = "host_real_name")
    public String getHostRealName() {
        return hostRealName;
    }

    public void setHostRealName(String hostRealName) {
        this.hostRealName = hostRealName;
    }

    @Basic
    @Column(name = "host_score")
    public Integer getHostScore() {
        return hostScore;
    }

    public void setHostScore(Integer hostScore) {
        this.hostScore = hostScore;
    }

    @Basic
    @Column(name = "host_state")
    public Integer getHostState() {
        return hostState;
    }

    public void setHostState(Integer hostState) {
        this.hostState = hostState;
    }

    @Basic
    @Column(name = "host_level")
    public Integer getHostLevel() {
        return hostLevel;
    }

    public void setHostLevel(Integer hostLevel) {
        this.hostLevel = hostLevel;
    }

    @Basic
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HostEntity that = (HostEntity) o;
        return Objects.equals(hostId, that.hostId) && Objects.equals(hostCreateTime, that.hostCreateTime) && Objects.equals(hostResidentId, that.hostResidentId) && Objects.equals(hostRealName, that.hostRealName) && Objects.equals(hostScore, that.hostScore) && Objects.equals(hostState, that.hostState) && Objects.equals(hostLevel, that.hostLevel) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostId, hostCreateTime, hostResidentId, hostRealName, hostScore, hostState, hostLevel, customerId);
    }
}
