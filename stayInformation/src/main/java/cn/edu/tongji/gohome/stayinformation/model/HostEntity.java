package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * TODO:此处写HostEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "`host`", schema = "GoHome", catalog = "")
public class HostEntity {
    private int hostId;
    private Timestamp hostCreateTime;
    private String hostResidentId;
    private String hostRealName;
    private int hostScore;
    private int hostState;
    private Integer hostLevel;
    private long customerId;

    @Id
    @Column(name = "host_id")
    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
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
    public int getHostScore() {
        return hostScore;
    }

    public void setHostScore(int hostScore) {
        this.hostScore = hostScore;
    }

    @Basic
    @Column(name = "host_state")
    public int getHostState() {
        return hostState;
    }

    public void setHostState(int hostState) {
        this.hostState = hostState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HostEntity that = (HostEntity) o;

        if (hostId != that.hostId) return false;
        if (hostScore != that.hostScore) return false;
        if (hostState != that.hostState) return false;
        if (hostCreateTime != null ? !hostCreateTime.equals(that.hostCreateTime) : that.hostCreateTime != null)
            return false;
        if (hostResidentId != null ? !hostResidentId.equals(that.hostResidentId) : that.hostResidentId != null)
            return false;
        if (hostRealName != null ? !hostRealName.equals(that.hostRealName) : that.hostRealName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hostId;
        result = 31 * result + (hostCreateTime != null ? hostCreateTime.hashCode() : 0);
        result = 31 * result + (hostResidentId != null ? hostResidentId.hashCode() : 0);
        result = 31 * result + (hostRealName != null ? hostRealName.hashCode() : 0);
        result = 31 * result + hostScore;
        result = 31 * result + hostState;
        return result;
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
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
