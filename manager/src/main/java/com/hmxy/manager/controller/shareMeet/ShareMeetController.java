package com.hmxy.manager.controller.shareMeet;

import com.hmxy.dto.ShareMeetingDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.shareMeet.ShareMeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/9 15:40
 */
@Controller
@RequestMapping("/shareMeet")
public class ShareMeetController extends BaseController {

    @Autowired
    private ShareMeetService shareMeetService;

    /**
     * 页面跳转
     * @return
     */
    @RequestMapping(value = "/toShareMeetPage",method = RequestMethod.GET)
    public String toShareMeetPage(){
        return "shareMeet/shareMeetting";
    }

    /**
     * 分享会分页查询
     * @author liangj
     * @param shareMeetingDTO
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/listPage",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<ShareMeetingDTO> shareMeetPage(ShareMeetingDTO shareMeetingDTO, int page, int limit){
        PageInfo<ShareMeetingDTO> pageInfoResult = new PageInfo<ShareMeetingDTO>();
        pageInfoResult.setPageNum(page);
        pageInfoResult.setPageSize(limit);
        pageInfoResult = shareMeetService.shareMeetPage(pageInfoResult,shareMeetingDTO);
        pageInfoResult.setCode("0");
        return pageInfoResult;
    }

}
