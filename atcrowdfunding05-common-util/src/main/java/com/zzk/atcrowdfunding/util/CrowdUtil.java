package com.zzk.atcrowdfunding.util;


import com.zzk.atcrowdfunding.constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CrowdUtil {

    // 2。执行md5加密
    public static String md5(String source){

        if(source == null || source.length() == 0){
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }


        try {
            String algorithm = "md5";
            // 获取messageDigest对象
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // 获取输入字符串的字节数组
            byte[] input = source.getBytes();

            // 执行加密
            byte[] output = messageDigest.digest(input);

            // 创建BigInteger对象
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, output);
            // 按照16进行将bigInteger的值转换为字符串
            int radix = 16;
            String encoded = bigInteger.toString(radix);
            return encoded;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    // 1。判断请求是否是ajax请求
    public static boolean judgeRequestType(HttpServletRequest request){

        String accept = request.getHeader("Accept");
        String requestHeader = request.getHeader("X-Requested-With");

        return (
                (accept != null && accept.contains("application/json")) ||
                        (requestHeader != null && requestHeader.equals("XMLHttpRequest"))
                );
    }
}
