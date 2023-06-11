package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "alembic_version", schema = "public", catalog = "postgres")
public class AlembicVersionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "version_num", nullable = false, length = 32)
    private String versionNum;

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlembicVersionEntity that = (AlembicVersionEntity) o;
        return Objects.equals(versionNum, that.versionNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(versionNum);
    }
}
