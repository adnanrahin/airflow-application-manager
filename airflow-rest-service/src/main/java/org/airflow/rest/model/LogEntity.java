package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "log", schema = "public", catalog = "postgres")
public class LogEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "dttm", nullable = true)
    private Object dttm;
    @Basic
    @Column(name = "dag_id", nullable = true, length = 250)
    private String dagId;
    @Basic
    @Column(name = "task_id", nullable = true, length = 250)
    private String taskId;
    @Basic
    @Column(name = "map_index", nullable = true)
    private Integer mapIndex;
    @Basic
    @Column(name = "event", nullable = true, length = 30)
    private String event;
    @Basic
    @Column(name = "execution_date", nullable = true)
    private Object executionDate;
    @Basic
    @Column(name = "owner", nullable = true, length = 500)
    private String owner;
    @Basic
    @Column(name = "extra", nullable = true, length = -1)
    private String extra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getDttm() {
        return dttm;
    }

    public void setDttm(Object dttm) {
        this.dttm = dttm;
    }

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getMapIndex() {
        return mapIndex;
    }

    public void setMapIndex(Integer mapIndex) {
        this.mapIndex = mapIndex;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Object getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Object executionDate) {
        this.executionDate = executionDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

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
        LogEntity logEntity = (LogEntity) o;
        return id == logEntity.id && Objects.equals(dttm, logEntity.dttm) && Objects.equals(dagId, logEntity.dagId) && Objects.equals(taskId, logEntity.taskId) && Objects.equals(mapIndex, logEntity.mapIndex) && Objects.equals(event, logEntity.event) && Objects.equals(executionDate, logEntity.executionDate) && Objects.equals(owner, logEntity.owner) && Objects.equals(extra, logEntity.extra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dttm, dagId, taskId, mapIndex, event, executionDate, owner, extra);
    }
}
