package com.hmxy.manager.service.user.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.manager.dao.user.UserDao;
import com.hmxy.manager.service.user.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户列表查询
     *
     * @param pageInfoResult
     * @param userInfoDTO
     * @return
     * @author liangj
     */
    public PageInfo<UserInfoDTO> userPage(PageInfo<UserInfoDTO> pageInfoResult, UserInfoDTO userInfoDTO) {
        PageHelper.startPage(pageInfoResult.getPageNum(), pageInfoResult.getPageSize());
        Map<String, Object> paramMap = null;

        //实体对象转成请求map
        try {
            paramMap = BeanUtil.beanToMap(userInfoDTO);
        } catch (Exception e) {
        }
        List<UserInfoDTO> list = new ArrayList<UserInfoDTO>();
        list = userDao.userList(paramMap);
        Page<UserInfoDTO> page = (Page)list;
        return PageUtils.convertPage(page);
    }

    /**
     * 登录
     *
     * @param userInfoDTO
     */
    @Override
    public List<UserInfoDTO> login(UserInfoDTO userInfoDTO) {
        return userDao.login(userInfoDTO);
    }
}
