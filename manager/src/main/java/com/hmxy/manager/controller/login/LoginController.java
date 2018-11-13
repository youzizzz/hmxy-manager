package com.hmxy.manager.controller.login;

import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.user.UserService;
import com.hmxy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 登录Controller
 */
@RequestMapping("/client")
@Controller
public class LoginController extends BaseController {


    @Autowired
    private UserService userService;

    /**
     * 跳转至登录页
     *
     * @return
     */
    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录
     * @param userInfoDTO
     * @return
     */
    @RequestMapping(path = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Response<String> login(UserInfoDTO userInfoDTO) {
        userInfoDTO.setPassword(MD5Util.MD5(userInfoDTO.getPassword()));
        List<UserInfoDTO> resList=userService.login(userInfoDTO);
        if(null==resList||resList.size()==0){
            return new Response<String>().setData("error").setStatusCode(HttpStatusEnum.loginError.getCode()).setMessage("登录失败,账号密码不匹配");
        }
        System.out.println();
        getSession().setAttribute(getStorageName(),resList.get(0));
        return new Response<String>().setData("ok").setStatusCode(HttpStatusEnum.loginSuccess.getCode()).setMessage("登陆成功");
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(path = "/logout",method = RequestMethod.GET)
    public String logout(){
        getSession().invalidate();
        return "client/login";
    }
}
