package com.pactera.business.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(tags = "系统api")
public class SystemController {

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午6:38:41
	 * @title login
	 * @description 登录
	 * @return String
	 */
	@GetMapping("login")
	@ApiOperation("用户登录")
	public String login(Model model) {
		model.addAttribute("name", "world");
		return "index";
	}

}
