package org.com.websocket.socketService;

import org.apache.log4j.Logger;
import org.com.websocket.entity.Message;
import org.com.websocket.entity.User;
import org.com.websocket.proxy.LogAsect;
import org.smart4j.annotation.Aspect;
import org.smart4j.annotation.Service;
import org.smart4j.util.JsonUtil;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkw on 2017/9/18.
 */

@Service
@ServerEndpoint("/socket/{id}/{name}")
public class TestSocketService {
    private static final Logger log = Logger.getLogger(TestSocketService.class);
    private static final List<User> connections = new ArrayList<>();

    public static List<User> getConnections() {
        return connections;
    }

    private Session session;

    @OnOpen
    public void start(Session session, @PathParam("id") String id, @PathParam("name") String name) {
        this.session = session;
        User u = new User(id, name, session, "");
        connections.add(u);
        String message = String.format("* %s", name, "has joined.");
        sendToAll(name + "加入了当前聊天群");
        log.info(name+"加入聊天群，当前人数"+connections.size());
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        Message m = JsonUtil.fromJson(message, Message.class);
        log.info(m.getName()+":"+m.getMessage());
        if (m.getToId().equals("")) {
            for (User u : connections) {
                sendJsonMessage(u.getSession(), m.getName() + ":" + m.getMessage());
            }
        } else {
            for (User u : connections) {
                if (m.getToId().equals(u.getId()) || m.getId().equals(u.getId())) {
                    sendJsonMessage(u.getSession(), m.getName() + ":" + m.getMessage());

                }
            }
        }
    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        String name="";
        for (User u : connections) {
            if (session.equals(u.getSession())) {
                name=u.getName();
                connections.remove(u);
                log.info(name+"离开了该聊天群，当前人数"+connections.size());
                break;
            }
        }
        sendToAll(name+"离开了该聊天群");

    }

    private void sendToAll(String message) {
        for (User u : connections) {
            sendJsonMessage(u.getSession(), "全体:" + message);
        }
    }


    /**
     * 消息发送方法
     */
    private void sendJsonMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            this.handleException(e);
        }
    }

    private void handleException(Throwable t) {
        t.printStackTrace();
        String message = t.toString();
        try {
            for (User u : connections) {
                u.getSession().close(new CloseReason(
                        CloseReason.CloseCodes.UNEXPECTED_CONDITION, message
                ));
            }
        } catch (IOException ignore) {
            log.error("close socket failure", ignore);
        }
    }
}
