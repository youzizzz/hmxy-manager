package com.hmxy.manager.service.user.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.MessageDTO;
import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.user.UserDao;
import com.hmxy.manager.service.user.UserService;
import com.hmxy.util.BeanUtil;
import com.hmxy.util.UUIDUtil;
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
    @Override
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
        Page<UserInfoDTO> page = (Page) list;
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

    /**
     * 根据ID获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Response<UserInfoDTO> findOneUserById(String userId) {
        return new Response<UserInfoDTO>().setMessage("查询成功!").setStatusCode(HttpStatusEnum.success.getCode()).setData(userDao.findOneUserById(userId));
    }

    /**
     * 新增一个用户
     *
     * @param userInfoDTO
     * @return
     */
    @Override
    public Response<String> saveUser(UserInfoDTO userInfoDTO) {
        userInfoDTO.setUserId(UUIDUtil.generateUUID());
        int result = userDao.saveUser(userInfoDTO);
        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode())
                .setMessage(result > 0 ? "新增用户成功" : "新增用户失败")
                .setData(result > 0 ? "success" : "error");
    }

    /**
     * 修改一个用户
     *
     * @param userInfoDTO
     * @return
     */
    @Override
    public Response<String> updateUser(UserInfoDTO userInfoDTO) {
        int result = userDao.updateUser(userInfoDTO);
        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode())
                .setMessage(result > 0 ? "用户信息更新成功" : "用户信息更新失败")
                .setData(result > 0 ? "success" : "error");
    }
}
