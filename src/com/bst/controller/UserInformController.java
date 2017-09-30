package com.bst.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.InformDao;
import com.bst.entity.Inform;
@Controller
@RequestMapping("user/inform")
public class UserInformController {
	@RequestMapping(value = "informs")
	public ModelAndView getindex(@RequestParam(defaultValue="1") Integer PAGENOW){
		ModelAndView mav=new ModelAndView("/user/no_Annou");
		mav.addObject("inform1", informDao.SelectPAGE(getCriterion(), PAGENOW));
		mav.addObject("inform", getInform(6));
		mav.addObject("currentPage", PAGENOW);
		mav.addObject("countPage", getInformCount());
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
	@RequestMapping(value = "informID")
	public ModelAndView informID(Inform inform){
		ModelAndView mav=new ModelAndView("/user/details/inform_details");
		if(inform.getId()!=0){
			Inform informs=informDao.SelectID(inform.getId());
			mav.addObject("object", informs);
			mav.addObject("inform", getInform(6));
		}
		return mav;
	}
	private Integer getInformCount() {
		Integer PAGECount = informDao.getCountPAGE(getCriterion());//获取总页数
		if (PAGECount % 10 == 0) {
			PAGECount = PAGECount / 10;
		} else {
			PAGECount = (PAGECount / 10) + 1;
		}
		return PAGECount; //分页处理
	}
	private  List<Criterion> getCriterion(){
		List<Criterion> criterion=new ArrayList<>();
		return criterion;
	}
	@Autowired
	private InformDao informDao;
}
