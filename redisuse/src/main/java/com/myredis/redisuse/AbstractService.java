package com.myredis.redisuse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.myredis.redisuse.support.*;

public abstract class AbstractService {

    protected static Map<String, Book> repositoryBook = new HashMap<>();

    public AbstractService() {
        super();
    }

    //进行数据的初始化，在服务启动的时候执行
    @PostConstruct
    public void init() {
        // 1
        Book book1 = new Book("1", "name_1", 11, new Date());
        repositoryBook.put(book1.getId(), book1);
        // 2
        Book book2 = new Book("2", "name_2", 11, new Date());
        repositoryBook.put(book2.getId(), book2);
        // 3
        Book book3 = new Book("3", "name_3", 11, new Date());
        repositoryBook.put(book3.getId(), book3);
        // 4
        Book book4 = new Book("4", "name_4", 11, new Date());
        repositoryBook.put(book4.getId(), book4);
    }

}