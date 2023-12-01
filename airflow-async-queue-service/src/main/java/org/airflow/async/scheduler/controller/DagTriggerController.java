package org.airflow.async.scheduler.controller;

import org.airflow.async.scheduler.service.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airflow/client/")
public class DagTriggerController {

    private final DagTriggerService dagTriggerService;

    @Autowired
    public DagTriggerController(DagTriggerService dagTriggerService) {
        this.dagTriggerService = dagTriggerService;
    }

    @GetMapping(path = "dagId/{uri}")
    public String triggerDag(@PathVariable String uri) {
        dagTriggerService.triggerDag(uri);
        return "DAG Triggered!";
    }

}
