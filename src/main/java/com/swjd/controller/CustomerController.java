package com.swjd.controller;

import com.swjd.bean.Customer;
import com.swjd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/customerController")
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //要能够跳转到主页面
    @RequestMapping("/toMain")
    public String toMain(Model model,Customer customer){
        List<Customer> list=new ArrayList<>();
        list=customerService.getList();
        model.addAttribute("customer",customer);
        model.addAttribute("list",list);
        return "zhuYe";
    }

}
