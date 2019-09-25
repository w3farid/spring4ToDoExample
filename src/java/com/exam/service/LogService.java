/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.service;

import com.exam.dao.LogDao;
import com.exam.model.AuditLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author farid
 */
@Service
public class LogService {
    @Autowired
    LogDao logDao;
    
    public AuditLog add(AuditLog logEntity){
        
        return logDao.add(logEntity);
    }
}
