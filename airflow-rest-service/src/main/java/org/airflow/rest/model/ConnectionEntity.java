package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "connection", schema = "public", catalog = "postgres")
public class ConnectionEntity {
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
    @Column(name = "conn_id", nullable = false, length = 250)
    private String connId;

    public String getConnId() {
        return connId;
    }

    public void setConnId(String connId) {
        this.connId = connId;
    }

    @Basic
    @Column(name = "conn_type", nullable = false, length = 500)
    private String connType;

    public String getConnType() {
        return connType;
    }

    public void setConnType(String connType) {
        this.connType = connType;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "host", nullable = true, length = 500)
    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Basic
    @Column(name = "schema", nullable = true, length = 500)
    private String schema;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 500)
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 5000)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "port", nullable = true)
    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Basic
    @Column(name = "is_encrypted", nullable = true)
    private Boolean isEncrypted;

    public Boolean getEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        isEncrypted = encrypted;
    }

    @Basic
    @Column(name = "is_extra_encrypted", nullable = true)
    private Boolean isExtraEncrypted;

    public Boolean getExtraEncrypted() {
        return isExtraEncrypted;
    }

    public void setExtraEncrypted(Boolean extraEncrypted) {
        isExtraEncrypted = extraEncrypted;
    }

    @Basic
    @Column(name = "extra", nullable = true, length = -1)
    private String extra;

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionEntity that = (ConnectionEntity) o;
        return id == that.id && Objects.equals(connId, that.connId) && Objects.equals(connType, that.connType) && Objects.equals(description, that.description) && Objects.equals(host, that.host) && Objects.equals(schema, that.schema) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(port, that.port) && Objects.equals(isEncrypted, that.isEncrypted) && Objects.equals(isExtraEncrypted, that.isExtraEncrypted) && Objects.equals(extra, that.extra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, connId, connType, description, host, schema, login, password, port, isEncrypted, isExtraEncrypted, extra);
    }
}
