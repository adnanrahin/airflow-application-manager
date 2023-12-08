package org.airflow.database.entities;

import org.airflow.database.util.JSONObjectConverter;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "person", schema = "public")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dag_property_id")
    private Long dagPropertyId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "person_info", columnDefinition = "json")
    @Convert(converter= JSONObjectConverter.class)
    @ColumnTransformer(write = "?::json")
    private Map<String, Object> personInfo;


    public Person() {

    }

    public Person(String firstName, String lastName, Map<String, Object> personInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personInfo = personInfo;
    }

    public Long getDagPropertyId() {
        return dagPropertyId;
    }

    public void setDagPropertyId(Long dagPropertyId) {
        this.dagPropertyId = dagPropertyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Object> getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(Map<String, Object> personInfo) {
        this.personInfo = personInfo;
    }
}
