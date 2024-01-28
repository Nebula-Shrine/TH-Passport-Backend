package com.nebulashrine.thpassport.controller;

import com.nebulashrine.thpassport.common.response.Result;
import com.nebulashrine.thpassport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/user/checkUserPhone")
	@ResponseBody
	public Result checkUserPhone(String phone) {
		boolean userExistsByPhone = this.userService.isUserExistsByPhone(phone);
		if (userExistsByPhone) {
			return Result.succeed(null, "1");
		}
		return Result.succeed(null, "0");
	}
	
	@PostMapping("/user/checkUsername")
	@ResponseBody
	public Result checkUsername(String username) {
		boolean userExistsByUsername = this.userService.isUserExistsByUsername(username);
		if(userExistsByUsername){
			return Result.succeed(null, "1");
		}
		return Result.succeed(null, "0");
	}
	
//	@PostMapping("/user/register")
//	@ResponseBody
//	public Result register(String username, String password, String phone) {
//
//	}
}
