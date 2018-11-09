package com.hmxy.manager.service.userLog.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.UserLogDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.manager.dao.userLog.UserLogDao;
import com.hmxy.manager.service.userLog.UserLogService;
import com.hmxy.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月8日11:00:05
 */

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogDao userLogDao;

    /**
     * 日志列表查询
     *
     * @param pageInfoResult
     * @param userLogDTO
     * @return
     * @author liangj
     */
    @Override
    public PageInfo<UserLogDTO> userListPage(PageInfo<UserLogDTO> pageInfoResult, UserLogDTO userLogDTO) {
        PageHelper.startPage(pageInfoResult.getPageNum(), pageInfoResult.getPageSize());
        Map<String, Object> paramMap = null;

        //实体对象转成请求map
        try {
            paramMap = BeanUtil.beanToMap(userLogDTO);
        } catch (Exception e) {
        }
        List<UserLogDTO> list = new ArrayList<UserLogDTO>();
        list = userLogDao.userLogList(paramMap);
        Page<UserLogDTO> page = (Page) list;
        return PageUtils.convertPage(page);
    }
}
