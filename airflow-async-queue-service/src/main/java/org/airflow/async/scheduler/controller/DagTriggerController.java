package org.airflow.async.scheduler.controller;

import org.airflow.async.scheduler.service.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airflow/client")
public class DagTriggerController {

    private final DagTriggerService dagTriggerService;

    @Autowired
    public DagTriggerController(DagTriggerService dagTriggerService) {
        this.dagTriggerService = dagTriggerService;
    }

    @RequestMapping(path = "/dagId/{uri}", method = RequestMethod.GET)
    public String triggerDag(@PathVariable String uri) {
        dagTriggerService.triggerDag(uri);
        return "DAG Triggered!";
    }

}
