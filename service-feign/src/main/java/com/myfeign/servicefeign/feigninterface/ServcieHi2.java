package com.myfeign.servicefeign.feigninterface;

import com.myfeign.servicefeign.feigninterfaceimpl.ServiceHi2Impl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-hi2",fallback = ServiceHi2Impl.class)
public interface ServcieHi2 {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi2FromClient(String name);
}
