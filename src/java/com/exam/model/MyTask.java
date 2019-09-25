/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tasks")
public class MyTask {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id; 
    
    @Column (name = "task_name")
    private String taskName;
    
    @Column (name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    
    @Column (name = "updated_date")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
    
    @Column (name = "status")
    private String status;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuditLog> auditLost = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AuditLog> getAuditLost() {
        return auditLost;
    }

    public void setAuditLost(List<AuditLog> auditLost) {
        this.auditLost = auditLost;
    }

    @Override
    public String toString() {
        return "MyTask{" + "id=" + id + ", taskName=" + taskName + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", status=" + status + '}';
    }

   
    
    
}
