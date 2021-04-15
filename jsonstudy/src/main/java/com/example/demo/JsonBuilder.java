package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonBuilder {
    public static String json(Object o) throws JsonProcessingException {
        return (new ObjectMapper()).writeValueAsString(o);
    }

    public static String jsonTime(Object o) throws JsonProcessingException {
        return jsonTime(o, "yyyy-MM-dd HH:mm:ss");
    }

    public static String jsonTime(Object o, String format) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper.writeValueAsString(o);
    }
}
