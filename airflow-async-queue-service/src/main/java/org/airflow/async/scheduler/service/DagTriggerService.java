package org.airflow.async.scheduler.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface DagTriggerService {

    ResponseEntity<Object> triggerDag(String dagId);

}
