package org.airflow.async.scheduler.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class DagTriggerServiceImpl implements DagTriggerService {

    @Override
    public ResponseEntity<Object> triggerDag(String dagId) {

        Map<String, Object> dagConf = new HashMap<>();

        dagConf.put("file_name_1", "OptServiceExtractData.csv");

        if (dagId == null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("dagId is Null");
        }

        String airflowApiUrl = "http://192.168.1.235:18080/api/v1/dags/{dagId}/dagRuns";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String authHeader = "Basic " + Base64.getEncoder().encodeToString("api_user:api_user".getBytes());
        headers.set("Authorization", authHeader);

        try {
            // Convert the map to a JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String dagConfJson = objectMapper.writeValueAsString(dagConf);

            // Construct the request body with DAG configuration
            String requestBody = "{\"conf\": " + dagConfJson + "}";
            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Object> response = restTemplate.postForEntity(airflowApiUrl, request, Object.class, dagId);

            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            // Handle exception (e.g., JSON serialization error)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing DAG configuration");
        }
    }
}

