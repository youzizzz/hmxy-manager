package com.hmxy.manager.service.user;

import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.PageInfo;

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
}
