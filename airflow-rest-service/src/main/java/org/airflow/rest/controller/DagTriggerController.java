package org.airflow.rest.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.airflow.rest.services.DagTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trigger/dag")
public class DagTriggerController {

    private final DagTriggerService dagTriggerService;

    @Autowired
    public DagTriggerController(DagTriggerService dagTriggerService) {
        this.dagTriggerService = dagTriggerService;
    }

    @GetMapping(path = "/dagId/{uri}")
    public String triggerDag(@PathVariable String uri) throws JsonProcessingException, InterruptedException {
        dagTriggerService.addToTheQueue(uri);
        return "TRIGRED";
    }

}