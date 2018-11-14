package com.hmxy.manager.service.shareMeet.impl;


import com.hmxy.dto.SharerMeettingDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.shareMeet.SysSharerMeettingDao;
import com.hmxy.manager.service.shareMeet.SharerMeettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        int count = 0;
        count = sysSharerMeettingDao.sharerMeettingAdd(sharerMeettingDTO);
        if(count<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("新增分享者和分享会信息失败");
        }
        return  new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage("新增分享者和分享会信息成功");
    }
}
