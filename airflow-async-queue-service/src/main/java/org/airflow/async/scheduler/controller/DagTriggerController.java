package org.airflow.async.scheduler.controller;

import org.airflow.async.scheduler.service.DagRunService;
import org.airflow.async.scheduler.service.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/airflow/client")
public class DagTriggerController {

    private String dagId;
    private final Map<String, Queue<Map<String, Map<String, Object>>>> dagMap = new ConcurrentHashMap<>();
    private final DagTriggerService dagTriggerService;
    private final DagRunService dagRunService;

    @Autowired
    public DagTriggerController(DagTriggerService dagTriggerService,
                                DagRunService dagRunService) {
        this.dagTriggerService = dagTriggerService;
        this.dagRunService = dagRunService;
    }

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    public Map<String, Queue<Map<String, Map<String, Object>>>> getDagMap() {
        return dagMap;
    }

    @RequestMapping(path = "/dagId/{dagId}", method = RequestMethod.POST)
    public ResponseEntity<Object> triggerDag(@PathVariable String dagId,
                                             @RequestBody Map<String, Map<String, Object>> requestBody) {
        setDagId(dagId);
        boolean isRunning = dagRunService.isDagRunning(dagId);
        if (isRunning) {
            if (!dagMap.containsKey(dagId)) {
                dagMap.put(dagId, new ConcurrentLinkedQueue<>());
            }
            dagMap.get(dagId).add(requestBody);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Dag is added to the QUEUE: " + dagMap.get(dagId).size());
        } else {

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(() -> {
                ResponseEntity<Object> responseEntity = dagTriggerService.triggerDag(dagId, Optional.of(requestBody));
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            executorService.shutdown();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Request Submitted For the Dag");
        }
    }
}
