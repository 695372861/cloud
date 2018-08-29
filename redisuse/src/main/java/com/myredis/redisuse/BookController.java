package com.myredis.redisuse;

import com.myredis.redisuse.support.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/idtobook")
    public Book queryBookCacheable(String id)
    {

        return bookService.queryBookCacheable(id,"book1"+id);
    }

    @RequestMapping("/all")
    public Map<String,Book> queryAllBook()
    {
        return bookService.queryAllBook();
    }
}
