package com.pms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String indexPage(){
        return "index";
    }

    @RequestMapping("/aa")
    public String aaPage(){
        return "index";
    }
}
