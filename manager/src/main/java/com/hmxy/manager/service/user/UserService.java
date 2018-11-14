package com.hmxy.manager.service.user;

import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;

import java.util.List;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月8日10:59:16
 */
public interface UserService {

    /**
     *
     * 用户列表查询
     * @author liangj
     * @param pageInfoResult
     * @return
     */
    PageInfo<UserInfoDTO> userPage(PageInfo<UserInfoDTO> pageInfoResult, UserInfoDTO userInfoDTO);

    /**
     * 登录
     */
    List<UserInfoDTO> login(UserInfoDTO userInfoDTO);

    /**
     * 根据ID获取用户信息
     * @param userId
     * @return
     */
    Response<UserInfoDTO> findOneUserById(String userId);

    /**
     * 新增一个用户
     * @param userInfoDTO
     * @return
     */
    Response<String> saveUser(UserInfoDTO userInfoDTO);

    /**
     * 修改一个用户
     * @param userInfoDTO
     * @return
     */
    Response<String> updateUser(UserInfoDTO userInfoDTO);

    /**
     * 校验用户名是否存在
     * @param userInfoDTO
     * @return
     */
    Response<String> checkUserNameExists(UserInfoDTO userInfoDTO);
}
