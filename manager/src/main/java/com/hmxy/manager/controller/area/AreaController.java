package com.hmxy.manager.controller.area;

import com.hmxy.manager.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 地址管理
 * @author tangyouzhi
 */
@Controller
@RequestMapping("/area")
public class AreaController extends BaseController {


    /**
     * 页面跳转
     * @return
     */
    @RequestMapping(value = "/toAreaPage",method = RequestMethod.GET)
    public String toAreaPage(){
        return "/area/area_list";
    }
}
