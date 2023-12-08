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
    public ResponseEntity<?> savePersonInfo(@RequestBody JSONObject requestBody) {

        return ResponseEntity.ok(personService.save(requestBody));
    }

}
