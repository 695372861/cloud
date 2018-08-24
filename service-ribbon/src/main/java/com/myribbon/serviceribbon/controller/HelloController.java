package com.myribbon.serviceribbon.controller;

import com.myribbon.serviceribbon.Services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    //@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
    //@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
    @GetMapping("/hi")
    public String hi(@RequestParam String name)
    {
        return helloService.hiService(name);
    }
}
