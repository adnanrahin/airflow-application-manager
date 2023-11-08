package org.airflow.rest.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface DagTriggerService {

    void triggerDag(String dagId) throws JsonProcessingException;

}
