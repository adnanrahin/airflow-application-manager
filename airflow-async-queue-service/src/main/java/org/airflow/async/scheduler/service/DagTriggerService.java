package org.airflow.async.scheduler.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

public interface DagTriggerService {

    ResponseEntity<Object> triggerDag(String dagId, Optional<Map<String, Map<String, Object>>> requestBody);

}
