package com.hmxy.manager.controller.completionShare;

import com.hmxy.dto.CompletionShareDTO;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.completionShare.CompletionShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author tangyouzhi
 * @date 2018年11月12日15:18:27
 */
@Controller
@RequestMapping("/completionShare")
public class CompletionShareController extends BaseController {

    @Autowired
    private CompletionShareService completionShareService;

    /**
     * 根据主键获得一条补全信息
     * @return
     */
    @RequestMapping(path = "/findOneUserShare",method = RequestMethod.GET)
    @ResponseBody
    public Response<CompletionShareDTO> findUserShare(String csId){
        return completionShareService.findOneCompletionShare(csId);
    }

    /**
     * 新增用户补全信息
     * @return
     */
    @RequestMapping(path = "/saveUserShare",method = RequestMethod.POST)
    @ResponseBody
    public Response<String> addUserShare(CompletionShareDTO completionShareDTO){
        completionShareDTO.setCreatorBy(findCurrentUser().getUserId());
        completionShareDTO.setUpdateBy(findCurrentUser().getUserId());
        completionShareDTO.setCreatorDate(new Date());
        completionShareDTO.setUpdateDate(new Date());
        return completionShareService.saveCompletionShare(completionShareDTO);
    }

}
