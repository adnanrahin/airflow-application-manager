package org.airflow.async.scheduler.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class DagTriggerServiceImpl implements DagTriggerService {

    @Override
    public void triggerDag(String dagId)  {

        String airflowApiUrl = "http://localhost:18080/api/v1/dags/{dagId}/dagRuns";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String authHeader = "Basic " + Base64.getEncoder().encodeToString("api_user:api_user".getBytes());
        headers.set("Authorization", authHeader);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>("{}", headers);

        restTemplate.postForEntity(airflowApiUrl, request, String.class);
    }
}
