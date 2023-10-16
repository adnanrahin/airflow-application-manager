package org.airflow.rest.services.implementations;

import org.airflow.rest.services.DagTriggerService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class DagTriggerServiceImpl implements DagTriggerService {

    @Override
    public void triggerDag() {

        final String airflowApiUrl = "http://localhost:18080/api/v1/dags/file_count_dag/dagRuns";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String authHeader = "Basic " + Base64.getEncoder().encodeToString("admin:admin".getBytes());
        headers.set("Authorization", authHeader);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>("{}", headers);

        restTemplate.postForEntity(airflowApiUrl, request, String.class);
    }
}
