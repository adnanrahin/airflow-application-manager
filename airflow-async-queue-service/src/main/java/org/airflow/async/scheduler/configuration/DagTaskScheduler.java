package org.airflow.async.scheduler.configuration;

import org.airflow.async.scheduler.controller.DagTriggerController;
import org.airflow.async.scheduler.service.DagRunService;
import org.airflow.async.scheduler.service.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

@Component("dagTaskScheduler")
public class DagTaskScheduler {

    public DagRunService dagRunService;
    public DagTriggerService dagTriggerService;
    public DagTriggerController dagTriggerController;

    @Autowired
    public DagTaskScheduler(DagRunService dagRunService,
                            DagTriggerService dagTriggerService,
                            DagTriggerController dagTriggerController) {
        this.dagRunService = dagRunService;
        this.dagTriggerService = dagTriggerService;
        this.dagTriggerController = dagTriggerController;
    }

    @Scheduled(fixedRate = 2000)
    public void triggerDagRun() {

        dagTriggerController.getDagMap()
                .keySet()
                .stream().parallel()
                .forEach(key -> {
                    boolean isRunning = dagRunService.isDagRunning(key);
                    Queue<Map<String, Map<String, Object>>> queue = dagTriggerController.getDagMap().get(key);
                    if (!isRunning && queue.size() > 0) {
                        Map<String, Map<String, Object>> requestBody = queue.poll();
                        dagTriggerService.triggerDag(key, Optional.of(requestBody));
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }
}
