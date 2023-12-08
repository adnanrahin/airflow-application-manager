package org.airflow.database.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.PersistenceException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class JSONObjectConverter implements AttributeConverter<Map<String, Object>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public String convertToDatabaseColumn(Map<String, Object> data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            throw new PersistenceException("Unable to convert value", ex);
        }
    }

    public Map<String, Object> convertToEntityAttribute(String jsonString) {

        String result = jsonString.replaceAll("[{}]", "");
        Map<String, String> resultMap = new HashMap<>();
        String[] keyValuePairs = result.split(",");

        for (String pair : keyValuePairs) {
            String[] parts = pair.trim().split("=");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                resultMap.put(key, value);
            }
        }
        try {
            String fix = objectMapper.writeValueAsString(resultMap);
            TypeReference<HashMap<String, Object>> typeRef =
                    new TypeReference<HashMap<String, Object>>() {
                    };
            return objectMapper.readValue( fix, typeRef);
        } catch (IOException ex) {
            throw new RuntimeException("Error converting JSON string to Map", ex);
        }
    }

}

