package org.airflow.rest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dag_owner_attributes", schema = "public", catalog = "postgres")
@IdClass(DagOwnerAttributesEntityPK.class)
public class DagOwnerAttributesEntity {
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "owner", nullable = false, length = 500)
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "link", nullable = false, length = 500)
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DagOwnerAttributesEntity that = (DagOwnerAttributesEntity) o;
        return Objects.equals(dagId, that.dagId) && Objects.equals(owner, that.owner) && Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dagId, owner, link);
    }
}
