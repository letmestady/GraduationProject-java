package com.example.springboot2demo1.utils;

public abstract class RegexPatterns {
    //电话号码正则表达
    public static final String PHONE_REGEX = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|8[0-9]|9[0-9])\\d{8}$";

    //密码正则
    //大写小写数字特殊字符
    public static final String PASSWORD_REGEX = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";
}
