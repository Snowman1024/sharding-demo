package com.snowman.sharding.demo.common;

import java.util.Date;
import java.util.Random;

/**
 * @Description 生成不重复的数作为数据库表主键（18位）
 * 可通过snowflake-demo工程的替换，snowflake算法生成ID
 *
 * @Author Snowman1024
 * @Date 2020/4/3 14:13
 * @Version 1.0
 **/
public class SeedUtil {

    private static Long randomNumber;

    private static Long curIndex = Long.valueOf(0L);

    public SeedUtil() {
    }

    public synchronized static Long getId() throws Exception {
        Long index = null;
        // 从0到999 curIndex*100 curIndex 100-99900
        index = (curIndex = curIndex.longValue() + 1L).longValue() % 1000L;
        if (curIndex.longValue() >= 1000L) {
            curIndex = 0L;
        }
        // 随机数 1-100
        randomNumber = Long.valueOf(new Random().nextInt(100));

        return (new Date()).getTime() * 100000L + index.longValue() * 100L
                + randomNumber.longValue();
    }


}
