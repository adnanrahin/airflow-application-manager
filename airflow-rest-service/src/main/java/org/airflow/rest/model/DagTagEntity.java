package org.airflow.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "dag_tag", schema = "public", catalog = "postgres")
@javax.persistence.IdClass(org.airflow.rest.model.DagTagEntityPK.class)
public class DagTagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "name", nullable = false, length = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "dag_id", nullable = false, length = 250)
    private String dagId;

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DagTagEntity that = (DagTagEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(dagId, that.dagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dagId);
    }
}
