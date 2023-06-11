package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "dag_run", schema = "public", catalog = "postgres")
public class DagRunEntity {
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
    @Column(name = "dag_id", nullable = false, length = 250)
    private String dagId;

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    @Basic
    @Column(name = "queued_at", nullable = true)
    private Object queuedAt;

    public Object getQueuedAt() {
        return queuedAt;
    }

    public void setQueuedAt(Object queuedAt) {
        this.queuedAt = queuedAt;
    }

    @Basic
    @Column(name = "execution_date", nullable = false)
    private Object executionDate;

    public Object getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Object executionDate) {
        this.executionDate = executionDate;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    private Object startDate;

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    private Object endDate;

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 50)
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "run_id", nullable = false, length = 250)
    private String runId;

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    @Basic
    @Column(name = "creating_job_id", nullable = true)
    private Integer creatingJobId;

    public Integer getCreatingJobId() {
        return creatingJobId;
    }

    public void setCreatingJobId(Integer creatingJobId) {
        this.creatingJobId = creatingJobId;
    }

    @Basic
    @Column(name = "external_trigger", nullable = true)
    private Boolean externalTrigger;

    public Boolean getExternalTrigger() {
        return externalTrigger;
    }

    public void setExternalTrigger(Boolean externalTrigger) {
        this.externalTrigger = externalTrigger;
    }

    @Basic
    @Column(name = "run_type", nullable = false, length = 50)
    private String runType;

    public String getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = runType;
    }

    @Basic
    @Column(name = "conf", nullable = true)
    private byte[] conf;

    public byte[] getConf() {
        return conf;
    }

    public void setConf(byte[] conf) {
        this.conf = conf;
    }

    @Basic
    @Column(name = "data_interval_start", nullable = true)
    private Object dataIntervalStart;

    public Object getDataIntervalStart() {
        return dataIntervalStart;
    }

    public void setDataIntervalStart(Object dataIntervalStart) {
        this.dataIntervalStart = dataIntervalStart;
    }

    @Basic
    @Column(name = "data_interval_end", nullable = true)
    private Object dataIntervalEnd;

    public Object getDataIntervalEnd() {
        return dataIntervalEnd;
    }

    public void setDataIntervalEnd(Object dataIntervalEnd) {
        this.dataIntervalEnd = dataIntervalEnd;
    }

    @Basic
    @Column(name = "last_scheduling_decision", nullable = true)
    private Object lastSchedulingDecision;

    public Object getLastSchedulingDecision() {
        return lastSchedulingDecision;
    }

    public void setLastSchedulingDecision(Object lastSchedulingDecision) {
        this.lastSchedulingDecision = lastSchedulingDecision;
    }

    @Basic
    @Column(name = "dag_hash", nullable = true, length = 32)
    private String dagHash;

    public String getDagHash() {
        return dagHash;
    }

    public void setDagHash(String dagHash) {
        this.dagHash = dagHash;
    }

    @Basic
    @Column(name = "log_template_id", nullable = true)
    private Integer logTemplateId;

    public Integer getLogTemplateId() {
        return logTemplateId;
    }

    public void setLogTemplateId(Integer logTemplateId) {
        this.logTemplateId = logTemplateId;
    }

    @Basic
    @Column(name = "updated_at", nullable = true)
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
        DagRunEntity that = (DagRunEntity) o;
        return id == that.id && Objects.equals(dagId, that.dagId) && Objects.equals(queuedAt, that.queuedAt) && Objects.equals(executionDate, that.executionDate) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(state, that.state) && Objects.equals(runId, that.runId) && Objects.equals(creatingJobId, that.creatingJobId) && Objects.equals(externalTrigger, that.externalTrigger) && Objects.equals(runType, that.runType) && Arrays.equals(conf, that.conf) && Objects.equals(dataIntervalStart, that.dataIntervalStart) && Objects.equals(dataIntervalEnd, that.dataIntervalEnd) && Objects.equals(lastSchedulingDecision, that.lastSchedulingDecision) && Objects.equals(dagHash, that.dagHash) && Objects.equals(logTemplateId, that.logTemplateId) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, dagId, queuedAt, executionDate, startDate, endDate, state, runId, creatingJobId, externalTrigger, runType, dataIntervalStart, dataIntervalEnd, lastSchedulingDecision, dagHash, logTemplateId, updatedAt);
        result = 31 * result + Arrays.hashCode(conf);
        return result;
    }
}
