package com.hmxy.manager.service.shareMeet.impl;

import com.hmxy.dto.SysSharerDto;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.shareMeet.SysSharerDao;
import com.hmxy.manager.service.shareMeet.SysSharerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/13 17:36
 */
@Service
public class SysSharerServiceImpl implements SysSharerService {

    @Autowired
    private SysSharerDao sysSharerDao;

    @Override
    public List<SysSharerDto> getSharerListBySaMId(String mettingId) {

        List<SysSharerDto> list = new ArrayList<SysSharerDto>();
        list = sysSharerDao.getSharerListBySaMId(mettingId);
        return list;
    }

    @Override
    public List<SysSharerDto> getSharerList(Map<String, Object> map) {
        List<SysSharerDto> list = new ArrayList<SysSharerDto>();
        list = sysSharerDao.getSharerList(map);
        return list;
    }

    @Override
    public Response<String> sharerAdd(SysSharerDto sharerAdd) {
        int count = 0;
        count = sysSharerDao.sharerAdd(sharerAdd);
        if(count<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("新增分享者失败");
        }
        return  new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage("新增分享者成功");
    }
}
