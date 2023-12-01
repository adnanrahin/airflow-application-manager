package org.airflow.async.scheduler.controller;

import org.airflow.async.scheduler.entities.DagRunEntity;
import org.airflow.async.scheduler.service.DagRunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airflow/client/dagrun")
public class DagRunController {

    private final DagRunService dagRunService;

    public DagRunController(DagRunService dagRunService) {
        this.dagRunService = dagRunService;
    }

    @RequestMapping("/getAllRun")
    public ResponseEntity<List<DagRunEntity>> getAllDagRun() {
        return ResponseEntity.ok(dagRunService.findAll());
    }

}
