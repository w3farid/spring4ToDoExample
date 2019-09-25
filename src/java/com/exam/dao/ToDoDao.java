/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.dao;

import java.util.List;

/**
 *
 * @author Instructor
 */
public interface ToDoDao<T>{
    T add(T entity);
    List<T> getAll();
    List<T> getAllDoneTask();
    boolean update(int id);
}
