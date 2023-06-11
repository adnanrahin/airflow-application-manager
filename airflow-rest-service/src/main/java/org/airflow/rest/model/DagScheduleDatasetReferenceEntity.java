package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dag_schedule_dataset_reference", schema = "public", catalog = "postgres")
@IdClass(DagScheduleDatasetReferenceEntityPK.class)
public class DagScheduleDatasetReferenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dataset_id", nullable = false)
    private int datasetId;

    public int getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(int datasetId) {
        this.datasetId = datasetId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dag_id", nullable = false, length = 250)
    private String dagId;

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    private Object createdAt;

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = false)
    private Object updatedAt;

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DagScheduleDatasetReferenceEntity that = (DagScheduleDatasetReferenceEntity) o;
        return datasetId == that.datasetId && Objects.equals(dagId, that.dagId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasetId, dagId, createdAt, updatedAt);
    }
}
