package com.hmxy.manager.dao.shareMeet;

import com.hmxy.dto.ClassIficationDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: YM10147
 * @date: 2018/11/6 10:22
 */
@Mapper
public interface ShareMeetTypeDao {

    /**
     * 分享会类型分页
     * @param map
     * @return
     */
    List<ClassIficationDTO> shareMeetTypeList( Map<String, Object> map);

//    /**
//     * 分享会类型总数
//     * @param map
//     * @return
//     */
//    int shareMeetTypeListCount(Map<String, Object> map);
}
