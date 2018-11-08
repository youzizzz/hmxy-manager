package com.hmxy.manager.dao.area;

import com.hmxy.dto.AreaDTO;
import com.hmxy.dto.MessageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: tangyozhi
 * @date:  2018年11月7日15:50:07
 */
@Mapper
public interface AreaDao {

    /**
     * 地址类型列表
     * @param map
     * @return
     */
    List<AreaDTO> areaList(Map<String, Object> map);

}
