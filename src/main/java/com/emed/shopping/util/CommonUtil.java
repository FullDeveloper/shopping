package com.emed.shopping.util;

/**
 * @Author: 周润斌
 * @Date: create in 上午 17:38 2018/1/16 0016
 * @Description:
 */
public class CommonUtil {

    public static String nullToString(Object s) {
        return s == null ? "" : s.toString().trim();
    }

}
