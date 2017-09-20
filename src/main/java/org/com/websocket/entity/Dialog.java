package org.com.websocket.entity;

import javax.websocket.Session;
import java.util.List;

/**
 * Created by dkw on 2017/9/18.
 */
public class Dialog {
    private List<User> sessionlist;
    private Long id;

    public List<User> getSessionlist() {
        return this.sessionlist;
    }

    public void setSessionlist(List<User> sessionlist) {
        this.sessionlist = sessionlist;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
