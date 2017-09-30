package com.bst.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.InformDao;
import com.bst.dao.IntroDao;
import com.bst.entity.Inform;
import com.bst.entity.Intro;

@Controller
@RequestMapping("user/intro")
public class UserIntroController {
/*	@RequestMapping(value = "intros")
	public ModelAndView getindex(){
		ModelAndView mav=new ModelAndView("/user/introduce");
		List<Criterion> criterion=new ArrayList<>();
		List<Intro> list_intro=introDao.SelectAll(criterion);
		if(list_intro!=null){
			if(list_intro.size()>0){
				mav.addObject("intro",list_intro.get(0));
			}
		}
		mav.addObject("inform",getInform(6));
		return mav;
	}*/
	
	@RequestMapping(value = "selectAll")
	public ModelAndView selectAll(@RequestParam(defaultValue="") String mark) {
		ModelAndView modelAndView = new ModelAndView("/user/introduce");
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
			modelAndView.addObject("mark", "1");
		}else if(mark.equals("1")){
			modelAndView.addObject("title", "领导人简介");
			modelAndView.addObject("mark", "2");
		}else if(mark.equals("2")){
			modelAndView.addObject("title", "组织机构");
			modelAndView.addObject("mark", "3");
		}else if(mark.equals("3")){
			modelAndView.addObject("title", "宗旨与行动准则");
			modelAndView.addObject("mark", "4");
		}else if(mark.equals("4")){
			modelAndView.addObject("title", "领导致辞");
			modelAndView.addObject("mark", "5");
		}
		modelAndView.addObject("pageTitle", "研究院简介");
		modelAndView.addObject("mark", mark);
		modelAndView.addObject("inform",getInform(6));
		return modelAndView;
	}
	
	private List<Inform> getInform(Integer iInform){
		List<Inform> list_Inform=new ArrayList<>();
		List<Inform> list_Informs=informDao.SelectAll(getCriterion());
		if(list_Informs!=null){
			if(list_Informs.size()>0){
				if(list_Informs.size()>=iInform){
					for(Integer i=0;i<iInform;i++){
						list_Inform.add(list_Informs.get(i));
					}
				}else {
					for(Integer i=0;i<list_Informs.size();i++){
						list_Inform.add(list_Informs.get(i));
					}
				}
			}else{
				list_Inform=null;
			}
		}else{
			list_Inform=null;
		}
		return list_Inform;
	}
	private  List<Criterion> getCriterion(){
		List<Criterion> criterion=new ArrayList<>();
		return criterion;
	}
	@Autowired
	private IntroDao introDao;
	@Autowired
	private InformDao informDao;
}
