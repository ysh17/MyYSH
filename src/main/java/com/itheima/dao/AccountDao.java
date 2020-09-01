package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author :YSH
 * @date :2020/8/30 20:36
 */

/**
 * 有一个映射器就要有一个映射文件 映射器和映射文件的名字要一样
 */
public interface AccountDao {

    List<Account> finAll();
}
