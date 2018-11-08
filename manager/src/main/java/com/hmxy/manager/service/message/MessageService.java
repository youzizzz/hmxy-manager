package com.hmxy.manager.service.message;

import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.dto.MessageDTO;
import com.hmxy.http.PageInfo;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月7日09:49:21
 */
public interface MessageService {

    /**
     *
     * 消息类型分页查询
     * @author liangj
     * @param pageInfoResult
     * @return
     */
    PageInfo<MessageDTO> MessageListPage(PageInfo<MessageDTO> pageInfoResult, MessageDTO messageDTO);
}
