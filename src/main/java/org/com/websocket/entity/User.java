package org.com.websocket.entity;


import javax.websocket.Session;
import java.util.*;

/**
 * Created by dkw on 2017/9/18.
 */
public class User {
    private String id;
    private String name;
    private String remark;
    private Session session;
    public User(String id, String name,Session session, String remark) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.session = session;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
