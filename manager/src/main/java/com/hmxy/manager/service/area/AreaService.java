package com.hmxy.manager.service.area;


import com.hmxy.dto.AreaDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;

import java.util.List;

/**
 * 地址管理
 *
 * @author tangyouzhi
 */
public interface AreaService {
    /**
     * 地址分页查询
     *
     * @param pageInfoResult
     * @return
     * @author tangyouzhi
     */
    PageInfo<AreaDTO> AreaPage(PageInfo<AreaDTO> pageInfoResult, AreaDTO areaDTO);

    /**
     * 校验地址是否存在
     *
     * @param areaDTO
     * @return
     */
    Response<String> checkCityExists(AreaDTO areaDTO);

    /**
     * 新增地址
     *
     * @param areaDTO
     * @return
     */
    Response<String>  addCity(AreaDTO areaDTO);

    /**
     * 修改地址信息
     *
     * @param areaDTO
     * @return
     */
    Response<String> updateCity(AreaDTO areaDTO);

    /**
     * 根据ID查询一个地址信息
     * @param areId
     * @return
     */
    Response<AreaDTO> findOneArea(String areId);

    /**
     * 获取所有区域
     * @author liangj
     * @return
     */
    List<AreaDTO> getAreaList();
}
