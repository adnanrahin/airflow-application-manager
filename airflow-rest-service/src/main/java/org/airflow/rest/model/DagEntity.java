package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dag", schema = "public", catalog = "postgres")
public class DagEntity {
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
    @Column(name = "root_dag_id", nullable = true, length = 250)
    private String rootDagId;

    public String getRootDagId() {
        return rootDagId;
    }

    public void setRootDagId(String rootDagId) {
        this.rootDagId = rootDagId;
    }

    @Basic
    @Column(name = "is_paused", nullable = true)
    private Boolean isPaused;

    public Boolean getPaused() {
        return isPaused;
    }

    public void setPaused(Boolean paused) {
        isPaused = paused;
    }

    @Basic
    @Column(name = "is_subdag", nullable = true)
    private Boolean isSubdag;

    public Boolean getSubdag() {
        return isSubdag;
    }

    public void setSubdag(Boolean subdag) {
        isSubdag = subdag;
    }

    @Basic
    @Column(name = "is_active", nullable = true)
    private Boolean isActive;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Basic
    @Column(name = "last_parsed_time", nullable = true)
    private Object lastParsedTime;

    public Object getLastParsedTime() {
        return lastParsedTime;
    }

    public void setLastParsedTime(Object lastParsedTime) {
        this.lastParsedTime = lastParsedTime;
    }

    @Basic
    @Column(name = "last_pickled", nullable = true)
    private Object lastPickled;

    public Object getLastPickled() {
        return lastPickled;
    }

    public void setLastPickled(Object lastPickled) {
        this.lastPickled = lastPickled;
    }

    @Basic
    @Column(name = "last_expired", nullable = true)
    private Object lastExpired;

    public Object getLastExpired() {
        return lastExpired;
    }

    public void setLastExpired(Object lastExpired) {
        this.lastExpired = lastExpired;
    }

    @Basic
    @Column(name = "scheduler_lock", nullable = true)
    private Boolean schedulerLock;

    public Boolean getSchedulerLock() {
        return schedulerLock;
    }

    public void setSchedulerLock(Boolean schedulerLock) {
        this.schedulerLock = schedulerLock;
    }

    @Basic
    @Column(name = "pickle_id", nullable = true)
    private Integer pickleId;

    public Integer getPickleId() {
        return pickleId;
    }

    public void setPickleId(Integer pickleId) {
        this.pickleId = pickleId;
    }

    @Basic
    @Column(name = "fileloc", nullable = true, length = 2000)
    private String fileloc;

    public String getFileloc() {
        return fileloc;
    }

    public void setFileloc(String fileloc) {
        this.fileloc = fileloc;
    }

    @Basic
    @Column(name = "processor_subdir", nullable = true, length = 2000)
    private String processorSubdir;

    public String getProcessorSubdir() {
        return processorSubdir;
    }

    public void setProcessorSubdir(String processorSubdir) {
        this.processorSubdir = processorSubdir;
    }

    @Basic
    @Column(name = "owners", nullable = true, length = 2000)
    private String owners;

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
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
    @Column(name = "default_view", nullable = true, length = 25)
    private String defaultView;

    public String getDefaultView() {
        return defaultView;
    }

    public void setDefaultView(String defaultView) {
        this.defaultView = defaultView;
    }

    @Basic
    @Column(name = "schedule_interval", nullable = true, length = -1)
    private String scheduleInterval;

    public String getScheduleInterval() {
        return scheduleInterval;
    }

    public void setScheduleInterval(String scheduleInterval) {
        this.scheduleInterval = scheduleInterval;
    }

    @Basic
    @Column(name = "timetable_description", nullable = true, length = 1000)
    private String timetableDescription;

    public String getTimetableDescription() {
        return timetableDescription;
    }

    public void setTimetableDescription(String timetableDescription) {
        this.timetableDescription = timetableDescription;
    }

    @Basic
    @Column(name = "max_active_tasks", nullable = false)
    private int maxActiveTasks;

    public int getMaxActiveTasks() {
        return maxActiveTasks;
    }

    public void setMaxActiveTasks(int maxActiveTasks) {
        this.maxActiveTasks = maxActiveTasks;
    }

    @Basic
    @Column(name = "max_active_runs", nullable = true)
    private Integer maxActiveRuns;

    public Integer getMaxActiveRuns() {
        return maxActiveRuns;
    }

    public void setMaxActiveRuns(Integer maxActiveRuns) {
        this.maxActiveRuns = maxActiveRuns;
    }

