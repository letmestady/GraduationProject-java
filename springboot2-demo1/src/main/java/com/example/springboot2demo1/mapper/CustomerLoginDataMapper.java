package com.example.springboot2demo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot2demo1.domain.CustomerLoginData;
import com.example.springboot2demo1.form.AddCustomerForm;
import com.example.springboot2demo1.form.CustomerRegisteredForm;
import com.example.springboot2demo1.form.UpdateCustomerForm;
import com.example.springboot2demo1.vo.QueryCustomerVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

@Mapper
public interface CustomerLoginDataMapper extends BaseMapper<CustomerLoginData> {



    //增
    Boolean addCustomer(@Param("form") AddCustomerForm form );

    //删
    Boolean deleteCustomerById(@Param("customerId") Integer id);

    //改
    Boolean updateCustomerByPhone(@Param("form")UpdateCustomerForm form);

    //查
    QueryCustomerVo selectCustomerByPhone(@Param("customerPhone") String customerPhone);


    //注册
    Boolean customerRegistered(@Param("form")CustomerRegisteredForm form);
}
