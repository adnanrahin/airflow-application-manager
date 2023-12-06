package org.airflow.async.scheduler.controller;

import org.airflow.async.scheduler.service.DagRunService;
import org.airflow.async.scheduler.service.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
@RequestMapping("/airflow/client")
public class DagTriggerController {

    private String dagId;
    private final Map<String, Queue<String>> dagMap = new ConcurrentHashMap<>();
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

    public Map<String, Queue<String>> getDagMap() {
        return dagMap;
    }

    @RequestMapping(path = "/dagId/{dagId}", method = {RequestMethod.GET, RequestMethod.PUT})
    public ResponseEntity<Object> triggerDag(@PathVariable String dagId) {
        setDagId(dagId);
        boolean isRunning = dagRunService.isDagRunning(dagId);
        if (isRunning) {
            if (!dagMap.containsKey(dagId)) {
                dagMap.put(dagId, new ConcurrentLinkedQueue<>());
            }
            int queuePollSize = dagMap.get(dagId).size();
            dagMap.get(dagId).add(dagId);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Dag is added to the QUEUE: " + dagMap.get(dagId).size());
        } else {
            return ResponseEntity.ok(dagTriggerService.triggerDag(dagId));
        }
    }

}
