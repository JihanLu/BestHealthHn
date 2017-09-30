package com.bst.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.IntroDao;
import com.bst.entity.Intro;

/**
 * 研究院简介
 * 
 * @author fumingqi 2017年7月26日
 */
@Controller
@RequestMapping("admin/intro")
public class IntroController {
	@Autowired
	private IntroDao introDao;

	@RequestMapping(value = "/intros")
	public ModelAndView intro(@RequestParam(defaultValue = "0") long id, String content,
			@RequestParam(defaultValue = "") String mark) {
		ModelAndView modelAndView = new ModelAndView();
		if (!mark.equals("")) {
			//  0研究院 1领导人简介、2组织机构、3宗旨与行动准则、4领导致辞

			Intro intro = introDao.SelectID(id);
			if (intro != null) {// 修改
				intro.setContent(content);
				int i = introDao.Update(intro);
				if (i != 0) {
					modelAndView.setViewName("redirect:/admin/intro/selectAll.html?mark="+mark+"");
				} else {
					modelAndView.addObject("message", "研究院更新失败");
					modelAndView.setViewName("admin/fail");
				}
			} else {

				Intro intro1 = new Intro();
				intro1.setContent(content);
				intro1.setTime(new Date());
				intro1.setMark(mark);
				int i = introDao.Insert(intro1);
				if (i != 0) {
					modelAndView.setViewName("redirect:/admin/intro/selectAll.html?mark="+mark+"");
				} else {
					modelAndView.addObject("message", "研究院添加失败");
					modelAndView.setViewName("admin/fail");
				}
			}
		}else{
			modelAndView.addObject("message", "操作失败");
			modelAndView.setViewName("admin/fail");
		}
		return modelAndView;
	}

	@RequestMapping(value = "selectAll")
	public ModelAndView selectAll(String mark) {
		ModelAndView modelAndView = new ModelAndView("admin/intro");
		List<Criterion> criterion=new ArrayList<>();
		criterion.add(Restrictions.eq("mark", mark));
		List<Intro> list_intro=introDao.SelectAll(criterion);
		if(list_intro!=null){
			if(list_intro.size()>0){
				modelAndView.addObject("intro",list_intro.get(0));
			}
		}
		if(mark.equals("0")){
			modelAndView.addObject("title", "研究院简介");
		}else if(mark.equals("1")){
			modelAndView.addObject("title", "领导人简介");
		}else if(mark.equals("2")){
			modelAndView.addObject("title", "组织机构");
		}else if(mark.equals("3")){
			modelAndView.addObject("title", "宗旨与行动准则");
		}else if(mark.equals("4")){
			modelAndView.addObject("title", "领导致辞");
		}
		modelAndView.addObject("mark", mark);
		return modelAndView;
	}
}
