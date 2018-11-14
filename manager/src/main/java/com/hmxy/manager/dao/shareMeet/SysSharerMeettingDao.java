package com.hmxy.manager.dao.shareMeet;

import com.hmxy.dto.SharerMeettingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/9 15:25
 */
@Mapper
public interface SysSharerMeettingDao {
    /**
     * 新增分享者和分享会信息
     * @param sharerMeettingDTO
     * @return
     */
    int sharerMeettingAdd(SharerMeettingDTO sharerMeettingDTO);

    /**
     * 新增分享者和分享会信息查询
     * @param map
     * @return
     */
    List<SharerMeettingDTO> getSharerMeettingList(Map<String, Object> map);
}
