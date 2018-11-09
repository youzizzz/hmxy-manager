package com.hmxy.manager.service.userLog;

import com.hmxy.dto.UserInfoDTO;
import com.hmxy.dto.UserLogDTO;
import com.hmxy.http.PageInfo;

import java.util.List;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月8日10:59:16
 */
public interface UserLogService {

    /**
     *
     * 日志列表查询
     * @author liangj
     * @param pageInfoResult
     * @return
     */
    PageInfo<UserLogDTO> userListPage(PageInfo<UserLogDTO> pageInfoResult, UserLogDTO userLogDTO);

}
