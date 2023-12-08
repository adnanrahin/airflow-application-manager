package org.airflow.database.services.implementations;


import net.minidev.json.JSONObject;
import org.airflow.database.entities.DagProperty;
import org.airflow.database.repositories.DagRunPropertyRepository;
import org.airflow.database.services.DagRunPropertyService;
import org.airflow.database.util.JSONObjectConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DagRunPropertyServiceImpl implements DagRunPropertyService {

    @Autowired
    private DagRunPropertyRepository dagRunPropertyRepository;

    @Override
    public DagProperty save(JSONObject requestBody) {

        String dagId = requestBody.getAsString("dag_id");
        String confObject = requestBody.getAsString("conf");

        DagProperty dagProperty = new DagProperty();
        dagProperty.setDagId(dagId);
        dagProperty.setLogTime(java.time.LocalDateTime.now());

        Map<String, Object> confMap = new JSONObjectConverter().convertToEntityAttribute(confObject);
        dagProperty.setDagRequestBody(confMap);

        return dagRunPropertyRepository.save(dagProperty);
    }
}
