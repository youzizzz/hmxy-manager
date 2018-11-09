package com.hmxy.manager.controller.shareMeet;

import com.hmxy.manager.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/9 15:40
 */
@Controller
@RequestMapping("/shareMeet")
public class ShareMeetController extends BaseController {

    /**
     * 页面跳转
     * @return
     */
    @RequestMapping(value = "/toShareMeetPage",method = RequestMethod.GET)
    public String toShareMeetPage(){
        return "/shareMeet/shareMeet";
    }

}
