package com.hmxy.manager.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
@Component
public class LoginInteceptor implements HandlerInterceptor {

    /**
     * 登录信息在session中的Key
     */
    @Value("session.storage.name")
    private String storageName;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String uri=request.getRequestURL().toString();
       if(uri.startsWith("/login")){
           return true;
       }

       HttpSession session=request.getSession();
       return null==session.getAttribute(storageName)?false:true;

    }
}
