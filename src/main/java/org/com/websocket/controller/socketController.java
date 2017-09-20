package org.com.websocket.controller;

import org.com.websocket.entity.User;
import org.com.websocket.socketService.TestSocketService;
import org.smart4j.annotation.Action;
import org.smart4j.annotation.Controller;
import org.smart4j.annotation.Inject;
import org.smart4j.bean.Data;
import org.smart4j.bean.Param;
import org.smart4j.bean.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * websocket服务器
 * Created by dkw on 2017/9/15.
 */
@Controller
public class socketController {
    @Inject
    private TestSocketService testSocketService;
    @Action("post:/index")
    public View index(Param param){
        String id=param.getString("id");
        String name=param.getString("name");
        String toId=param.getString("toId");
        return new View("index.jsp").addModel("aa", "1111").addModel("id", id).addModel("name", name).addModel("toId", toId);
    }
    @Action("get:/login")
    public View login(){
        List<User> list= testSocketService.getConnections();
        return new View("user.jsp").addModel("title","用户").addModel("list",list);

    }

    @Action("get:/testJson")
    public Data getJson(){
        Map<String,Object> map=new HashMap<>();
        map.put("bb","qqqqqqqq");
        return new Data(map);
    }

}
