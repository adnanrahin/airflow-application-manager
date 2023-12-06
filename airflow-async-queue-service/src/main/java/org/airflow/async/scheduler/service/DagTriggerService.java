package org.airflow.async.scheduler.service;

import org.springframework.http.ResponseEntity;

public interface DagTriggerService {

    ResponseEntity<Object> triggerDag(String dagId);

}
