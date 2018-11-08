package com.hmxy.manager.controller.shareMeet;

import com.alibaba.fastjson.JSONObject;
import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.shareMeet.ShareMeetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @discripeion: 分享会管理ontroller
 * @author: liangj
 * @date: 2018/11/5 16:51
 */
@Controller
@RequestMapping("/shareMeet")
public class ShareMeetTypeController extends BaseController {

    @Autowired
    private ShareMeetTypeService shareMeetTypeService;
    /**
     * 页面跳转
     * @return
     */
    @RequestMapping(value = "/toShareMeetTypePage",method = RequestMethod.GET)
    public String toShareMeetTypePage(){
        return "/shareMeet/shareMeetType";
    }


    /**
     * 分享会类型分页查询
     * @author liangj
     * @param classIficationDTO
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/listPage",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<ClassIficationDTO> shareMeetTypePage(ClassIficationDTO classIficationDTO, int page, int limit){
        PageInfo<ClassIficationDTO> pageInfoResult = new PageInfo<ClassIficationDTO>();
        pageInfoResult.setPageNum(page);
        pageInfoResult.setPageSize(limit);
        pageInfoResult = shareMeetTypeService.shareMeetTypePage(pageInfoResult,classIficationDTO);
        pageInfoResult.setCode("0");
        return pageInfoResult;
    }

    /**
     * 分享会类型新增
     * @author liangj
     * @param classIficationDTO
     * @return
     */
    @RequestMapping(value = "/shareMeetModalAdd",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> shareMeetModalAdd(ClassIficationDTO classIficationDTO){
        return shareMeetTypeService.shareMeetModalAdd(classIficationDTO);
    }

    /**
     * 分享会类型更新
     * @author liangj
     * @param classIficationDTO
     * @return
     */
    @RequestMapping(value = "/shareMeetModalUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> shareMeetModalUpdate(ClassIficationDTO classIficationDTO){
        return shareMeetTypeService.shareMeetModalUpdate(classIficationDTO);
    }

    /**
     * 通过id获取分享会类型
     * @author liangj
     * @param cfId
     * @return
     */
    @RequestMapping(value = "/getShareMeetById",method = RequestMethod.POST)
    @ResponseBody
    public ClassIficationDTO getShareMeetById(String cfId){
        return shareMeetTypeService.getShareMeetById(cfId);
    }

}
