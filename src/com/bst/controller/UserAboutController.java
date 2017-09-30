package com.bst.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.AboutDao;
import com.bst.dao.InformDao;
import com.bst.entity.About;
import com.bst.entity.Inform;


@Controller
@RequestMapping("user/about")
public class UserAboutController {
	/*@RequestMapping(value = "abouts")
	public ModelAndView getindex(){
		ModelAndView mav=new ModelAndView("/user/about");
		About about=aboutDao.SelectAbout();
		if(about!=null){
			mav.addObject("about",about);
		}
		mav.addObject("inform", getInform(6));
		return mav;
	}*/
	@RequestMapping(value = "abouts")
	public ModelAndView getindex(){
		ModelAndView mav=new ModelAndView("/user/about");
		List<Criterion> criterion=new ArrayList<>();
		List<About> list_About=aboutDao.SelectAll(criterion);
		if(list_About!=null){
			if(list_About.size()>0){
				mav.addObject("about",list_About.get(0));
			}
		}
		mav.addObject("inform",getInform(6));
		return mav;
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
	private AboutDao aboutDao;
	@Autowired
	private InformDao informDao;
}

