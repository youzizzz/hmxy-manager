package com.hmxy.manager.service.area;


import com.hmxy.dto.AreaDTO;
import com.hmxy.http.PageInfo;

/**
 * 地址管理
 * @author tangyouzhi
 */
public interface AreaService {
    /**
     *
     * 分享会类型分页查询
     * @author liangj
     * @param pageInfoResult
     * @return
     */
    PageInfo<AreaDTO> MessageListPage(PageInfo<AreaDTO> pageInfoResult, AreaDTO areaDTO);
}
