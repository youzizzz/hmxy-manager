package com.hmxy.manager.controller.area;

import com.hmxy.dto.AreaDTO;
import com.hmxy.dto.UserInfoDTO;
import com.hmxy.enums.ObjectEnum;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 地址管理
 * @author tangyouzhi
 */
@Controller
@RequestMapping("/area")
public class AreaController extends BaseController {


    @Autowired
    private AreaService areaService;

    /**
     * 页面跳转
     * @return
     */
    @RequestMapping(value = "/toAreaPage",method = RequestMethod.GET)
    public String toAreaPage(){
        return "/area/area_list";
    }


    /**
     * 添加一个地址
     * @param areaDTO
     * @return
     */
    @RequestMapping(path = "/addArea",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> saveArea(AreaDTO areaDTO){
        UserInfoDTO currentUser=findCurrentUser();
        areaDTO.setUpdateBy(currentUser.getUserId());
        areaDTO.setUpdateDate(new Date());
        areaDTO.setCreatorBy(currentUser.getUserId());
        areaDTO.setCreatorDate(new Date());
        areaDTO.setStatus(ObjectEnum.effective.getStatus());
        return areaService.addCity(areaDTO);

    }

    /**
     * 修改地址信息
     * @param areaDTO
     * @return
     */
    @RequestMapping(path = "/updateArea",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> updateArea(AreaDTO areaDTO){
        UserInfoDTO currentUser=findCurrentUser();
        areaDTO.setUpdateBy(currentUser.getUserId());
        areaDTO.setUpdateDate(new Date());
        return areaService.updateCity(areaDTO);
    }

    /**
     * 检查地址是否存在
     * @param areaDTO
     * @return
     */
    @RequestMapping(path = "/checkAreaExists",method = RequestMethod.GET)
    @ResponseBody
    public Response<String> checkAreaExists(AreaDTO areaDTO){
        areaDTO.setStatus(ObjectEnum.effective.getStatus());
        return areaService.checkCityExists(areaDTO);
    }

    /**
     * 根据ID获取一个地址信息
     * @param areId
     * @return
     */
    @RequestMapping(path = "/findOneArea",method = RequestMethod.GET)
    @ResponseBody
    public Response<AreaDTO> findAreaById(String areId){
        return areaService.findOneArea(areId);
    }

    /**
     * 地址分类
     * @param page
     * @param limit
     * @param areaDTO
     * @return
     */
    @RequestMapping("/listPage")
    @ResponseBody
    public PageInfo<AreaDTO> list(int page,int limit,AreaDTO areaDTO){
        PageInfo<AreaDTO> pageInfoResult = new PageInfo<AreaDTO>();
        pageInfoResult.setPageNum(page);
        pageInfoResult.setPageSize(limit);
        pageInfoResult = areaService.AreaPage(pageInfoResult,areaDTO);
        pageInfoResult.setCode("0");
        return pageInfoResult;
    }

    /**
     * 获取所有区域
     * @author liangj
     * @return
     */
    @RequestMapping(value = "/getAreaList",method = RequestMethod.POST)
    @ResponseBody
    public List<AreaDTO> getAreaList(){
        return areaService.getAreaList();
    }
}
