package org.airflow.async.scheduler.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface DagTriggerService {

    void triggerDag(String dagId);

}
