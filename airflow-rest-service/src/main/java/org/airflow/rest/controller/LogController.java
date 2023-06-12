package org.airflow.rest.controller;


import org.airflow.rest.model.LogEntity;
import org.airflow.rest.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airflow/log/api/")
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllLog")
    public ResponseEntity<List<LogEntity>> getAllActor() {
        return ResponseEntity.ok(logService.findAll());
    }

}
