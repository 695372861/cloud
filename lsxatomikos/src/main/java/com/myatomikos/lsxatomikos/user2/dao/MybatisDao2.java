package com.myatomikos.lsxatomikos.user2.dao;

import com.myatomikos.lsxatomikos.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MybatisDao2 {
    public int getcount();
    public int insert(@Param("user") User user);
}
