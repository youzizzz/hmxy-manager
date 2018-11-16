package com.hmxy.manager.service.area.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.AreaDTO;
import com.hmxy.dto.MessageDTO;
import com.hmxy.enums.ObjectEnum;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.http.Response;
import com.hmxy.manager.dao.area.AreaDao;
import com.hmxy.manager.dao.message.MessageDao;
import com.hmxy.manager.service.area.AreaService;
import com.hmxy.manager.service.message.MessageService;
import com.hmxy.util.BeanUtil;
import com.hmxy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月7日15:53:45
 */

@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaDao areaDao;

    /**
     * 地址类型分页查询
     *
     * @param pageInfoResult
     * @param areaDTO
     * @return
     * @author tangyouzhi
     */
    @Override
    public PageInfo<AreaDTO> AreaPage(PageInfo<AreaDTO> pageInfoResult, AreaDTO areaDTO) {
        PageHelper.startPage(pageInfoResult.getPageNum(), pageInfoResult.getPageSize());
        Map<String, Object> paramMap = null;

        //实体对象转成请求map
        try {
            paramMap = BeanUtil.beanToMap(areaDTO);
        } catch (Exception e) {
        }

        List<AreaDTO> list = new ArrayList<AreaDTO>();
        list = areaDao.areaList(paramMap);
        Page<AreaDTO> page = (Page) list;
        return PageUtils.convertPage(page);
    }

    /**
     * 校验地址是否存在
     *
     * @param areaDTO
     * @return
     */
    @Override
    public Response<String> checkCityExists(AreaDTO areaDTO) {
        int result = areaDao.checkCityExists(areaDTO);
        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage(result > 0 ? "城市已经被登记!" : "城市没有被登记过").setData(result > 0 ? "error" : "success");
    }

    /**
     * 新增地址
     *
     * @param areaDTO
     * @return
     */
    @Override
    public Response<String> addCity(AreaDTO areaDTO) {
        areaDTO.setAreId(UUIDUtil.generateUUID());
        int result = areaDao.addCity(areaDTO);
        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode()).setMessage(result > 0 ? "地址新增成功" : "地址新增失败").setData(result > 0 ? "success" : "error");
    }

    /**
     * 修改地址信息
     *
     * @param areaDTO
     * @return
     */
    @Override
    public Response<String> updateCity(AreaDTO areaDTO) {
        int result = areaDao.updateCity(areaDTO);
        return new Response<String>().setStatusCode(HttpStatusEnum.success.getCode())
                .setMessage(result > 0 ? "地址修改成功" : "地址修改失败")
                .setData(result > 0 ? "success" : "error");
    }

    /**
     * 根据ID查询一个地址信息
     *
     * @param areId
     * @return
     */
    @Override
    public Response<AreaDTO> findOneArea(String areId) {
        return new Response<AreaDTO>().setData(areaDao.findOneArea(areId))
                .setStatusCode(HttpStatusEnum.success.getCode())
                .setMessage("查询成功");
    }

    @Override
    public List<AreaDTO> getAreaList() {
        List<AreaDTO> list = new ArrayList<AreaDTO>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("status", ObjectEnum.effective.getStatus());
        list = areaDao.areaList(paramMap);
        return list;
    }
}
