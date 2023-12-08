package org.airflow.database.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.airflow.database.entities.Person;
import org.airflow.database.services.PersonService;
import org.airflow.database.util.JSONObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/person/map")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/personinfo")
    public ResponseEntity<Object> savePersonInfo(@RequestBody JSONObject requestBody) throws ParseException, JsonProcessingException {

        String firstName = requestBody.getAsString("first_name");
        String lastName = requestBody.getAsString("last_name");

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        Object confObject = requestBody.get("conf");

        if (confObject instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> confMap = (Map<String, Object>) confObject;
            person.setPersonInfo(confMap);
        } else {
            throw new RuntimeException("Object Type Mismatch");
        }

        personService.save(person);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("DATA PRINTED");
    }

}
