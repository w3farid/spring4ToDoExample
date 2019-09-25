/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.controller;

import com.exam.dao.ToDoDaoImpl;
import com.exam.model.AuditLog;
import com.exam.model.MyTask;
import com.exam.service.ToDoServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Instructor
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    SessionFactory sessionFactory;
    
    @Autowired
    ToDoServiceImpl toDoServiceImpl;
    
    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        String conxtPath = request.getContextPath();
        String userAgent = request.getHeader("User-Agent");
        String host = request.getHeader("Host");
        String rmoteAddress = request.getRemoteAddr();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/exam/controller/beans.xml");
        AuditLog al =(AuditLog) ctx.getBean("auditLog");
        al.setUserAgent(userAgent);
        al.setRemoteAddress(rmoteAddress);
        Session s = sessionFactory.openSession();
        s.save(al);
        Map<String, Object> map = new HashMap<>();
        List<MyTask> data = toDoServiceImpl.getAll();
        map.put("taskList", data);
        map.put("pageTitle", "Add task");
        map.put("formTitle", "Create Task");
        return new ModelAndView("index", "data", map);
    }
    

}
