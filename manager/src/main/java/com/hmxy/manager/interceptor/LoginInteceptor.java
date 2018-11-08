package com.hmxy.manager.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

/**
 * 登录拦截器
 */
@Component
public class LoginInteceptor implements HandlerInterceptor {

    /**
     * 登录信息在session中的Key
     */
    private String storageName;

    private Environment env;

    /**
     * 登录URL
     */
    private String loginUrl;


    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
        storageName = env.getProperty("session.storage.name");
        loginUrl = env.getProperty("system.login.url");
    }

    /**
     * 请求进入方法前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI().toString();
        if (uri.startsWith(loginUrl)) {
            return true;
        }
        HttpSession session = request.getSession();

        if (null != session.getAttribute(storageName)) {
            return true;
        }
        response.getWriter().print("<script>window.location='/hmxy-manager/client/login'</script>");
        return false;

    }
}
