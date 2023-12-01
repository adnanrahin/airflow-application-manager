package org.airflow.async.scheduler.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Table(name = "dag_run")
public class DagRunEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dag_id", nullable = false, length = 250)
    private String dagId;

    @Column(name = "state", nullable = false)
    private String state;

    public DagRunEntity() {

    }

    public DagRunEntity(String dagId, String state) {
        this.dagId = dagId;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DagRunEntity)) return false;
        DagRunEntity that = (DagRunEntity) o;
        return Objects.equals(dagId, that.dagId) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dagId, state);
    }

    @Override
    public String toString() {
        return "DagRunEntity{" +
                "dagId='" + dagId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
