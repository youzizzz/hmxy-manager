package com.hmxy.manager.dao.shareMeet;

import com.hmxy.dto.ShareMeetDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/9 15:22
 */
@Mapper
public interface SysShareMeetingDao {
    /**
     * 分享会分页
     * @param map
     * @return
     */
    List<ShareMeetDTO> shareMeetList(Map<String, Object> map);

    /**
     * 分享会新增
     * @param shareMeetingDTO
     * @return
     */
    int shareMeetAdd(ShareMeetDTO shareMeetingDTO);

    /**
     * 通过id获取分享会
     * @author liangj
     * @param smId
     * @return
     */
    List<ShareMeetDTO> getShareMeetById(String smId);

    /**
     * 分享会更新
     * @param shareMeetingDTO
     * @return
     */
    int shareMeetUpdate(ShareMeetDTO shareMeetingDTO);
}
