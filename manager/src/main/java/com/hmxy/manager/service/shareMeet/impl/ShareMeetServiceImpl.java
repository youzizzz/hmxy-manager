package com.hmxy.manager.service.shareMeet.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.ShareMeetingDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.manager.dao.shareMeet.SysShareMeetingDao;
import com.hmxy.manager.service.shareMeet.ShareMeetService;
import com.hmxy.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
