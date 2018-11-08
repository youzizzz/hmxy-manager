package com.hmxy.manager.service.area.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.AreaDTO;
import com.hmxy.dto.MessageDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.manager.dao.area.AreaDao;
import com.hmxy.manager.dao.message.MessageDao;
import com.hmxy.manager.service.area.AreaService;
import com.hmxy.manager.service.message.MessageService;
import com.hmxy.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月7日15:53:45
 */

@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaDao areaDao;

    /**
     * 地址类型分页查询
     *
     * @param pageInfoResult
     * @param areaDTO
     * @return
     * @author liangj
     */
    public PageInfo<AreaDTO> MessageListPage(PageInfo<AreaDTO> pageInfoResult, AreaDTO areaDTO) {
        PageHelper.startPage(pageInfoResult.getPageNum(), pageInfoResult.getPageSize());
        Map<String, Object> paramMap = null;

        //实体对象转成请求map
        try {
            paramMap = BeanUtil.beanToMap(areaDTO);
        } catch (Exception e) {
        }

        List<AreaDTO> list = new ArrayList<AreaDTO>();
        list = areaDao.areaList(paramMap);
        Page<AreaDTO> page = (Page) list;
        return PageUtils.convertPage(page);
    }
}
