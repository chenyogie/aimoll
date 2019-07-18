package com.yogie.common;

import java.util.UUID;

/**
 * @program: aimoll
 * @Date: 2019/7/17 17:27
 * @Author: Chenyogie
 * @Description: 使用uuid类生成一些数据的类
 */
public class UUIDUtil {

    /**
     * 根据uuid生成一个16进制的唯一字符串作为上传文件的名称
     * @return
     */
    public static String getFileNameByUUID(){
        String uuid = UUID.randomUUID().toString();
        return Integer.toHexString(uuid.hashCode());
    }

}
