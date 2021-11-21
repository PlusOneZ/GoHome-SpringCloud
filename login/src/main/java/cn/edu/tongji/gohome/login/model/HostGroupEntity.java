package cn.edu.tongji.gohome.login.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * HostGroupEntity: JPA 自动生成
 *
 * @author 卓正一
 * @since  2021/11/19 6:47 PM
 */
@Entity
@Table(name = "host_group", schema = "GoHome", catalog = "")
public class HostGroupEntity {
    private int hostLevel;
    private String hostLevelName;
    private Long hostLevelDegree;

    @Id
    @Column(name = "host_level")
    public int getHostLevel() {
        return hostLevel;
    }

    public void setHostLevel(int hostLevel) {
        this.hostLevel = hostLevel;
    }

    @Basic
    @Column(name = "host_level_name")
    public String getHostLevelName() {
        return hostLevelName;
    }

    public void setHostLevelName(String hostLevelName) {
        this.hostLevelName = hostLevelName;
    }

    @Basic
    @Column(name = "host_level_degree")
    public Long getHostLevelDegree() {
        return hostLevelDegree;
    }

    public void setHostLevelDegree(Long hostLevelDegree) {
        this.hostLevelDegree = hostLevelDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HostGroupEntity that = (HostGroupEntity) o;
        return hostLevel == that.hostLevel && Objects.equals(hostLevelName, that.hostLevelName) && Objects.equals(hostLevelDegree, that.hostLevelDegree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostLevel, hostLevelName, hostLevelDegree);
    }
}
