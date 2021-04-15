package com.example.demo;

import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/json")
public class json {
    @RequestMapping("/test")
    public String ret() {
        User user = new User();
        user.setAge(300);
        user.setName("AA");
        try {
            return JsonBuilder.json(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/test2")
    public String time() {
        Date date = new Date();
        //    date.setTime(System.currentTimeMillis());
        try {
            return JsonBuilder.jsonTime(date);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/test3")
    public String time2() {
        Date date = new Date();
        //    date.setTime(System.currentTimeMillis());
        try {
            return JsonBuilder.jsonTime(date, "yyyy-dd-MM HH:mm:ss");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}


