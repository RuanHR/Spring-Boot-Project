package com.pactera.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("view")
@Api(tags = "视图解析器")
public class ViewResolverController {

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午9:45:08
	 * @title view
	 * @description 转发到对应的JSP
	 * @return String
	 */
	@GetMapping("{path}.html")
	@ApiOperation("映射页面")
	public String view(@ApiParam(name = "path", value = "页面名称") @PathVariable String path) {
		return path;
	}
}
