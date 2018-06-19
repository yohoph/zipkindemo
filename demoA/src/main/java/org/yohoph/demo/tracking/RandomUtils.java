package org.yohoph.demo.tracking;

import java.util.Random;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/6/13 15:36
 * @Description 随机获取
 */
public class RandomUtils {

    private static Random random = new Random();

    public static long random(){
        return random.nextLong();
    }

}
