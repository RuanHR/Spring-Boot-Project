package com.pactera.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("view")
public class ViewResolverController {

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午9:45:08 
	 * @title view
	 * @description 转发到对应的JSP
	 * @return String
	 */
	@RequestMapping("{path}.html")
	public String view(@PathVariable String path) {
		return path;
	}
}
