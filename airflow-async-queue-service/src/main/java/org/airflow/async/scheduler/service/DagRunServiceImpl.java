package org.airflow.async.scheduler.service;

import org.airflow.async.scheduler.entities.DagRunEntity;
import org.airflow.async.scheduler.repositories.DagRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DagRunServiceImpl implements DagRunService {

    private final DagRunRepository dagRunRepository;

    @Autowired
    public DagRunServiceImpl(DagRunRepository dagRunRepository) {
        this.dagRunRepository = dagRunRepository;
    }

    @Override
    public List<DagRunEntity> findAll() {
        return dagRunRepository.findAll();
    }

    @Override
    public DagRunEntity findById(String dagId) {
        return dagRunRepository.findById(dagId).orElse(null);
    }

    @Override
    public DagRunEntity save(DagRunEntity dagRun) {
        return dagRunRepository.save(dagRun);
    }
}
