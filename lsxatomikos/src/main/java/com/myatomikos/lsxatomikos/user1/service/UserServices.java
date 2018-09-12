package com.myatomikos.lsxatomikos.user1.service;

import com.myatomikos.lsxatomikos.entity.User;
import com.myatomikos.lsxatomikos.user1.dao.UserDaoTest1;
import com.myatomikos.lsxatomikos.user2.dao.UserDaoTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServices {
    @Autowired
    UserDaoTest1 userDaoTest1;
    @Autowired
    UserDaoTest2 userDaoTest2;

    @Transactional
    public String insert(User user)
    {
        userDaoTest1.save(user);
        userDaoTest2.save(user);
        int i=1/0;
        return "success";
    }
    public String insert1(User user)
    {
        userDaoTest1.save(user);
        int i=1/0;
        userDaoTest2.save(user);
        return "ss";
    }
}
