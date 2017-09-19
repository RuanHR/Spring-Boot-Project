package com.pactera.business.controller;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pactera.base.extension.mvc.ResponseWrapper;
import com.pactera.business.domain.User;
import com.pactera.business.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("user")
@Api(tags = "用户api")
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
	@ApiOperation("根据用户id查询用户")
	public ResponseWrapper findByName(
			@ApiParam(name = "name", value = "用户姓名", required = true) @RequestParam String name,
			@ApiParam(name = "page", value = "页面", required = false) @RequestParam(defaultValue = "1") Integer page,
			@ApiParam(name = "size", value = "页面个数", required = false) @RequestParam(defaultValue = "10") Integer size) {
		Assert.assertNotNull("名称不能为空", name);
		PageInfo<User> users = userService.findByName(name, page, size);
		return ResponseWrapper.success(users);

	}

}
