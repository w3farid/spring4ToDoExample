/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.service;

import com.exam.dao.ToDoDaoImpl;
import com.exam.model.MyTask;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Instructor
 */
@Service
@Transactional
public class ToDoServiceImpl {
    @Autowired
    ToDoDaoImpl toDoDaoImpl;
    
    public MyTask add(MyTask entity) {
        return toDoDaoImpl.add(entity);
    }
    
    public List<MyTask> getAll() {
        return toDoDaoImpl.getAll();
    }
    
    public boolean update(int id) {
        return toDoDaoImpl.update(id);
    }
    
    public List<MyTask> getAllDoneTask() {
        return toDoDaoImpl.getAllDoneTask();
    }
}
