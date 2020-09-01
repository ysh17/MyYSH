package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author :YSH
 * @date :2020/8/30 20:31
 */


public class test {

    @Test
    public void test(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-service.xml");

        AccountService accountService = applicationContext.getBean(AccountService.class);

        accountService.findAll();

    }

    @Test
    public void test01() throws IOException {

        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(is);

        SqlSession sqlSession = factory.openSession();

        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.finAll();

        for (Account account : accounts) {
            System.out.println(account);
        }

        sqlSession.close();
        is.close();

    }





    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");

        AccountDao accountDao = applicationContext.getBean(AccountDao.class);

        List<Account> accounts = accountDao.finAll();
        for (Account account : accounts) {

            System.out.println(account);
        }
    }
}


