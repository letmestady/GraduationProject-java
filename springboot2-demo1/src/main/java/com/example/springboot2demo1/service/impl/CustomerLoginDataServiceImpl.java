package com.example.springboot2demo1.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot2demo1.domain.CustomerLoginData;
import com.example.springboot2demo1.form.AddCustomerForm;
import com.example.springboot2demo1.form.CustomerRegisteredForm;
import com.example.springboot2demo1.form.UpdateCustomerForm;
import com.example.springboot2demo1.mapper.CustomerLoginDataMapper;
import com.example.springboot2demo1.service.CustomerLoginDataService;
import com.example.springboot2demo1.utils.RegexMatch;
import com.example.springboot2demo1.vo.QueryCustomerVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerLoginDataServiceImpl extends ServiceImpl<CustomerLoginDataMapper,CustomerLoginData> implements CustomerLoginDataService {

    @Resource
    private CustomerLoginDataMapper customerLoginDataMapper;

    @Resource
    private CustomerLoginDataService customerLoginDataService;

    @Override
    public Boolean createCustomer(AddCustomerForm form) {

//        customerLoginDataMapper.addCustomer(form);
        CustomerLoginData addForm = new CustomerLoginData();
        addForm.setCustomerPhone(form.getCustomerPhone());
        addForm.setCustomerAccount(form.getCustomerAccount());
        addForm.setCustomerPassword(form.getCustomerPassword());

        baseMapper.insert(addForm);
        List<CustomerLoginData> list = new ArrayList<>();
        customerLoginDataService.saveBatch(list);
        return true;
    }

    @Override
    public Boolean deleteCustomerById(Integer id) {
        customerLoginDataMapper.deleteCustomerById(id);
        return null;
    }

    @Override
    public Boolean updateCustomerByPhone(String customerPhone,UpdateCustomerForm form) {
//        //?????????????????????
//       QueryCustomerVo queryCustomerVo= queryCustomerByPhone(customerPhone);
//        if(Objects.isNull(queryCustomerVo)){
//            throw new RuntimeException("?????????????????????");
//        }
//        QueryWrapper<CustomerLoginData> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("customer_phone",customerPhone);
//        CustomerLoginData customerLoginData = new CustomerLoginData();
//        customerLoginData.setCustomerAccount(form.getCustomerAccount());
//        customerLoginData.setCustomerPassword(form.getCustomerPassword());
//        baseMapper.update(customerLoginData,queryWrapper);
       // ?????????????????????????????????
//       return updateById()
//         boolean
//        return this.updateById(queryCustomerVo,customerPhone);
        return true;
    }



    @Override
    public QueryCustomerVo queryCustomerByPhone(String customerPhone) {

        return customerLoginDataMapper.selectCustomerByPhone(customerPhone);





    }

    @Override
    public Boolean customerRegistered(CustomerRegisteredForm form) {

        //???????????????????????????????????????????????????
        //??????????????????????????????
        if(StrUtil.isBlank(form.getCustomerPhone())){
            throw new RuntimeException("????????????????????????????????????????????????");
        }
        if(RegexMatch.isPhoneInvalid(form.getCustomerPhone())){
            throw new RuntimeException("???????????????????????????");
        }
        //???????????????
        LambdaQueryWrapper<CustomerLoginData> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(CustomerLoginData::getCustomerPhone,form.getCustomerPhone());
        CustomerLoginData customerLoginDataOne = baseMapper.selectOne(queryWrapper);
        //????????????????????????
        if(!Objects.isNull(customerLoginDataOne)){
            throw new RuntimeException("?????????????????????????????????????????????");
        }

        //??????????????????????????????
        CustomerLoginData customerLoginData = new CustomerLoginData();
        customerLoginData.setCustomerPhone(form.getCustomerPhone());
        if(StrUtil.isBlank(form.getCustomerAccount())){
            throw new RuntimeException("??????????????????");
        }

        customerLoginData.setCustomerAccount(form.getCustomerAccount());

        if(StrUtil.isBlank(form.getCustomerPassword())){
            throw new RuntimeException("???????????????");
        }
//        if(form.getCustomerPassword().length()<8 || form.getCustomerPassword().length()>16){
//            throw new RuntimeException("??????????????????8???16????????????");
//        }
        //????????????
//        String phone = form.getCustomerPhone();
        if(RegexMatch.isPasswordInvalid(form.getCustomerPassword())){
            throw new RuntimeException("???????????????????????????????????????????????????????????????");
        }
        customerLoginData.setCustomerPassword(form.getCustomerPassword());

        baseMapper.insert(customerLoginData);

        return true;
    }
}
