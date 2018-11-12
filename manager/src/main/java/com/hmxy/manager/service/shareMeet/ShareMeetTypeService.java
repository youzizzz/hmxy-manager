package com.hmxy.manager.service.shareMeet;

import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @discripeion:
 * @author: liangj
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
    Response<String> shareMeetTypeAdd(ClassIficationDTO classIficationDTO);

    /**
     * 分享会类型更新
     * @author liangj
     * @param classIficationDTO
     * @return
     */
    Response<String> shareMeetTypeUpdate(ClassIficationDTO classIficationDTO);

    /**
     * 通过id获取分享会类型
     * @author liangj
     * @param cfId
     * @return
     */
    ClassIficationDTO getShareMeetTypeById(String cfId);

    /**
     * 获取所有分享会类型
     * @author liangj
     * @return
     */
    List<ClassIficationDTO> getShareMeetTypeList();
}
