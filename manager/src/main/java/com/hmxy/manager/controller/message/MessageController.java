package com.hmxy.manager.controller.message;

import com.hmxy.dto.MessageDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 消息管理
 * @author  tangyouzhi
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {


    @Autowired
    private MessageService messageService;

    /**
     * 跳转页
     * @return
     */
    @GetMapping("/toMessagePage")
    public String toMessagePage(){

        return "/message/message_list";
    }

    /**
     * 信息类型分页查询
     * @author tangyouzhi
     * @param messageDTO
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/listPage",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<MessageDTO> shareMeetTypePage(MessageDTO messageDTO, int page, int limit){
        PageInfo<MessageDTO> pageInfoResult = new PageInfo<MessageDTO>();
        pageInfoResult.setPageNum(page);
        pageInfoResult.setPageSize(limit);
        pageInfoResult = messageService.MessageListPage(pageInfoResult,messageDTO);
        pageInfoResult.setCode("0");
        return pageInfoResult;
    }


    /**
     * 根据messageId获取一条message
     * @param messageId
     * @return
     */
    @RequestMapping(path = "/findMessageById",method = RequestMethod.GET)
    @ResponseBody
    public Response<MessageDTO> findOneMessage(String messageId){
        return messageService.findMessageById(messageId);
    }

    /**
     * 更新一条message
     * @param messageDTO
     * @return
     */
    @RequestMapping(path = "/updateMessage",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> updateMessage(MessageDTO messageDTO){
        messageDTO.setUpdateDate(new Date());
        messageDTO.setUpdateBy(findCurrentUser().getUserId());
        return messageService.updateMessage(messageDTO);
    }

    /**
     * 批量通过
     * @param messageIds
     * @return
     */
    @RequestMapping(path = "/batchRead",method =RequestMethod.POST)
    @ResponseBody
    public Response<String> batchRead(String messageIds){
        return null;
    }

}
