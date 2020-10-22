package com.snowman.sharding.demo.service;

import com.snowman.sharding.demo.entity.Book;

import java.util.List;

/**
 * @Description
 * @Author Snowman1024
 * @Date 2020/4/3 11:15
 * @Version 1.0
 **/
public interface BookService {
    public List<Book> getBookList();

    public boolean save(Book book);

}
