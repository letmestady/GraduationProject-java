package com.example.springboot2demo1.controller;

import com.example.springboot2demo1.form.AddCustomerForm;
import com.example.springboot2demo1.form.CustomerRegisteredForm;
import com.example.springboot2demo1.form.UpdateCustomerForm;
import com.example.springboot2demo1.service.CustomerLoginDataService;
import com.example.springboot2demo1.vo.QueryCustomerVo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customerLogin")
public class CustomerLoginDataController {

    @Resource
    private CustomerLoginDataService customerLoginDataService;

    @PostMapping
    public Boolean addCustomerLoginDate(@RequestBody AddCustomerForm form){
        customerLoginDataService.createCustomer(form);
        return true;
    }

    @DeleteMapping("{id}")
    public Boolean deleteCustomerById(@PathVariable Integer id){
        customerLoginDataService.deleteCustomerById(id);
        return true;
    }

    @GetMapping("{customerPhone}")
    public QueryCustomerVo getCustomerByPhone(@PathVariable String customerPhone){
        QueryCustomerVo queryCustomerVo= customerLoginDataService.queryCustomerByPhone(customerPhone);
        return  queryCustomerVo;
    }

    @PostMapping("{customerPhone}")
    public Boolean updateCustomerByPhone(@PathVariable String customerPhone,@RequestBody UpdateCustomerForm form ){
        customerLoginDataService.updateCustomerByPhone(customerPhone,form);
        return true;
    }


    @PostMapping("/customerRegistered")
    public Boolean customerRegistered(@RequestBody CustomerRegisteredForm form){
        customerLoginDataService.customerRegistered(form);
        return true;
    }



}
