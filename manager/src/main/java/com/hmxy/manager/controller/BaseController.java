package com.hmxy.manager.controller;

import com.hmxy.dto.UserInfoDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * 基类
 *
 * @author youzi
 */
@Component
@Data
public class BaseController implements Serializable {

    private HttpServletRequest request;

    private HttpServletResponse response;

    private HttpSession session;

    private Environment env;

    /**
     * 登录信息在session中的Key
     */
    private String storageName;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
        storageName = env.getProperty("session.storage.name");
    }

    @ModelAttribute
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    /**
     * 获取当前登录用户
     * @return
     */
    protected UserInfoDTO findCurrentUser(){
       return (UserInfoDTO) session.getAttribute(storageName);
    }

}
