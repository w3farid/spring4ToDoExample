/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Instructor
 */
@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "userAgent")
    private String userAgent;

    @Column(name = "remoteAddress")
    private String remoteAddress;

    @Column(name = "message")
    private String message;

    @Column(name = "obj_id", nullable = false)
    private int objId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }

    @Override
    public String toString() {
        return "AuditLog{" + "id=" + id + ", userAgent=" + userAgent + ", remoteAddress=" + remoteAddress + '}';
    }
}
