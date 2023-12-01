package org.airflow.async.scheduler.repositories;

import org.airflow.async.scheduler.entities.DagRunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DagRunRepository extends JpaRepository<DagRunEntity, String> {
}
