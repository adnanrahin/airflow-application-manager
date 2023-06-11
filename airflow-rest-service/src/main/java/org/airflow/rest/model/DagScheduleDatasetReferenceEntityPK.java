package org.airflow.rest.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DagScheduleDatasetReferenceEntityPK implements Serializable {
    @Column(name = "dataset_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int datasetId;
    @Column(name = "dag_id", nullable = false, length = 250)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dagId;

    public int getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(int datasetId) {
        this.datasetId = datasetId;
    }

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
        DagScheduleDatasetReferenceEntityPK that = (DagScheduleDatasetReferenceEntityPK) o;
        return datasetId == that.datasetId && Objects.equals(dagId, that.dagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasetId, dagId);
    }
}
