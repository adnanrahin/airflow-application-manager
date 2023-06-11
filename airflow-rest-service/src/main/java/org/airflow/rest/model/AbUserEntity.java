package org.airflow.rest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ab_user", schema = "public", catalog = "postgres")
public class AbUserEntity {
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
    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 256)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 256)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "active", nullable = true)
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 256)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "last_login", nullable = true)
    private Timestamp lastLogin;

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "login_count", nullable = true)
    private Integer loginCount;

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Basic
    @Column(name = "fail_login_count", nullable = true)
    private Integer failLoginCount;

    public Integer getFailLoginCount() {
        return failLoginCount;
    }

    public void setFailLoginCount(Integer failLoginCount) {
        this.failLoginCount = failLoginCount;
    }

    @Basic
    @Column(name = "created_on", nullable = true)
    private Timestamp createdOn;

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "changed_on", nullable = true)
    private Timestamp changedOn;

    public Timestamp getChangedOn() {
        return changedOn;
    }

    public void setChangedOn(Timestamp changedOn) {
        this.changedOn = changedOn;
    }

    @Basic
    @Column(name = "created_by_fk", nullable = true)
    private Integer createdByFk;

    public Integer getCreatedByFk() {
        return createdByFk;
    }

    public void setCreatedByFk(Integer createdByFk) {
        this.createdByFk = createdByFk;
    }

    @Basic
    @Column(name = "changed_by_fk", nullable = true)
    private Integer changedByFk;

    public Integer getChangedByFk() {
        return changedByFk;
    }

    public void setChangedByFk(Integer changedByFk) {
        this.changedByFk = changedByFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbUserEntity that = (AbUserEntity) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(active, that.active) && Objects.equals(email, that.email) && Objects.equals(lastLogin, that.lastLogin) && Objects.equals(loginCount, that.loginCount) && Objects.equals(failLoginCount, that.failLoginCount) && Objects.equals(createdOn, that.createdOn) && Objects.equals(changedOn, that.changedOn) && Objects.equals(createdByFk, that.createdByFk) && Objects.equals(changedByFk, that.changedByFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, active, email, lastLogin, loginCount, failLoginCount, createdOn, changedOn, createdByFk, changedByFk);
    }
}
