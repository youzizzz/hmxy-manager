package com.hmxy.manager.controller.shareMeet;

import com.alibaba.fastjson.JSONObject;
import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.shareMeet.ShareMeetTypeService;
import com.hmxy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @discripeion: 分享会管理ontroller
 * @author: liangj
 * @date: 2018/11/5 16:51
 */
@Controller
@RequestMapping("/shareMeetType")
public class ShareMeetTypeController extends BaseController {

    @Autowired
    private ShareMeetTypeService shareMeetTypeService;
    /**
     * 页面跳转
     * @return
     */
    @RequestMapping(value = "/toShareMeetTypePage",method = RequestMethod.GET)
    public String toShareMeetTypePage(){
        return "shareMeet/shareMeetType";
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
    @RequestMapping(value = "/shareMeetTypeAdd",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> shareMeetTypeAdd(ClassIficationDTO classIficationDTO){
        //当前登录用户
        UserInfoDTO user = findCurrentUser();
        String userId = user.getUserId();
        Date date = new Date();
        String uuid = UUIDUtil.generateUUID();
        classIficationDTO.setCfId(uuid);
        classIficationDTO.setCreatorBy(userId);
        classIficationDTO.setCreatorDate(date);
        classIficationDTO.setUpdateBy(userId);
        classIficationDTO.setUpdateDate(date);
        return shareMeetTypeService.shareMeetTypeAdd(classIficationDTO);
    }

    /**
     * 分享会类型更新
     * @author liangj
     * @param classIficationDTO
     * @return
     */
    @RequestMapping(value = "/shareMeetTypeUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> shareMeetTypeUpdate(ClassIficationDTO classIficationDTO){
        //当前登录用户
        UserInfoDTO user = findCurrentUser();
        String userId = user.getUserId();
        Date date = new Date();
        classIficationDTO.setUpdateBy(userId);
        classIficationDTO.setUpdateDate(date);
        return shareMeetTypeService.shareMeetTypeUpdate(classIficationDTO);
    }

    /**
     * 通过id获取分享会类型
     * @author liangj
     * @param cfId
     * @return
     */
    @RequestMapping(value = "/getShareMeetTypeById",method = RequestMethod.POST)
    @ResponseBody
    public ClassIficationDTO getShareMeetTypeById(String cfId){
        return shareMeetTypeService.getShareMeetTypeById(cfId);
    }

    /**
     * 获取所有分享会类型
     * @author liangj
     * @return
     */
    @RequestMapping(value = "/getShareMeetTypeList",method = RequestMethod.POST)
    @ResponseBody
    public List<ClassIficationDTO> getShareMeetTypeList(){
        return shareMeetTypeService.getShareMeetTypeList();
    }

}
