package com.myatomikos.lsxatomikos.user1.dao;

import com.myatomikos.lsxatomikos.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MybatisDao {
    public int getcount();
    public int insert(@Param("user")User user);
}
