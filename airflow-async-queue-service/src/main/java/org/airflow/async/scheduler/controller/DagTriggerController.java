package org.airflow.async.scheduler.controller;

import org.airflow.async.scheduler.service.DagRunService;
import org.airflow.async.scheduler.service.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@RestController
@RequestMapping("/airflow/client")
public class DagTriggerController {

    private String dagId;
    private final Queue<String> dagQueue = new ConcurrentLinkedQueue<>();
    private final DagTriggerService dagTriggerService;
    private final DagRunService dagRunService;

    @Autowired
    public DagTriggerController(DagTriggerService dagTriggerService, DagRunService dagRunService) {
        this.dagTriggerService = dagTriggerService;
        this.dagRunService = dagRunService;
    }

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    @RequestMapping(path = "/dagId/{dagId}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String triggerDag(@PathVariable String dagId) {
        setDagId(dagId);
        boolean isRunning = dagRunService.isDagRunning(dagId);
        if (isRunning) {
            dagQueue.add(dagId);
            return "Dag is RUNNING, it will be in queue";
        } else {
            dagTriggerService.triggerDag(dagId);
            return "DAG Triggered!";
        }
    }

    @Scheduled(fixedRate = 2000)
    public void triggerDagRun() {
        boolean isRunning = dagRunService.isDagRunning(this.dagId);
        if (isRunning) {
            dagQueue.add(this.dagId);
        } else {
            dagTriggerService.triggerDag(this.dagQueue.poll());
        }
    }
}
