package com.myatomikos.lsxatomikos;

import com.myatomikos.lsxatomikos.entity.User;
import com.myatomikos.lsxatomikos.user1.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyController {


    @Autowired
    private UserServices userService;
    @RequestMapping("test")
    @ResponseBody
    public String  insert (){
        Date date=new Date();
        String message = userService.insert(new User(11122,"zhangsan"+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds(), 15));

        return  message;
    }

    @RequestMapping("notran")
    public String insert1()
    {Date date=new Date();
        int num=Integer.parseInt(""+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds());
        String message = userService.insert1(new User(+num,"zhangsan"+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds(), 15));

        return  message;
    }

    @RequestMapping("sel")
    public int sel()
    {
        return userService.sel();
    }
    //使用mybatis访问数据库的方法
    @RequestMapping("ins")
    public String ins()
    {Date date=new Date();
        int num=Integer.parseInt(""+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds());
        System.out.println(num);
        String message = userService.ins(new User(+num,"zhangsan"+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds(), 15));
        return message;
    }
    @RequestMapping("ins1")
    public String ins1()
    {Date date=new Date();
        int num=Integer.parseInt(""+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds());
        System.out.println(num);
        String message = userService.ins1(new User(+num,"zhangsan"+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds(), 15));
        return message;
    }
    @RequestMapping("ins2")
    public String ins2()
    {Date date=new Date();
        int num=Integer.parseInt(""+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds());
        System.out.println(num);
        String message = userService.ins2(new User(+num,"zhangsan"+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds(), 15));
        return message;
    }
}
