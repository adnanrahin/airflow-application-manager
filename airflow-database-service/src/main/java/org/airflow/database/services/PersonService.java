package org.airflow.database.services;

import org.airflow.database.entities.Person;

import java.util.List;

public interface PersonService {

    public List<Person> findAllPerson();

    public void save(Person person);

}
