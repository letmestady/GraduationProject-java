package com.example.springboot2demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot2demo1.domain.CustomerLoginData;
import com.example.springboot2demo1.form.AddCustomerForm;
import com.example.springboot2demo1.form.CustomerRegisteredForm;
import com.example.springboot2demo1.form.UpdateCustomerForm;
import com.example.springboot2demo1.vo.QueryCustomerVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface CustomerLoginDataService extends IService<CustomerLoginData>{
    Boolean  createCustomer(@Param("form")AddCustomerForm form);

    Boolean deleteCustomerById(@Param("customerId") Integer id);

    Boolean updateCustomerByPhone(@Param("customerPhone") String customerPhone, @Param("form") UpdateCustomerForm form);

    QueryCustomerVo queryCustomerByPhone(@Param("customerPhone") String customerPhone);

    Boolean customerRegistered(@Param("form") CustomerRegisteredForm form);
}
