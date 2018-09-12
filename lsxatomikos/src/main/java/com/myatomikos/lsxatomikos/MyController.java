package com.myatomikos.lsxatomikos;

import com.myatomikos.lsxatomikos.entity.User;
import com.myatomikos.lsxatomikos.user1.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private UserServices userService;
    @RequestMapping("test")
    @ResponseBody
    public String  insert (){
        String message = userService.insert(new User(111,"zhangsan", 15));

        return  message;
    }

    @RequestMapping("notran")
    public String insert1()
    {
        String message = userService.insert1(new User(111,"zhangsan", 15));

        return  message;
    }

}
