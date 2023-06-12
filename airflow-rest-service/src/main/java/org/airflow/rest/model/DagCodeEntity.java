package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dag_code", schema = "public", catalog = "postgres")
public class DagCodeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fileloc_hash", nullable = false)
    private long filelocHash;

    @Basic
    @Column(name = "fileloc", nullable = false, length = 2000)
    private String fileloc;

    @Basic
    @Column(name = "last_updated", nullable = false)
    private String lastUpdated;

    @Basic
    @Column(name = "source_code", nullable = false, length = -1)
    private String sourceCode;

    public long getFilelocHash() {
        return filelocHash;
    }

    public void setFilelocHash(long filelocHash) {
        this.filelocHash = filelocHash;
    }

    public String getFileloc() {
        return fileloc;
    }

    public void setFileloc(String fileloc) {
        this.fileloc = fileloc;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DagCodeEntity that = (DagCodeEntity) o;
        return filelocHash == that.filelocHash && Objects.equals(fileloc, that.fileloc) && Objects.equals(lastUpdated, that.lastUpdated) && Objects.equals(sourceCode, that.sourceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filelocHash, fileloc, lastUpdated, sourceCode);
    }
}
