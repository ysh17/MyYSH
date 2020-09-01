package com.itheima.web;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

/**
 * @author :YSH
 * @date :2020/8/30 22:15
 * 整合SSM三大框架  整合Spring和SpringMVC
 */
@Controller("AccountController")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(Model model){

        /*List<Account> all = accountService.findAll();
        model.addAttribute("all", all);
        return "list";
        */



        ModelAndView modelAndView = new ModelAndView();

        //调用Service查询所有账户
        List<Account> all = accountService.findAll();

        modelAndView.setViewName("list");
        modelAndView.addObject("all",all);

        System.out.println(modelAndView);


        for (Account account : all) {
            System.out.println(account);
        }

        return modelAndView;
    }
}
