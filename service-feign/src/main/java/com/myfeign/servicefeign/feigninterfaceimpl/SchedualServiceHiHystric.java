package com.myfeign.servicefeign.feigninterfaceimpl;

import com.myfeign.servicefeign.feigninterface.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "srory "+name;
    }
}
