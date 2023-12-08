package org.airflow.database.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.airflow.database.util.JSONObjectConverter;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "dag_property", schema = "public")
public class DagProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dag_property_id")
    private Long dagPropertyId;

    @Column(name = "dag_id")
    private String dagId;

    @NonNull
    @Column(name = "dag_conf", columnDefinition = "json")
    @Convert(converter = JSONObjectConverter.class)
    @ColumnTransformer(write = "?::json")
    private Map<String, Object> dagRequestBody;

    @Column(name = "log_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime logTime;

    public DagProperty() {
    }

    public DagProperty(Long dagPropertyId, String dagId, @NonNull Map<String, Object> dagRequestBody, LocalDateTime logTime) {
        this.dagPropertyId = dagPropertyId;
        this.dagId = dagId;
        this.dagRequestBody = dagRequestBody;
        this.logTime = logTime;
    }

    public Long getDagPropertyId() {
        return dagPropertyId;
    }

    public void setDagPropertyId(Long dagPropertyId) {
        this.dagPropertyId = dagPropertyId;
    }

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    @NonNull
    public Map<String, Object> getDagRequestBody() {
        return dagRequestBody;
    }

    public void setDagRequestBody(@NonNull Map<String, Object> dagRequestBody) {
        this.dagRequestBody = dagRequestBody;
    }

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public void setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
    }
}
