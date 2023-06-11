package org.airflow.rest.model;

import javax.persistence.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Entity
@Table(name = "callback_request", schema = "public", catalog = "postgres")
public class CallbackRequestEntity {
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
    @Column(name = "created_at", nullable = false)
    private Object createdAt;

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "priority_weight", nullable = false)
    private int priorityWeight;

    public int getPriorityWeight() {
        return priorityWeight;
    }

    public void setPriorityWeight(int priorityWeight) {
        this.priorityWeight = priorityWeight;
    }

    @Basic
    @Column(name = "callback_data", nullable = false)
    private Object callbackData;

    public Object getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(Object callbackData) {
        this.callbackData = callbackData;
    }

    @Basic
    @Column(name = "callback_type", nullable = false, length = 20)
    private String callbackType;

    public String getCallbackType() {
        return callbackType;
    }

    public void setCallbackType(String callbackType) {
        this.callbackType = callbackType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallbackRequestEntity that = (CallbackRequestEntity) o;
        return id == that.id && priorityWeight == that.priorityWeight && Objects.equals(createdAt, that.createdAt) && Objects.equals(callbackData, that.callbackData) && Objects.equals(callbackType, that.callbackType) && Objects.equals(processorSubdir, that.processorSubdir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, priorityWeight, callbackData, callbackType, processorSubdir);
    }
}
