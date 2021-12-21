package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "administrator", schema = "GoHome", catalog = "")
public class AdministratorEntity {
    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private String adminAvatarLink;
    private Timestamp adminCreateTime;
    private String adminTel;

    @Id
    @Column(name = "admin_id")
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "admin_name")
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "admin_password")
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Basic
    @Column(name = "admin_avatar_link")
    public String getAdminAvatarLink() {
        return adminAvatarLink;
    }

    public void setAdminAvatarLink(String adminAvatarLink) {
        this.adminAvatarLink = adminAvatarLink;
    }

    @Basic
    @Column(name = "admin_create_time")
    public Timestamp getAdminCreateTime() {
        return adminCreateTime;
    }

    public void setAdminCreateTime(Timestamp adminCreateTime) {
        this.adminCreateTime = adminCreateTime;
    }

    @Basic
    @Column(name = "admin_tel")
    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministratorEntity that = (AdministratorEntity) o;
        return Objects.equals(adminId, that.adminId) && Objects.equals(adminName, that.adminName) && Objects.equals(adminPassword, that.adminPassword) && Objects.equals(adminAvatarLink, that.adminAvatarLink) && Objects.equals(adminCreateTime, that.adminCreateTime) && Objects.equals(adminTel, that.adminTel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminName, adminPassword, adminAvatarLink, adminCreateTime, adminTel);
    }
}
