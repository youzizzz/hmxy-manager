package com.hmxy.manager.service.shareMeet.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.shareMeet.ShareMeetTypeDao;
import com.hmxy.manager.service.shareMeet.ShareMeetTypeService;
import com.hmxy.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @discripeion:
 * @author: YM10147
 * @date: 2018/11/6 10:26
 */

@Service
public class ShareMeetTypeServiceImpl implements ShareMeetTypeService {

    @Autowired
    private ShareMeetTypeDao shareMeetTypeDao;

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

    public Response<String> shareMeetModalAdd(ClassIficationDTO classIficationDTO) {
        Response<String> response = new Response<String>();
        Date date = new Date();
        String uuid = UUID.randomUUID().toString().substring(0,8);
        classIficationDTO.setCfId(uuid);
        classIficationDTO.setCreatorBy("1");
        classIficationDTO.setCreatorDate(date);
        classIficationDTO.setUpdateBy("1");
        classIficationDTO.setUpdateDate(date);

        int count = 0;
        count = shareMeetTypeDao.shareMeetModalAdd(classIficationDTO);
        if(count>0){
//            response.s
        }
        return null;
    }

    public Response<String> shareMeetModalUpdate(ClassIficationDTO classIficationDTO) {
        Date date = new Date();
        classIficationDTO.setUpdateBy("1");
        classIficationDTO.setUpdateDate(date);
        int count = 0;
        count = shareMeetTypeDao.shareMeetModalUpdate(classIficationDTO);
        return null;
    }
}
