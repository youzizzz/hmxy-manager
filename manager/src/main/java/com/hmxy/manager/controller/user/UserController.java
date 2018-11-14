package com.hmxy.manager.controller.user;

import com.hmxy.dto.AreaDTO;
import com.hmxy.dto.MessageDTO;
import com.hmxy.dto.UserInfoDTO;
import com.hmxy.enums.ObjectEnum;
import com.hmxy.http.PageInfo;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;
import com.hmxy.manager.service.user.UserService;
import com.hmxy.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户模块
 * 
 * @author youzi
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 跳转页
	 * @return
	 */
	@RequestMapping("/toUserPage")
	public String toUserPage(){
		return "user/user_list";
	}


	/**
	 * 信息类型分页查询
	 * @author tangyouzhi
	 * @param userInfoDTO
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/listPage",method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<UserInfoDTO> shareMeetTypePage(UserInfoDTO userInfoDTO, int page, int limit){
		PageInfo<UserInfoDTO> pageInfoResult = new PageInfo<UserInfoDTO>();
		pageInfoResult.setPageNum(page);
		pageInfoResult.setPageSize(limit);
		pageInfoResult = userService.userPage(pageInfoResult,userInfoDTO);
		pageInfoResult.setCode("0");
		return pageInfoResult;
	}

	/**
	 * 根据userId获取一个用户信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(path = "/findUserById",method = RequestMethod.GET)
	@ResponseBody
	public Response<UserInfoDTO> findOneUser(String userId){
		return userService.findOneUserById(userId);
	}

	/**
	 * 更新一个用户信息
	 * @param userInfoDTO
	 * @return
	 */
	@RequestMapping(path = "/updateUser",method = RequestMethod.POST)
	@ResponseBody
	public Response<String> updateUser(UserInfoDTO userInfoDTO){
		userInfoDTO.setUpdateDate(new Date());
		userInfoDTO.setUpdateBy(findCurrentUser().getUserId());
		if(null!=userInfoDTO.getPassword()){
            userInfoDTO.setPassword(MD5Util.MD5(userInfoDTO.getPassword()));
        }
		return userService.updateUser(userInfoDTO);
	}

	/**
	 * 新增一个用户信息
	 * @param userInfoDTO
	 * @return
	 */
	@RequestMapping(path = "/addUser",method = RequestMethod.POST)
	@ResponseBody
	public Response<String> addUser(UserInfoDTO userInfoDTO){
		userInfoDTO.setUpdateDate(new Date());
		userInfoDTO.setUpdateBy(findCurrentUser().getUserId());
		userInfoDTO.setUpdateDate(new Date());
		userInfoDTO.setUpdateBy(findCurrentUser().getUserId());
		userInfoDTO.setStatus(String.valueOf(ObjectEnum.effective.getStatus()));
		userInfoDTO.setPassword(MD5Util.MD5(userInfoDTO.getPassword()));
		return userService.saveUser(userInfoDTO);
	}

    /**
     * 检查用户名是否存在
     * @param userInfoDTO
     * @return
     */
    @RequestMapping(path = "/checkUserNameExists",method = RequestMethod.GET)
    @ResponseBody
    public Response<String> checkAreaExists(UserInfoDTO userInfoDTO){
        userInfoDTO.setStatus(String.valueOf(ObjectEnum.effective.getStatus()));
        return userService.checkUserNameExists(userInfoDTO);
    }

}
