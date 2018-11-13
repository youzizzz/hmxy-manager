package com.hmxy.manager.dao.user;

import com.hmxy.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月8日11:00:29
 */
@Mapper
public interface UserDao {

    /**
     * 用户列表
     * @param map
     * @return
     */
    List<UserInfoDTO> userList(Map<String,Object> map);


    /**
     * 登录
     * @param userInfoDTO
     * @return
     */
    List<UserInfoDTO> login(UserInfoDTO userInfoDTO);

    /**
     * 根据ID获取用户信息
     * @param userId
     * @return
     */
    UserInfoDTO findOneUserById(String userId);

    /**
     * 新增一个用户
     * @param userInfoDTO
     * @return
     */
    Integer saveUser(UserInfoDTO userInfoDTO);

    /**
     * 修改一个用户
     * @param userInfoDTO
     * @return
     */
    Integer updateUser(UserInfoDTO userInfoDTO);
}
