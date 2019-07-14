package com.yogie.common;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @program: aimoll
 * @Date: 2019/7/11 11:26
 * @Author: Chenyogie
 * @Description: 基于md5算法加密工具
 */
public class Md5Util {

    /**
     * 加密使用的盐值
     */
    private static final String SALT = "chenyogie";

    /**
     * 加密需要迭代的次数
     */
    private static final int HASHITERATIONS = 10;

    /**
     * 将明文的密码进行md5加密
     * @param password
     * @return
     */
    public static String getMd5Result(String password){
        //使用shiro的散列算法进行加密
        SimpleHash hash = new SimpleHash("MD5",password,SALT,HASHITERATIONS);
        //返回加密后的字符串
        return hash.toHex();
    }
}
