package com.hmxy.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tangyouzhi
 */
@Controller
public class IndexController extends BaseController {

    /**
     * 默认首页
     *
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("currentUser",findCurrentUser());
        return modelAndView;
    }

    /**
     * 跳转到默认页面
     */
    @GetMapping("/toDefaultPage")
    public String toDefaultHtml(){
        return "mainPage";
    }
}
