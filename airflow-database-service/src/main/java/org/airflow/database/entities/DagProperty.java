package org.airflow.database.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dag_property")
public class DagProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dag_property_id")
    private Long dagPropertyId;

    @Column(name = "dag_id")
    private String dagId;

    //@Type(type = "jsonb")
    @Column(name = "system_info", columnDefinition = "jsonb")
    private String systemInfo;

    @Column(name = "system_log_time")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date systemLogTime;

    public DagProperty() {
    }

    public DagProperty(String dagId, String systemInfo, Date systemLogTime) {
        this.dagId = dagId;
        this.systemInfo = systemInfo;
        this.systemLogTime = systemLogTime;
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

    public String getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(String systemInfo) {
        this.systemInfo = systemInfo;
    }

    public Date getSystemLogTime() {
        return systemLogTime;
    }

    public void setSystemLogTime(Date systemLogTime) {
        this.systemLogTime = systemLogTime;
    }
}
