package com.lsx.myoauth2.dao;

import com.lsx.myoauth2.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountRepository {
    public Account findByName(String name)
    {
        Account account=new Account("user1","123456","2");
        return account;
    }
}
