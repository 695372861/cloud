package com.myfeign.servicefeign.controller;


import com.myfeign.servicefeign.feigninterface.SchedualServiceHi;
import com.myfeign.servicefeign.feigninterface.ServcieHi2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiController {
    @Autowired
    SchedualServiceHi schedualServiceHi;
    @Autowired
    ServcieHi2 servcieHi2;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name)
    {
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "hi2",method = RequestMethod.GET)
    public String sayhi2(String name){return servcieHi2.sayHi2FromClient(name);}
}
