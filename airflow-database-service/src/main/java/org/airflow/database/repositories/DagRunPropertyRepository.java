package org.airflow.database.repositories;


import org.airflow.database.entities.DagProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DagRunPropertyRepository extends JpaRepository<DagProperty, Long> {

    

}
