/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/**
 *
 * @author Instructor
 */
@Configuration
@EnableTransactionManagement
public class AppConfig{

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean lsf = new LocalSessionFactoryBean();

        lsf.setDataSource(dataSource());
        lsf.setPackagesToScan("com.exam.model");
        Properties p = new Properties();
        p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        p.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        lsf.setHibernateProperties(p);
        return lsf;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/todo");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager tmr = new HibernateTransactionManager();
        tmr.setSessionFactory(sessionFactory().getObject());
        return tmr;
    }

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        return bean;
    }
    
}
