package com.hmxy.manager.service.shareMeet;

import com.hmxy.dto.ShareMeetingDTO;
import com.hmxy.http.PageInfo;

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
}
