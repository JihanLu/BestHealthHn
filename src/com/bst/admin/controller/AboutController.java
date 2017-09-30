package com.bst.admin.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.AboutDao;
import com.bst.entity.About;

/**
 * 关于我们
 * 
 * @author fumingqi 2017年7月26日
 */
/*@Scope(value="prototype")*/
@Controller
@RequestMapping("admin/about")
public class AboutController {
	@Autowired
	private AboutDao aboutDao;
	@RequestMapping(value = "/abouts")
	public ModelAndView About(@RequestParam(defaultValue="0") long id,String content) {
		ModelAndView modelAndView = new ModelAndView();
		About about = aboutDao.SelectID(id);
		if (about != null) {// 修改
			about.setContent(content);
			int i = aboutDao.Update(about);
			if (i != 0) {
				modelAndView.setViewName("redirect:/admin/about/selectAll.html");
			} else {
				modelAndView.addObject("message", "关于我们更新失败");
				modelAndView.setViewName("admin/fail");
			}
		} else {
		
			About about1 =new About();
			about1.setContent(content);
			about1.setTime(new Date());
			int i = aboutDao.Insert(about1);
			if (i != 0) {
				modelAndView.setViewName("redirect:/admin/about/selectAll.html");
			} else {
				modelAndView.addObject("message", "关于我们添加失败");
				modelAndView.setViewName("admin/fail");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/selectAll")
	public ModelAndView selectAll() {
		
		ModelAndView modelAndView = new ModelAndView("admin/about");
		About about = aboutDao.SelectAbout();
		modelAndView.addObject("about", about);
		return modelAndView;
	}
}
