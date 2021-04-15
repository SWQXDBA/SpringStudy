package com.example.demo.Controllers;

import com.example.demo.Repositorys.JpaRepository;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class MainController {
    @Autowired
    private JpaRepository jpaRepository;

    @RequestMapping(path = "/add") // Map ONLY POST Requests
    @ResponseBody
    public String addNewUser(@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        jpaRepository.save(n);
        return "Saved";
    }

    @ResponseBody
    @RequestMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return jpaRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(path = "/alldesc")
    public List<User> getAllUsersList() {
        // This returns a JSON or XML with the users

        return jpaRepository.findAlldesc();
    }

    @ResponseBody
    @RequestMapping(path = "/count")
    public Long getCount() {
        // This returns a JSON or XML with the users
        return jpaRepository.findAllCount();
    }


}