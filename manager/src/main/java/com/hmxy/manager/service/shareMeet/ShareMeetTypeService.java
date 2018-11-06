package com.hmxy.manager.service.shareMeet;

import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.http.PageInfo;
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
}
