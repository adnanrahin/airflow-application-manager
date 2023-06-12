package org.airflow.rest.services.implementations;

import org.airflow.rest.model.LogEntity;
import org.airflow.rest.repositories.LogRepository;
import org.airflow.rest.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<LogEntity> findAll() {
        return logRepository.findAll();
    }

    @Override
    public LogEntity findById(Long id) {
        return logRepository.findById(id).orElse(null);
    }

    @Override
    public LogEntity save(LogEntity log) {
        return logRepository.save(log);
    }

    @Override
    public void delete(LogEntity log) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
