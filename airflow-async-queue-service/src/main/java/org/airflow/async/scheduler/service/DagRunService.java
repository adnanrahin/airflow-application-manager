package org.airflow.async.scheduler.service;

import org.airflow.async.scheduler.entities.DagRunEntity;

import java.util.List;

public interface DagRunService {

    List<DagRunEntity> findAll();

    DagRunEntity findById(String dagId);

    DagRunEntity save(DagRunEntity dagRun);

}
