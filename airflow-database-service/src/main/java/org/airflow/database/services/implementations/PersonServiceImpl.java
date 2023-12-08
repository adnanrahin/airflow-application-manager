package org.airflow.database.services.implementations;

import net.minidev.json.JSONObject;
import org.airflow.database.entities.Person;
import org.airflow.database.repositories.PersonRepository;
import org.airflow.database.services.PersonService;
import org.airflow.database.util.JSONObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllPerson() {
        return null;
    }

    @Override
    public Person save(JSONObject requestBody) {

        String firstName = requestBody.getAsString("first_name");
        String lastName = requestBody.getAsString("last_name");
        String confObject = requestBody.getAsString("conf");

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Map<String, Object> confMap = new JSONObjectConverter().convertToEntityAttribute(confObject);
        person.setPersonInfo(confMap);

        return personRepository.save(person);
    }
}
