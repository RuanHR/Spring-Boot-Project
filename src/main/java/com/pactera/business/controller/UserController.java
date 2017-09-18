package com.pactera.business.controller;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.pactera.base.extension.mvc.ResponseWrapper;
import com.pactera.business.domain.User;
import com.pactera.business.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午6:09:11
	 * @title findById
	 * @description 根据用户id查询用户
	 * @return ResponseWrapper
	 */
	@GetMapping("findByName")
	@ResponseBody
	public ResponseWrapper findByName(String name, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {
		Assert.assertNotNull("名称不能为空", name);
		PageInfo<User> users = userService.findByName(name, page, size);
		return ResponseWrapper.success(users);
	}

}
