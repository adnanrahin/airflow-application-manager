package org.airflow.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AirflowRestApp {

    public static void main(String[] args) {
        SpringApplication.run(AirflowRestApp.class, args);
    }

}