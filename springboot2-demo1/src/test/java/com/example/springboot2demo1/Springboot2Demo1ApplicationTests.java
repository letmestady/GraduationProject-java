package com.example.springboot2demo1;

import com.example.springboot2demo1.form.AddCustomerForm;
import com.example.springboot2demo1.mapper.CustomerLoginDataMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Springboot2Demo1ApplicationTests {
   @Resource
   private CustomerLoginDataMapper customerLoginDataMapper;
   @Resource
   private AddCustomerForm form;
    @Test
    void contextLoads() {
        customerLoginDataMapper.selectList(null);
    }
    @Test
    void testAdd(){
        customerLoginDataMapper.selectCustomerByPhone("18249916480");
    }

}
