package org.airflow.rest.controller;


import org.airflow.rest.services.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trigger/dag")
public class DagTriggerController {

    private final DagTriggerService dagTriggerService;

    @Autowired
    public DagTriggerController(DagTriggerService dagTriggerService) {
        this.dagTriggerService = dagTriggerService;
    }

    @GetMapping("/trigger-dag")
    public String triggerDag() {
        dagTriggerService.triggerDag();
        return "DAG Triggered!";
    }
}