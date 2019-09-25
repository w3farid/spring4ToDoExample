/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.AuditLog;

import com.exam.model.AuditLog;
import com.exam.model.MyTask;
import com.exam.service.LogService;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditService {

    @Autowired
    HttpServletRequest request;
    
    @Autowired
    LogService logService;

    @Before("execution(* com.exam.service.ToDoServiceImpl.add(..)) && args(result)")
    public void logBefore(JoinPoint joinPoint, Object result) {
        MyTask task = (MyTask) result;
        String conxtPath = request.getContextPath();
        String userAgent = request.getHeader("User-Agent");
        String host = request.getHeader("Host");
        String rmoteAddress = request.getRemoteAddr();

        AuditLog auditLog = new AuditLog();
        auditLog.setRemoteAddress(rmoteAddress);
        auditLog.setUserAgent(userAgent);
        auditLog.setMessage("Add a new task");
        auditLog.setObjId(task.getId());
        logService.add(auditLog);
    }

    @AfterReturning(
            pointcut = "execution(* com.exam.service.ToDoServiceImpl.add(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("call after......");
    }
}
