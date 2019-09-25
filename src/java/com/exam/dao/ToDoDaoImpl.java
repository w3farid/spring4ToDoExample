/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.dao;

import com.exam.model.AuditLog;
import com.exam.model.MyTask;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Instructor
 */
@Repository("toDoDaoImpl")
public class ToDoDaoImpl implements ToDoDao<MyTask> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public MyTask add(MyTask entity) {

        try {
            Session s = sessionFactory.getCurrentSession();
            s.save(entity);            
            return entity;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<MyTask> getAll() {
        try {
            Session s = sessionFactory.getCurrentSession();
            Query query = s.createQuery("FROM MyTask where status='created'");
            List<MyTask> taskList = query.list();
            return taskList;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(int id) {

        try {
            Session s = sessionFactory.getCurrentSession();
            MyTask taskEntity = (MyTask) s.get(MyTask.class, id);
            taskEntity.setStatus("updated");
            taskEntity.setUpdatedDate(new Date());
            s.saveOrUpdate(taskEntity);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    @Override
    public List<MyTask> getAllDoneTask() {
        try {
            Session s = sessionFactory.getCurrentSession();
            Query query = s.createQuery("FROM MyTask where status='updated'");
            List<MyTask> taskList = query.list();
            return taskList;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
