package com.example.springboot2demo1.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_customer_login_data")
public class CustomerLoginData {
    //value用于指定数据库表的主键customer_id和customerId的驼峰对应，
    // IdType.AUTO为id自增
    @TableId(value = "customer_id",type = IdType.AUTO)
    private Long customerId;

    //顾客账号
    private String customerAccount;

    //顾客密码
    private String customerPassword;

    //顾客电话号码
    private  String customerPhone;

    //规范时间格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    //添加数据时自动添加当前时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
