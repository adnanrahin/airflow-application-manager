package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ab_permission_view", schema = "public", catalog = "postgres")
public class AbPermissionViewEntity {
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
    @Column(name = "permission_id", nullable = true)
    private Integer permissionId;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "view_menu_id", nullable = true)
    private Integer viewMenuId;

    public Integer getViewMenuId() {
        return viewMenuId;
    }

    public void setViewMenuId(Integer viewMenuId) {
        this.viewMenuId = viewMenuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbPermissionViewEntity that = (AbPermissionViewEntity) o;
        return id == that.id && Objects.equals(permissionId, that.permissionId) && Objects.equals(viewMenuId, that.viewMenuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, permissionId, viewMenuId);
    }
}
