package com.hmxy.manager.service.shareMeet.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.shareMeet.ShareMeetTypeDao;
import com.hmxy.manager.service.shareMeet.ShareMeetTypeService;
import com.hmxy.util.BeanUtil;
import com.hmxy.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/6 10:26
 */

@Service
public class ShareMeetTypeServiceImpl implements ShareMeetTypeService {

    @Autowired
    private ShareMeetTypeDao shareMeetTypeDao;

    @Override
    public PageInfo<ClassIficationDTO> shareMeetTypePage(PageInfo<ClassIficationDTO> pageInfoResult, ClassIficationDTO classIficationDTO) {
        PageHelper.startPage(pageInfoResult.getPageNum(), pageInfoResult.getPageSize());
        Map<String, Object> paramMap = null;

        //实体对象转成请求map
        try {
            paramMap = BeanUtil.beanToMap(classIficationDTO);
        } catch (Exception e) {
        }
        List<ClassIficationDTO> list = new ArrayList<ClassIficationDTO>();
        list = shareMeetTypeDao.shareMeetTypeList(paramMap);
        Page<ClassIficationDTO> page = (Page)list;
        return PageUtils.convertPage(page);
    }

    @Override
    public Response<String> shareMeetModalAdd(ClassIficationDTO classIficationDTO) {
        int count = 0;
        count = shareMeetTypeDao.shareMeetModalAdd(classIficationDTO);
        if(count<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会类型插入失败");
        }
        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage("分享会类型插入成功");
    }

    @Override
    public Response<String> shareMeetModalUpdate(ClassIficationDTO classIficationDTO) {

        if(StringUtils.isBlank(classIficationDTO.getCfId())){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会类型更新,id不能为空");
        }
        int count = 0;
        count = shareMeetTypeDao.shareMeetModalUpdate(classIficationDTO);
        if(count<1){
            return  new Response<String>().setStatusCode(HttpStatusEnum.error.getCode()).setMessage("分享会类型更新失败");
        }
        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage("分享会类型更新成功");
    }

    @Override
    public ClassIficationDTO getShareMeetById(String cfId) {
        List<ClassIficationDTO> list = new ArrayList<ClassIficationDTO>();
        list = shareMeetTypeDao.getShareMeetById(cfId);
        if(null!=list&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
