package com.hmxy.manager.controller.shareMeet;

import com.hmxy.dto.SharerMeettingDTO;
import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.shareMeet.SharerMeettingService;
import com.hmxy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/9 15:41
 */
@Controller
@RequestMapping("/sharerMeetting")
public class SysSharerMeettingController extends BaseController {

    @Autowired
    private SharerMeettingService sharerMeettingService;


    /**
     * 新增分享者和分享会信息
     * @param sharerMeettingDTO
     * @return
     */
    @RequestMapping(value = "/sharerMeettingAdd",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> sharerMeettingAdd(SharerMeettingDTO sharerMeettingDTO){



        //当前登录用户
        UserInfoDTO user = findCurrentUser();
        String userId = user.getUserId();
        Date date = new Date();
        String uuid = UUIDUtil.generateUUID();

        sharerMeettingDTO.setMuId(uuid);
        sharerMeettingDTO.setCreatorBy(userId);
        sharerMeettingDTO.setCreatorDate(date);
        sharerMeettingDTO.setUpdateBy(userId);
        sharerMeettingDTO.setUpdateDate(date);


        return sharerMeettingService.sharerMeettingAdd(sharerMeettingDTO);
    }

}
