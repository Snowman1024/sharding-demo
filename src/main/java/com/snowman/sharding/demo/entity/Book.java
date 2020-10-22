package com.snowman.sharding.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import groovy.transform.EqualsAndHashCode;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description
 * @Author Snowman1024
 * @Date 2020/4/3 11:05
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("book")
public class Book extends Model<Book> {

    private long id;
    private String name;
    private int count;
}
