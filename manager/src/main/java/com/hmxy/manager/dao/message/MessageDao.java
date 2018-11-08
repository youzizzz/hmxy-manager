package com.hmxy.manager.dao.message;

import com.hmxy.dto.ClassIficationDTO;
import com.hmxy.dto.MessageDTO;
import org.apache.ibatis.annotations.Mapper;
import sun.plugin2.message.Message;

import java.util.List;
import java.util.Map;

/**
 * @discripeion:
 * @author: tangyozhi
 * @date:  2018年11月7日09:49:01
 */
@Mapper
public interface MessageDao {

    /**
     * 消息类型列表
     * @param map
     * @return
     */
    List<MessageDTO> messageList(Map<String, Object> map);

}
