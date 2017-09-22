package org.com.websocket.proxy;

import org.apache.log4j.Logger;
import org.smart4j.annotation.Aspect;
import org.smart4j.annotation.Controller;
import org.smart4j.annotation.Service;
import org.smart4j.framework.proxy.AspectProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by dkw on 2017/9/22.
 */

public class LogAsect extends AspectProxy{
    private static Logger log=Logger.getLogger(LogAsect.class);
    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        //super.before(cls, method, params);
        log.info("--------------------");
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
//        super.after(cls, method, params, result);
        log.info("-------------------");
    }

}
