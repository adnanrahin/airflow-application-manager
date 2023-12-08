package org.airflow.database.controllers;

import net.minidev.json.JSONObject;
import org.airflow.database.services.DagRunPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airflow/client")
public class DagRunPropertyController {

    @Autowired
    private DagRunPropertyService dagRunPropertyService;

    @PostMapping("/dag_info")
    public ResponseEntity<?> savePersonInfo(@RequestBody JSONObject requestBody) {

        return ResponseEntity.ok(dagRunPropertyService.save(requestBody));
    }

}
