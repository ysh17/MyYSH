package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :YSH
 * @date :2020/8/30 20:16
 */

/**
 * 将这个类注册成为一个bean对象 存储到spring容器中
 */
@Service("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("AccountServiceImpl.findAll");

        List<Account> accounts = accountDao.finAll();

        return accounts;
    }
}
