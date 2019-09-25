/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.controller;

import com.exam.dao.ToDoDaoImpl;
import com.exam.model.MyTask;
import com.exam.service.ToDoServiceImpl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Instructor
 */
@RestController
@RequestMapping(value = "task")
public class ToDoController {

    @Autowired
    ToDoServiceImpl toDoServiceImpl;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(HttpServletRequest request) {

        String taskName = request.getParameter("task_name");
        MyTask myTask = new MyTask();
        myTask.setTaskName(taskName);
        myTask.setCreatedDate(new Date());
        myTask.setStatus("created");
        MyTask entity = toDoServiceImpl.add(myTask);
        Map<String, Object> map = new HashMap<>();
        List<MyTask> data = toDoServiceImpl.getAll();
        map.put("taskList", data);
        map.put("pageTitle", "Add task");
        map.put("formTitle", "Create Task");
        
        if(entity != null){
            map.put("addStatus", "success");
        }else{
           map.put("addStatus", "error"); 
        }
        
        return new ModelAndView("index", "data", map);
    }

    @RequestMapping(value = "/done/{id}")
    public ModelAndView taskDone(@PathVariable int id) {
        boolean result = toDoServiceImpl.update(id);
        Map<String, Object> map = new HashMap<>();
        map.put("pageTitle", "Add task");
        map.put("formTitle", "Create Task");
        if (result) {
            List<MyTask> data = toDoServiceImpl.getAll();
            map.put("taskList", data);
            map.put("status", "success");
            return new ModelAndView("index", "data", map);
        } else {
            map.put("status", "error");
            return new ModelAndView("index", "data", map);
        }

    }
    @RequestMapping(value = "/donetask", method = RequestMethod.GET)
    public List<MyTask> completedTask(){        
        return toDoServiceImpl.getAllDoneTask();
    }

}
