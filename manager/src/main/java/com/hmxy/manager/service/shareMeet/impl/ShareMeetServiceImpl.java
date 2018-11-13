package com.hmxy.manager.service.shareMeet.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.ShareDetailDTO;
import com.hmxy.dto.ShareMeetingDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.shareMeet.SysShareDetailDao;
import com.hmxy.manager.dao.shareMeet.SysShareMeetingDao;
import com.hmxy.manager.service.shareMeet.ShareMeetService;
import com.hmxy.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/9 17:04
 */
@Service
public class ShareMeetServiceImpl  implements ShareMeetService {

    @Autowired
    private SysShareMeetingDao shareMeetDao;

    @Autowired
    private SysShareDetailDao sysShareDetailDao;

    @Override
    public PageInfo<ShareMeetingDTO> shareMeetPage(PageInfo<ShareMeetingDTO> pageInfoResult, ShareMeetingDTO shareMeetingDTO) {
        PageHelper.startPage(pageInfoResult.getPageNum(), pageInfoResult.getPageSize());
        Map<String, Object> paramMap = null;

        //实体对象转成请求map
        try {
            paramMap = BeanUtil.beanToMap(shareMeetingDTO);
        } catch (Exception e) {
        }
        List<ShareMeetingDTO> list = new ArrayList<ShareMeetingDTO>();
        list = shareMeetDao.shareMeetList(paramMap);
        Page<ShareMeetingDTO> page = (Page)list;
        return PageUtils.convertPage(page);
    }

    @Override
    @Transactional
    public Response<String> shareMeetAdd(ShareMeetingDTO shareMeetingDTO, ShareDetailDTO shareDetailDTO) {
        int count = 0;
        count = shareMeetDao.shareMeetAdd(shareMeetingDTO);
        if(count<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会插入失败");
        }

        int count1 = 0;
        count1 = sysShareDetailDao.shareDetailAdd(shareDetailDTO);
        if(count1<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会详情插入失败");
        }

        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage("分享会新增成功");
    }

    @Override
    @Transactional
    public Response<String> shareMeetUpdate(ShareMeetingDTO shareMeetingDTO, ShareDetailDTO shareDetailDTO) {
        int count = 0;
        count = shareMeetDao.shareMeetUpdate(shareMeetingDTO);
        if(count<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会更新失败");
        }

        int count1 = 0;
        count1 = sysShareDetailDao.shareDetailUpdate(shareDetailDTO);
        if(count1<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会详情更新失败");
        }

        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage("分享会更新成功");
    }

    @Override
    public ShareMeetingDTO getShareMeetById(String smId) {
        List<ShareMeetingDTO> list = new ArrayList<ShareMeetingDTO>();
        list = shareMeetDao.getShareMeetById(smId);
        if(null!=list&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ShareDetailDTO getShareMeetDetailById(String detailId) {
        List<ShareDetailDTO> list = new ArrayList<ShareDetailDTO>();
        list = sysShareDetailDao.getShareMeetDetailById(detailId);
        if(null!=list&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
