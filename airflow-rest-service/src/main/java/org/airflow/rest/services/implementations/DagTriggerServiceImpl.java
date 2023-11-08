package org.airflow.rest.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.airflow.rest.services.DagTriggerService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class DagTriggerServiceImpl implements DagTriggerService {

    @Override
    public void triggerDag(String dagId) throws JsonProcessingException {

        String airflowApiUrl = "";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String authHeader = "Basic " + Base64.getEncoder().encodeToString("admin:admin".getBytes());
        headers.set("Authorization", authHeader);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>("{}", headers);

        System.out.println(request);

        restTemplate.postForEntity(airflowApiUrl, request, String.class, dagId);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(airflowApiUrl, request, String.class, dagId);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        String state = root.get("state").textValue();
        String dagRunId = root.get("dag_run_id").textValue();

        System.out.println(root);
        System.out.println(state);
        System.out.println(dagRunId);

        isDagRunning(dagId);

    }

    boolean isDagRunning(String dagId) throws JsonProcessingException {


        String airflowApiUrl = "";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String authHeader = "Basic " + Base64.getEncoder().encodeToString("admin:admin".getBytes());
        headers.set("Authorization", authHeader);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>("{}", headers);

        restTemplate.postForEntity(airflowApiUrl, request, String.class, dagId);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(airflowApiUrl, request, String.class, dagId);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseEntity.getBody());

        int failed = 0;
        int success = 0;
        int running = 0;
        int queued = 0;

        System.out.println(root.size());

        JsonNode dagRuns = root.path("dag_runs");

        for (JsonNode dagRun : dagRuns) {
            String state = dagRun.get("state").textValue();

            if (state.trim().equalsIgnoreCase("running"))
                return true;
        }

        return false;
    }

}