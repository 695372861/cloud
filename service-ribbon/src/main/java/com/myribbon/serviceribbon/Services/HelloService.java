package com.myribbon.serviceribbon.Services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    //使用如下的注解为方法创建一个熔断器断路器
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name)
    {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
    //fallbakMethod的熔断方法
    public String hiError(String name)
    {
        return "hi "+name+",sorry,sorry";
    }
}
