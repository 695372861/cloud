package com.myatomikos.lsxatomikos.user1.service;

import com.myatomikos.lsxatomikos.entity.User;
import com.myatomikos.lsxatomikos.user1.dao.MybatisDao;
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

    @Autowired
    com.myatomikos.lsxatomikos.user1.dao.MybatisDao mybatisDao;

    @Autowired
    com.myatomikos.lsxatomikos.user2.dao.MybatisDao2 mybatisDao2;

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
        userDaoTest2.save(user);
        long count=userDaoTest1.count();
        long count1=userDaoTest2.count();
        System.out.println("count:"+count);
        System.out.println("count1:"+count1);
//        int i=1/0;
//        userDaoTest2.save(user);
        return "ss";
    }

    //mybatis的使用
    public int sel()
    {
        System.out.println(mybatisDao2.getcount());
        return mybatisDao.getcount();
    }

    public String ins(User user)
    {
        mybatisDao.insert(user);
        int i=1/0;
        mybatisDao2.insert(user);
        return "session";
    }
    public String ins1(User user)
    {
        mybatisDao.insert(user);
        mybatisDao2.insert(user);
        return "session";
    }
    @Transactional
    public String ins2(User user)
    {
        mybatisDao.insert(user);
        mybatisDao2.insert(user);
        int i=1/0;
        return "session";
    }
}
