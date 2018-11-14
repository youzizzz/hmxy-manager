package com.hmxy.manager.controller.shareMeet;

import com.hmxy.dto.ShareDetailDTO;
import com.hmxy.dto.ShareMeetDTO;
import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.shareMeet.ShareMeetService;
import com.hmxy.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
    public PageInfo<ShareMeetDTO> shareMeetPage(ShareMeetDTO shareMeetingDTO, int page, int limit){
        PageInfo<ShareMeetDTO> pageInfoResult = new PageInfo<ShareMeetDTO>();
        pageInfoResult.setPageNum(page);
        pageInfoResult.setPageSize(limit);
        pageInfoResult = shareMeetService.shareMeetPage(pageInfoResult,shareMeetingDTO);
        pageInfoResult.setCode("0");
        return pageInfoResult;
    }

    /**
     * 通过id获取分享会
     * @author liangj
     * @param smId
     * @return
     */
    @RequestMapping(value = "/getShareMeetById",method = RequestMethod.POST)
    @ResponseBody
    public ShareMeetDTO getShareMeetById(String smId){
        return shareMeetService.getShareMeetById(smId);
    }
    /**
     * 通过id获取分享会详情
     * @author liangj
     * @param detailId
     * @return
     */
    @RequestMapping(value = "/getShareMeetDetailById",method = RequestMethod.POST)
    @ResponseBody
    public ShareDetailDTO getShareMeetDetailById(String detailId){
        return shareMeetService.getShareMeetDetailById(detailId);
    }

    /**
     * 分享会新增
     * @author liangj
     * @param shareMeetingDTO
     * @param shareDetailDTO
     * @return
     */
    @RequestMapping(value = "/shareMeetAdd",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> shareMeetAdd(ShareMeetDTO shareMeetingDTO, ShareDetailDTO shareDetailDTO){
        //当前登录用户
        UserInfoDTO user = findCurrentUser();
        String userId = user.getUserId();
        Date date = new Date();

        String uuid = UUIDUtil.generateUUID();
        String uuid2 = UUIDUtil.generateUUID();

        shareMeetingDTO.setSmId(uuid);
        shareMeetingDTO.setDetailId(uuid2);
        shareMeetingDTO.setCreatorBy(userId);
        shareMeetingDTO.setCreatorDate(date);
        shareMeetingDTO.setUpdateBy(userId);
        shareMeetingDTO.setUpdateDate(date);
        shareMeetingDTO.setStatus("0");


        shareDetailDTO.setDesId(uuid2);
        shareDetailDTO.setCreatorBy(userId);
        shareDetailDTO.setCreatorDate(date);
        shareDetailDTO.setUpdateBy(userId);
        shareDetailDTO.setUpdateDate(date);
        shareDetailDTO.setStatus("0");
        return shareMeetService.shareMeetAdd(shareMeetingDTO,shareDetailDTO);
    }
    /**
     * 分享会更新
     * @author liangj
     * @param shareMeetingDTO
     * @param shareDetailDTO
     * @return
     */
    @RequestMapping(value = "/shareMeetUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> shareMeetUpdate(ShareMeetDTO shareMeetingDTO, ShareDetailDTO shareDetailDTO){

        if(StringUtils.isBlank(shareMeetingDTO.getSmId())){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会id不能为空");
        }
        if(StringUtils.isBlank(shareDetailDTO.getDesId())){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会详情id不能为空");
        }

        //当前登录用户
        UserInfoDTO user = findCurrentUser();
        String userId = user.getUserId();
        Date date = new Date();


        shareMeetingDTO.setUpdateBy(userId);
        shareMeetingDTO.setUpdateDate(date);


        shareDetailDTO.setUpdateBy(userId);
        shareDetailDTO.setUpdateDate(date);
        return shareMeetService.shareMeetUpdate(shareMeetingDTO,shareDetailDTO);
    }

}
