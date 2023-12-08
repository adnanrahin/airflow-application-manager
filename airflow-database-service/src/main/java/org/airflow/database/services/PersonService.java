package org.airflow.database.services;

import net.minidev.json.JSONObject;
import org.airflow.database.entities.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAllPerson();

    Person save(JSONObject requestBody);

}
