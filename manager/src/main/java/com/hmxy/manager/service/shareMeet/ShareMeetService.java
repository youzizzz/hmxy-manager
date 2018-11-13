package com.hmxy.manager.service.shareMeet;

import com.hmxy.dto.ShareDetailDTO;
import com.hmxy.dto.ShareMeetingDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;

/**
 * @discripeion:
 * @author: liangj
 * @date: 2018/11/9 17:03
 */
public interface ShareMeetService {
    /**
     *
     * 分享会分页查询
     * @author liangj
     * @param pageInfoResult
     * @return
     */
    PageInfo<ShareMeetingDTO> shareMeetPage(PageInfo<ShareMeetingDTO> pageInfoResult, ShareMeetingDTO shareMeetingDTO);

    /**
     * 分享会新增
     * @author liangj
     * @param shareMeetingDTO
     * @param shareDetailDTO
     * @return
     */
    Response<String> shareMeetAdd(ShareMeetingDTO shareMeetingDTO, ShareDetailDTO shareDetailDTO);

    /**
     * 通过id获取分享会
     * @author liangj
     * @param smId
     * @return
     */
    ShareMeetingDTO getShareMeetById(String smId);

    /**
     * 通过id获取分享会详情
     * @author liangj
     * @param detailId
     * @return
     */
    ShareDetailDTO getShareMeetDetailById(String detailId);

    /**
     * 分享会更新
     * @author liangj
     * @param shareMeetingDTO
     * @param shareDetailDTO
     * @return
     */
    Response<String> shareMeetUpdate(ShareMeetingDTO shareMeetingDTO, ShareDetailDTO shareDetailDTO);
}