    @Basic
    @Column(name = "has_task_concurrency_limits", nullable = false)
    private boolean hasTaskConcurrencyLimits;

    public boolean isHasTaskConcurrencyLimits() {
        return hasTaskConcurrencyLimits;
    }

    public void setHasTaskConcurrencyLimits(boolean hasTaskConcurrencyLimits) {
        this.hasTaskConcurrencyLimits = hasTaskConcurrencyLimits;
    }

    @Basic
    @Column(name = "has_import_errors", nullable = true)
    private Boolean hasImportErrors;

    public Boolean getHasImportErrors() {
        return hasImportErrors;
    }

    public void setHasImportErrors(Boolean hasImportErrors) {
        this.hasImportErrors = hasImportErrors;
    }

    @Basic
    @Column(name = "next_dagrun", nullable = true)
    private Object nextDagrun;

    public Object getNextDagrun() {
        return nextDagrun;
    }

    public void setNextDagrun(Object nextDagrun) {
        this.nextDagrun = nextDagrun;
    }

    @Basic
    @Column(name = "next_dagrun_data_interval_start", nullable = true)
    private Object nextDagrunDataIntervalStart;

    public Object getNextDagrunDataIntervalStart() {
        return nextDagrunDataIntervalStart;
    }

    public void setNextDagrunDataIntervalStart(Object nextDagrunDataIntervalStart) {
        this.nextDagrunDataIntervalStart = nextDagrunDataIntervalStart;
    }

    @Basic
    @Column(name = "next_dagrun_data_interval_end", nullable = true)
    private Object nextDagrunDataIntervalEnd;

    public Object getNextDagrunDataIntervalEnd() {
        return nextDagrunDataIntervalEnd;
    }

    public void setNextDagrunDataIntervalEnd(Object nextDagrunDataIntervalEnd) {
        this.nextDagrunDataIntervalEnd = nextDagrunDataIntervalEnd;
    }

    @Basic
    @Column(name = "next_dagrun_create_after", nullable = true)
    private Object nextDagrunCreateAfter;

    public Object getNextDagrunCreateAfter() {
        return nextDagrunCreateAfter;
    }

    public void setNextDagrunCreateAfter(Object nextDagrunCreateAfter) {
        this.nextDagrunCreateAfter = nextDagrunCreateAfter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DagEntity dagEntity = (DagEntity) o;
        return maxActiveTasks == dagEntity.maxActiveTasks && hasTaskConcurrencyLimits == dagEntity.hasTaskConcurrencyLimits && Objects.equals(dagId, dagEntity.dagId) && Objects.equals(rootDagId, dagEntity.rootDagId) && Objects.equals(isPaused, dagEntity.isPaused) && Objects.equals(isSubdag, dagEntity.isSubdag) && Objects.equals(isActive, dagEntity.isActive) && Objects.equals(lastParsedTime, dagEntity.lastParsedTime) && Objects.equals(lastPickled, dagEntity.lastPickled) && Objects.equals(lastExpired, dagEntity.lastExpired) && Objects.equals(schedulerLock, dagEntity.schedulerLock) && Objects.equals(pickleId, dagEntity.pickleId) && Objects.equals(fileloc, dagEntity.fileloc) && Objects.equals(processorSubdir, dagEntity.processorSubdir) && Objects.equals(owners, dagEntity.owners) && Objects.equals(description, dagEntity.description) && Objects.equals(defaultView, dagEntity.defaultView) && Objects.equals(scheduleInterval, dagEntity.scheduleInterval) && Objects.equals(timetableDescription, dagEntity.timetableDescription) && Objects.equals(maxActiveRuns, dagEntity.maxActiveRuns) && Objects.equals(hasImportErrors, dagEntity.hasImportErrors) && Objects.equals(nextDagrun, dagEntity.nextDagrun) && Objects.equals(nextDagrunDataIntervalStart, dagEntity.nextDagrunDataIntervalStart) && Objects.equals(nextDagrunDataIntervalEnd, dagEntity.nextDagrunDataIntervalEnd) && Objects.equals(nextDagrunCreateAfter, dagEntity.nextDagrunCreateAfter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dagId, rootDagId, isPaused, isSubdag, isActive, lastParsedTime, lastPickled, lastExpired, schedulerLock, pickleId, fileloc, processorSubdir, owners, description, defaultView, scheduleInterval, timetableDescription, maxActiveTasks, maxActiveRuns, hasTaskConcurrencyLimits, hasImportErrors, nextDagrun, nextDagrunDataIntervalStart, nextDagrunDataIntervalEnd, nextDagrunCreateAfter);
    }
}
