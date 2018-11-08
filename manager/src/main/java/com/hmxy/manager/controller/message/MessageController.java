package com.hmxy.manager.controller.message;

import com.hmxy.dto.MessageDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.DriverManager;


/**
 * 消息管理
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

}
