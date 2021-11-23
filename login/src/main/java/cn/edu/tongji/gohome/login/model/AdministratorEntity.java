package cn.edu.tongji.gohome.login.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * AdministratorEntity
 *
 * @author 卓正一
 * @since 2021/11/22 9:35 PM
 */
@Entity
@Table(name = "administrator", schema = "GoHome", catalog = "")
public class AdministratorEntity {
    private int adminId;
    private String adminName;
    private String adminPassword;
    private String adminAvatarLink;
    private Timestamp adminCreateTime;
    private String adminTel;

    @Id
    @Column(name = "admin_id")
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
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
        return adminId == that.adminId && Objects.equals(adminName, that.adminName) && Objects.equals(adminPassword, that.adminPassword) && Objects.equals(adminAvatarLink, that.adminAvatarLink) && Objects.equals(adminCreateTime, that.adminCreateTime) && Objects.equals(adminTel, that.adminTel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminName, adminPassword, adminAvatarLink, adminCreateTime, adminTel);
    }
}
