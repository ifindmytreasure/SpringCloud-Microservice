package com.colin.order.utils;

import java.util.Random;

/**
 * @author: BlueMelancholy
 * 2019/10/2 18:17
 * @desc:
 */
public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
