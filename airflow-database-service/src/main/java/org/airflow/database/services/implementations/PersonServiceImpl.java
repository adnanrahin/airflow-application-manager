package org.airflow.database.services.implementations;

import org.airflow.database.entities.Person;
import org.airflow.database.repositories.PersonRepository;
import org.airflow.database.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllPerson() {
        return null;
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }
}
