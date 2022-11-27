package com.example.springboot2demo1.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerRegisteredForm {
    //顾客账号
    private String customerAccount;

    //顾客密码
    private String customerPassword;

    //顾客电话号码
    private  String customerPhone;

}
