package org.airflow.rest.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

public interface DagTriggerService {

    void addToTheQueue(String dagId) throws JsonProcessingException, InterruptedException;

}
