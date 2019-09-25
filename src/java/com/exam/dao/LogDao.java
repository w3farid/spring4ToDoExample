/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.dao;

import com.exam.model.AuditLog;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author farid
 */
@Repository
public class LogDao {

    @Autowired
    SessionFactory sessionFactory;

    public AuditLog add(AuditLog logEntity) {
        try {
            Session s = sessionFactory.getCurrentSession();
            s.save(logEntity);
            return logEntity;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return logEntity;
    }

}
