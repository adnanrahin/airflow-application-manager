package org.airflow.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AirflowDatabaseRestApi {

    public static void main(String[] args) {
        SpringApplication.run(AirflowDatabaseRestApi.class, args);
    }

}
