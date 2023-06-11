package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dag_run_note", schema = "public", catalog = "postgres")
public class DagRunNoteEntity {
    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dag_run_id", nullable = false)
    private int dagRunId;

    public int getDagRunId() {
        return dagRunId;
    }

    public void setDagRunId(int dagRunId) {
        this.dagRunId = dagRunId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 1000)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        DagRunNoteEntity that = (DagRunNoteEntity) o;
        return dagRunId == that.dagRunId && Objects.equals(userId, that.userId) && Objects.equals(content, that.content) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, dagRunId, content, createdAt, updatedAt);
    }
}
