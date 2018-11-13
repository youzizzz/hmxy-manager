package com.hmxy.manager.dao.shareMeet;

import com.hmxy.dto.ShareDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/9 15:23
 */
@Mapper
public interface SysShareDetailDao {
    /**
     * 分享会详情新增
     * @param shareDetailDTO
     * @return
     */
    int shareDetailAdd(ShareDetailDTO shareDetailDTO);

    /**
     * 通过id获取分享会
     * @author liangj
     * @param detailId
     * @return
     */
    List<ShareDetailDTO> getShareMeetDetailById(String detailId);

    /**
     * 分享会详情更新
     * @param shareDetailDTO
     * @return
     */
    int shareDetailUpdate(ShareDetailDTO shareDetailDTO);
}
