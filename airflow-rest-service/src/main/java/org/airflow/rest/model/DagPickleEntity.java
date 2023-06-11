package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "dag_pickle", schema = "public", catalog = "postgres")
public class DagPickleEntity {
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
    @Column(name = "pickle", nullable = true)
    private byte[] pickle;

    public byte[] getPickle() {
        return pickle;
    }

    public void setPickle(byte[] pickle) {
        this.pickle = pickle;
    }

    @Basic
    @Column(name = "created_dttm", nullable = true)
    private Object createdDttm;

    public Object getCreatedDttm() {
        return createdDttm;
    }

    public void setCreatedDttm(Object createdDttm) {
        this.createdDttm = createdDttm;
    }

    @Basic
    @Column(name = "pickle_hash", nullable = true)
    private Long pickleHash;

    public Long getPickleHash() {
        return pickleHash;
    }

    public void setPickleHash(Long pickleHash) {
        this.pickleHash = pickleHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DagPickleEntity that = (DagPickleEntity) o;
        return id == that.id && Arrays.equals(pickle, that.pickle) && Objects.equals(createdDttm, that.createdDttm) && Objects.equals(pickleHash, that.pickleHash);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, createdDttm, pickleHash);
        result = 31 * result + Arrays.hashCode(pickle);
        return result;
    }
}
