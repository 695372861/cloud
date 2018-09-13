package com.myatomikos.lsxatomikos.user2.dao;

import com.myatomikos.lsxatomikos.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDaoTest2 extends JpaRepository<User,Integer> {
}
