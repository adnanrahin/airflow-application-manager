package org.airflow.rest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "account_roles", schema = "public", catalog = "postgres")
@IdClass(AccountRolesEntityPK.class)
public class AccountRolesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "grant_date", nullable = true)
    private Timestamp grantDate;

    public Timestamp getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(Timestamp grantDate) {
        this.grantDate = grantDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRolesEntity that = (AccountRolesEntity) o;
        return userId == that.userId && roleId == that.roleId && Objects.equals(grantDate, that.grantDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId, grantDate);
    }
}
