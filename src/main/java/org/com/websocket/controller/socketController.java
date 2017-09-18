package org.com.websocket.controller;

import org.smart4j.annotation.Action;
import org.smart4j.annotation.Controller;
import org.smart4j.bean.View;

/**
 * Created by dkw on 2017/9/15.
 */
@Controller
public class socketController {
    @Action("get:/index")
    public View index(){
        return new View("index.jsp").addModel("aa", "1111");
    }

}
