package org.airflow.rest.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DagOwnerAttributesEntityPK implements Serializable {
    @Column(name = "dag_id", nullable = false, length = 250)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dagId;
    @Column(name = "owner", nullable = false, length = 500)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String owner;

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DagOwnerAttributesEntityPK that = (DagOwnerAttributesEntityPK) o;
        return Objects.equals(dagId, that.dagId) && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dagId, owner);
    }
}
