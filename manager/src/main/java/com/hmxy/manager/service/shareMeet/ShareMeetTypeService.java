package com.hmxy.manager.service.shareMeet;

import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import org.springframework.stereotype.Service;

/**
 * @discripeion:
 * @author: YM10147
 * @date: 2018/11/6 10:23
 */
public interface ShareMeetTypeService {

    /**
     *
     * 分享会类型分页查询
     * @author liangj
     * @param pageInfoResult
     * @return
     */
    PageInfo<ClassIficationDTO> shareMeetTypePage(PageInfo<ClassIficationDTO> pageInfoResult, ClassIficationDTO classIficationDTO);

    /**
     * 分享会类型新增
     * @author liangj
     * @param classIficationDTO
     * @return
     */
    Response<String> shareMeetModalAdd(ClassIficationDTO classIficationDTO);

    /**
     * 分享会类型更新
     * @author liangj
     * @param classIficationDTO
     * @return
     */
    Response<String> shareMeetModalUpdate(ClassIficationDTO classIficationDTO);
}
