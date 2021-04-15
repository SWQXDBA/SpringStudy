package com.example.demo.controllors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("diaoyong", true);
        map.put("data", o);
        if (o instanceof String) {
            //如果控制器方法返回类型为字符串，响应的Content-Type为text/plain，手动设置为json，
            //并重写为序列化后的json字符串
            serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            try {

                return objectMapper.writeValueAsString(o);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("json序列化失败", e);
            }
        }
        return map;
    }
}
