package com.MyCompany.ProperyManagement.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloWorld {
    // Restful API is used for just mapping the url to a Java Function
    // Url to acces this Java Function : "http://localhost:8080/api/v1/hello"
    @GetMapping("msg")
    public String SayMyMsg(@RequestParam("First Name") String first, @RequestParam("Last Name") String last)
    {
        return first + last;
    }
}
