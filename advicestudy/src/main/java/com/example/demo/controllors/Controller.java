package com.example.demo.controllors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/test")
    public Object ret(@RequestParam String name) {
        return name;
    }

    @GetMapping("/test2")
    public Object ret2(@RequestParam String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("NAME", name);
        return map;
    }
}
