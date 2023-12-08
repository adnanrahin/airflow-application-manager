package org.airflow.database.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Converter(autoApply = true)
public class JSONObjectConverter implements AttributeConverter<Map<String, Object>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override


    public String convertToDatabaseColumn(Map<String, Object> attributeValue) {
        try {
            return objectMapper.writeValueAsString(attributeValue);
        } catch (JsonProcessingException ex) {
            // handle exception
            return null;
        }
    }

    @Override


    public Map<String, Object> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException ex) {
            // handle exception
            return null;
        }
    }
}

