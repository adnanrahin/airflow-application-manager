package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ab_permission_view_role", schema = "public", catalog = "postgres")
public class AbPermissionViewRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "permission_view_id", nullable = true)
    private Integer permissionViewId;

    public Integer getPermissionViewId() {
        return permissionViewId;
    }

    public void setPermissionViewId(Integer permissionViewId) {
        this.permissionViewId = permissionViewId;
    }

    @Basic
    @Column(name = "role_id", nullable = true)
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbPermissionViewRoleEntity that = (AbPermissionViewRoleEntity) o;
        return id == that.id && Objects.equals(permissionViewId, that.permissionViewId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, permissionViewId, roleId);
    }
}
