package org.airflow.rest.services;

public interface DagTriggerService {

    void triggerDag(String dagId);

}
