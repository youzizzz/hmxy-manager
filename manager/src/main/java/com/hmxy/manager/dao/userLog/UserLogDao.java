package com.hmxy.manager.dao.userLog;

import com.hmxy.dto.UserInfoDTO;
import com.hmxy.dto.UserLogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月8日11:00:29
 */
@Mapper
public interface UserLogDao {

    /**
     * 日志列表
     * @param map
     * @return
     */
    List<UserLogDTO> userLogList(Map<String, Object> map);


    /**
     * 新增log
     * @param userLogDTO
     * @return
     */
    Integer addLog(UserLogDTO userLogDTO);

}
