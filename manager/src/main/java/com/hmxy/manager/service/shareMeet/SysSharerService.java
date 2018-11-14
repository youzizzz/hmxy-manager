package com.hmxy.manager.service.shareMeet;

import com.hmxy.dto.SysSharerDto;
import com.hmxy.http.Response;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/13 17:35
 */
public interface SysSharerService {

    /**
     * 通过分享会id获取分享者信息
     * @param mettingId
     * @return
     */
    List<SysSharerDto> getSharerListBySaMId(String mettingId);

    /**
     * 条件查询分享者信息
     * @param map
     * @return
     */
    List<SysSharerDto> getSharerList(Map<String, Object> map);

    /**
     * 分享者新增
     * @param sysSharerDto
     * @return
     */
    Response<String> sharerAdd(SysSharerDto sysSharerDto);
}
