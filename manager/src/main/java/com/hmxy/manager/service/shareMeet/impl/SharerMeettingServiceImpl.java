package com.hmxy.manager.service.shareMeet.impl;


import com.hmxy.dto.SharerMeettingDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.shareMeet.SysSharerMeettingDao;
import com.hmxy.manager.service.shareMeet.SharerMeettingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/13 17:26
 */
@Service
public class SharerMeettingServiceImpl implements SharerMeettingService {

    @Autowired
    private SysSharerMeettingDao sysSharerMeettingDao;

    @Override
    public Response<String> sharerMeettingAdd(SharerMeettingDTO sharerMeettingDTO) {
        Map<String,Object> map = new HashMap<String,Object>();
        if (StringUtils.isNotBlank(sharerMeettingDTO.getSharerId())){
            map.put("sharerId",sharerMeettingDTO.getSharerId());
        } else {
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享者不能为空");
        }
        if (StringUtils.isNotBlank(sharerMeettingDTO.getMettingId())){
            map.put("mettingId",sharerMeettingDTO.getMettingId());
        } else {
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会不能为空");
        }
        List<SharerMeettingDTO> list = new ArrayList<SharerMeettingDTO>();
        list = sysSharerMeettingDao.getSharerMeettingList(map);

        if(null!=list&&list.size()>0){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("已经用此分享者");
        }
        int count = 0;
        count = sysSharerMeettingDao.sharerMeettingAdd(sharerMeettingDTO);
        if(count<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("新增分享者和分享会信息失败");
        }
        return  new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage("新增分享者和分享会信息成功");
    }
}
