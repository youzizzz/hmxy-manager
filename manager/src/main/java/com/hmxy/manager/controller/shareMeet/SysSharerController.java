package com.hmxy.manager.controller.shareMeet;

import com.hmxy.dto.ShareMeetDTO;
import com.hmxy.dto.SharerMeettingDTO;
import com.hmxy.dto.SysSharerDto;
import com.hmxy.dto.UserInfoDTO;
import com.hmxy.enums.ObjectEnum;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.shareMeet.SysSharerService;
import com.hmxy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/13 17:33
 */
@Controller
@RequestMapping("/sharer")
public class SysSharerController extends BaseController {

    @Autowired
    private SysSharerService sysSharerService;

    /**
     * 通过分享会id获取分享者信息
     * @param mettingId
     * @return
     */
    @RequestMapping(value = "/getSharerListBySaMId",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<SysSharerDto>> getSharerListBySaMId(String mettingId){
        List<SysSharerDto> list = new ArrayList<SysSharerDto>();
        list = sysSharerService.getSharerListBySaMId(mettingId);
        return  new Response<List<SysSharerDto>>().setStatusCode("0").setData(list);
    }

    /**
     * 获取所有有效的分享者信息
     * @return
     */
    @RequestMapping(value = "/getSharerList",method = RequestMethod.POST)
    @ResponseBody
    public List<SysSharerDto> getSharerList(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status", ObjectEnum.effective.getStatus());
        return sysSharerService.getSharerList(map);
    }


    /**
     * 分享者新增
     * @param sysSharerDto
     * @return
     */
    @RequestMapping(value = "/sharerAdd",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> sharerAdd(SysSharerDto sysSharerDto){

        //当前登录用户
        UserInfoDTO user = findCurrentUser();
        String userId = user.getUserId();
        Date date = new Date();
        String uuid = UUIDUtil.generateUUID();

        sysSharerDto.setSharerId(uuid);
        sysSharerDto.setCreatorBy(userId);
        sysSharerDto.setCreatorDate(date);
        sysSharerDto.setUpdateBy(userId);
        sysSharerDto.setUpdateDate(date);
        sysSharerDto.setStatus("0");


        return sysSharerService.sharerAdd(sysSharerDto);
    }

}
