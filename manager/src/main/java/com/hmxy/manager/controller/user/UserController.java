package com.hmxy.manager.controller.user;

import org.springframework.stereotype.Controller;

import com.hmxy.dto.UserInfoDTO;
import com.hmxy.http.HttpStatusEnum;
import com.hmxy.http.Response;
import com.hmxy.manager.controller.BaseController;

/**
 * 用户模块
 * 
 * @author youzi
 *
 */
@Controller
public class UserController extends BaseController {
	
	public Response<UserInfoDTO> list() {
		return new Response<UserInfoDTO>().setData(null).setMessage("查询成功")
				.setStatusCode(HttpStatusEnum.success.getCode());
	}
}
