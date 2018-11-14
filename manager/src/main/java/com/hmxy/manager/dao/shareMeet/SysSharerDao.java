package com.hmxy.manager.dao.shareMeet;

import com.hmxy.dto.SysSharerDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/13 14:57
 */
@Mapper
public interface SysSharerDao {

    /**
     * 通过分享会id获取分享者信息
     * @param shareId
     * @return
     */
    List<SysSharerDto> getSharerListBySaMId(String shareId);

    /**
     * 条件查询分享者信息
     * @param map
     * @return
     */
    List<SysSharerDto> getSharerList(Map<String, Object> map);

    /**
     * 新增分享者
     * @param sharerAdd
     * @return
     */
    int sharerAdd(SysSharerDto sharerAdd);
}
