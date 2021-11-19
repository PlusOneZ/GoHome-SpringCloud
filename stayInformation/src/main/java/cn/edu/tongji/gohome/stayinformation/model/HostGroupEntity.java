package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写HostGroupEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
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

        if (hostLevel != that.hostLevel) return false;
        if (hostLevelName != null ? !hostLevelName.equals(that.hostLevelName) : that.hostLevelName != null)
            return false;
        if (hostLevelDegree != null ? !hostLevelDegree.equals(that.hostLevelDegree) : that.hostLevelDegree != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hostLevel;
        result = 31 * result + (hostLevelName != null ? hostLevelName.hashCode() : 0);
        result = 31 * result + (hostLevelDegree != null ? hostLevelDegree.hashCode() : 0);
        return result;
    }
}
