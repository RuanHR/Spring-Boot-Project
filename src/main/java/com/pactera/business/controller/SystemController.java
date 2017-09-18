package com.pactera.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {

	/**
	 * @author ToniR
	 * @since 2017年9月18日 下午6:38:41
	 * @title login
	 * @description 登录
	 * @return String
	 */
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("name", "world");
		return "index";
	}

}
