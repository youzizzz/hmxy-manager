package com.hmxy.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String index() {
        return "index";
    }
}
