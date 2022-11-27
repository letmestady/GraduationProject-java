package com.example.springboot2demo1.utils;

import cn.hutool.core.util.StrUtil;

public class RegexMatch {
    //不合格返回true

    public static boolean isPhoneInvalid(String phone){return mismatch(phone,RegexPatterns.PHONE_REGEX); }

    public static boolean isPasswordInvalid( String password){return mismatch(password,RegexPatterns.PASSWORD_REGEX);}
    //检验是否符合正则格式
    private static boolean mismatch(String str, String regex){
        if (StrUtil.isBlank(str)) {
            return true;
        }
        return !str.matches(regex);
    }
}