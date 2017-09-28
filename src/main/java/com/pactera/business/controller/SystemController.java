package com.pactera.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pactera.base.extension.mvc.ResponseWrapper;
import com.pactera.business.domain.City;
import com.pactera.business.domain.User;
import com.pactera.business.service.CityService;
import com.pactera.business.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/")
@Api(tags = "系统api")
public class SystemController {

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("cityServiceImpl")
	private CityService cityService;

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

	@GetMapping("testMuilDataSource")
	@ApiOperation("测试多数据源")
	public ResponseWrapper testMuilDataSource(
			@ApiParam(name = "name", value = "用户姓名", required = true) @RequestParam String name,
			@ApiParam(name = "page", value = "页面", required = false) @RequestParam(defaultValue = "1") Integer page,
			@ApiParam(name = "size", value = "页面个数", required = false) @RequestParam(defaultValue = "10") Integer size) {
		PageInfo<User> users = userService.findByName(name, page, size);
		City city = cityService.findByName(name);
		Object[] results = { users, city };
		return ResponseWrapper.success(results);
	}

}
