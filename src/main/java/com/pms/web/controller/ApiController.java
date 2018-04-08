package com.pms.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping(value = "/api/persons/sex")
    public String testApi(){
        return "[1,2,3]";
    }
}
