package com.snowman.sharding.demo.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snowman.sharding.demo.entity.Book;
import com.snowman.sharding.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author Snowman1024
 * @Date 2020/4/3 11:16
 * @Version 1.0
 **/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


    @Override
    public List<Book> getBookList() {
        return baseMapper.selectList(Wrappers.<Book>lambdaQuery());
    }

    /**
     * 保存
     *
     * @param book
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Book book) {
        return super.save(book);
    }
}
