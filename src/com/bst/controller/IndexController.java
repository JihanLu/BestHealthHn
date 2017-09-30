package com.bst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 钱端首页
 * 
 * @author fumingqi 2017年7月26日
 */
@Controller
@RequestMapping("user")
public class IndexController {
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("user/index");
		return modelAndView;
	}
}
