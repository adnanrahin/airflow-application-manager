package org.airflow.rest.services;

import org.airflow.rest.model.LogEntity;

import java.util.List;

public interface LogService {

    List<LogEntity> findAll();

    LogEntity findById(Long id);

    LogEntity save(LogEntity log);

    void delete(LogEntity log);

    void deleteById(Long id);

}
