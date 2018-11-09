package com.hmxy.manager.controller.userLog;

import com.hmxy.dto.UserLogDTO;
import com.hmxy.http.PageInfo;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.userLog.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 操作日志模块
 *
 * @author youzi
 */
@Controller
@RequestMapping("/userLog")
public class UserLogController extends BaseController {

    @Autowired
    private UserLogService userLogService;

    /**
     * 地址分类
     *
     * @param page
     * @param limit
     * @param userLogDTO
     * @return
     */
    @RequestMapping("/listPage")
    @ResponseBody
    public PageInfo<UserLogDTO> list(int page, int limit, UserLogDTO userLogDTO) {
        PageInfo<UserLogDTO> pageInfoResult = new PageInfo<UserLogDTO>();
        pageInfoResult.setPageNum(page);
        pageInfoResult.setPageSize(limit);
        pageInfoResult = userLogService.userListPage(pageInfoResult, userLogDTO);
        pageInfoResult.setCode("0");
        return pageInfoResult;
    }

    /**
     * 跳转页
     * @return
     */
    @RequestMapping("/toLogPage")
    public String toLogPage(){
        return "/userLog/user_log_list";
    }
}
