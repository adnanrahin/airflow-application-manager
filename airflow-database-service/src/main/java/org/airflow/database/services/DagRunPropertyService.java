package org.airflow.database.services;

import net.minidev.json.JSONObject;
import org.airflow.database.entities.DagProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface DagRunPropertyService {

    DagProperty save(JSONObject requestBody);

}
