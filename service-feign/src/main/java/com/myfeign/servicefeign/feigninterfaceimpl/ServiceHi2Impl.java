package com.myfeign.servicefeign.feigninterfaceimpl;

import com.myfeign.servicefeign.feigninterface.ServcieHi2;
import org.springframework.stereotype.Component;

@Component
public class ServiceHi2Impl implements ServcieHi2 {
    @Override
    public String sayHi2FromClient(String name) {
        return "不能访问";
    }
}
