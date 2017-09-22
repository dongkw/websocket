package org.com.websocket.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by dkw on 2017/9/22.
 */
public class LogProxy implements MethodInterceptor{
    private static Logger log=Logger.getLogger(LogProxy.class);
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("++++++after ++++++");
        log.info(method.getName());
        Object o1 = methodProxy.invokeSuper(o, args);
        log.info("++++++before ++++++");

        return o1;
    }


}
