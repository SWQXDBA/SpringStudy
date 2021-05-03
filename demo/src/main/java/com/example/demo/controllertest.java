package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controllertest {
    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "ok";
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public String testGet() {
        return "get";
    }


    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public String testPOST() {
        return "POST";
    }
}
