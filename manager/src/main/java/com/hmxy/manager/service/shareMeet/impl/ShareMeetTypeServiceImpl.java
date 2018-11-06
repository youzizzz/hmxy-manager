package com.hmxy.manager.service.shareMeet.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.manager.service.shareMeet.ShareMeetTypeService;
import com.hmxy.manager.dao.shareMeet.ShareMeetTypeDao;
import com.hmxy.manager.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        /*if(null!=list&&list.size()>0){
            pageInfoResult.setRows(list);
        }
        int count = 0 ;
        count = shareMeetTypeDao.shareMeetTypeListCount(paramMap);
        pageInfoResult.setCount(count);*/
        return PageUtils.convertPage(page);
    }
}
