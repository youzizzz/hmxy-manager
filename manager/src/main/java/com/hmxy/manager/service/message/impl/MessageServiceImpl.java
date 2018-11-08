package com.hmxy.manager.service.message.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.dto.MessageDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.PageUtils;
import com.hmxy.manager.dao.message.MessageDao;
import com.hmxy.manager.service.message.MessageService;
import com.hmxy.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: tangyouzhi
 * @date: 2018年11月7日09:49:35
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public PageInfo<MessageDTO> MessageListPage(PageInfo<MessageDTO> pageInfoResult, MessageDTO messageDTO) {
        PageHelper.startPage(pageInfoResult.getPageNum(), pageInfoResult.getPageSize());
        Map<String, Object> paramMap = null;

        //实体对象转成请求map
        try {
            paramMap = BeanUtil.beanToMap(messageDTO);
        } catch (Exception e) {
        }

        List<MessageDTO> list = new ArrayList<MessageDTO>();
        list = messageDao.messageList(paramMap);
        Page<MessageDTO> page = (Page) list;
        return PageUtils.convertPage(page);
    }
}
