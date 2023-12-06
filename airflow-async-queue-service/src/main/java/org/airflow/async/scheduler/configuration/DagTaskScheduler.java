package org.airflow.async.scheduler.configuration;

import org.airflow.async.scheduler.controller.DagTriggerController;
import org.airflow.async.scheduler.service.DagRunService;
import org.airflow.async.scheduler.service.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
        for (String key : dagTriggerController.getDagMap().keySet()) {
            boolean isRunning = dagRunService.isDagRunning(key);
            if (!isRunning) {
                String triggerId = dagTriggerController.getDagMap().get(key).poll();
                System.out.println("Triggering DAG: " + triggerId);
                dagTriggerService.triggerDag(triggerId);
            }
        }
    }
}
