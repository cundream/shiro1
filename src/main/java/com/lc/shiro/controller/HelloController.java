package com.lc.shiro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("hello");
        return "6666";
    }
}
