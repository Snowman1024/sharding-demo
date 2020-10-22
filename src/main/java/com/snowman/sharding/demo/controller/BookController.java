package com.snowman.sharding.demo.controller;

import com.alibaba.fastjson.JSON;
import com.snowman.sharding.demo.common.SeedUtil;
import com.snowman.sharding.demo.entity.Book;
import com.snowman.sharding.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Snowman1024
 * @Date 2020/4/3 11:14
 * @Version 1.0
 **/
@Slf4j
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 查询
     *
     * @return
     */
    @GetMapping("/book")
    public List<Book> getItems() {
        log.info("查询开始");
        List<Book> bookList = bookService.getBookList();
        log.info("查询结束，返回:{}", JSON.toJSONString(bookList));
        return bookList;
    }

    /**
     * 保存
     *
     * @return
     */
    @PostMapping("/book")
    public Boolean saveItem() throws Exception {
        log.info("保存开始");

        for (int i = 1; i <= 100; i++) {

            long id = SeedUtil.getId();

            Book book = new Book();
            book.setId(id);
            book.setName(String.valueOf(id));

            bookService.save(book);
        }
        log.info("保存结束");

        return true;
    }


    public static void main(String[] args) {
        long a = 158590558667400489L;

        long i = a % 3;

        long e = a % 2;

        System.out.println("库 db" + i + ",表 book_" + e);
    }
}
