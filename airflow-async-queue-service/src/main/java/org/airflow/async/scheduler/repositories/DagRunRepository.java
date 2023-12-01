package org.airflow.async.scheduler.repositories;

import org.airflow.async.scheduler.entities.DagRunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface DagRunRepository extends JpaRepository<DagRunEntity, String> {
    @Query(
            value = "SELECT state from dag_run where state='running' and dag_id=:dag_id"
            , nativeQuery = true
    )
    List<String> findRunningDag(@Param("dag_id") String dagId);
}
