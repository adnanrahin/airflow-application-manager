package org.airflow.rest.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.airflow.rest.services.DagTriggerService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

@Service
public class DagTriggerServiceImpl implements DagTriggerService {

    String airflowApiUrl = "http://192.168.1.235:18080/api/v1/dags/{dagId}/dagRuns";

    private final Queue<String> dagRunQueue = new ConcurrentLinkedQueue<>();
    private boolean isDagProcessing = false;

    @Override
    public void addToTheQueue(String dagId) throws JsonProcessingException, InterruptedException {
        dagRunQueue.add(dagId);
        queueProcess();
    }

    public void queueProcess() throws JsonProcessingException, InterruptedException {

        if (!isDagProcessing) {
            isDagProcessing = true;
            while (!dagRunQueue.isEmpty()) {
                String dagId = dagRunQueue.poll();
                if (!isDagRunning(dagId)) {
                    boolean success = triggerDag(dagId);
                    if (success) {
                        continue;
                    }
                }
                Thread.sleep(1000);
            }
            isDagProcessing = false;
        }
    }

    public boolean triggerDag(String dagId) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String authHeader = "Basic " + Base64.getEncoder().encodeToString("admin:admin".getBytes());
        headers.set("Authorization", authHeader);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>("{}", headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(airflowApiUrl, request, String.class, dagId);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        String state = root.get("state").textValue();
        String dagRunId = root.get("dag_run_id").textValue();

        // System.out.println(root);
        System.out.println(state);
        System.out.println("##########" + dagRunId);
        boolean isRunning = isDagRunning(dagId);
        System.out.println("Is Running: " + isRunning);

        return state.trim().equalsIgnoreCase("running") || state.trim().equalsIgnoreCase("queued");
    }

    boolean isDagRunning(String dagId) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String authHeader = "Basic " + Base64.getEncoder().encodeToString("admin:admin".getBytes());
        headers.set("Authorization", authHeader);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>("{}", headers);

        ResponseEntity<String> responseEntity = restTemplate
                .exchange(airflowApiUrl, HttpMethod.GET, request, String.class, Map.of("dagId", dagId));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseEntity.getBody());

        JsonNode dagRuns = root.path("dag_runs");

        for (JsonNode dagRun : dagRuns) {
            String state = dagRun.get("state").textValue();

            if (state.trim().equalsIgnoreCase("running")
                    || state.trim().equalsIgnoreCase("queued"))
                return true;
        }

        return false;
    }

}

