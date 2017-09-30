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
import com.bst.dao.LiteratureDao;
import com.bst.entity.Inform;
import com.bst.entity.Literature;

@Controller
@RequestMapping("user/literature")
public class UserLiteratureController {
	@RequestMapping(value = "literatures")
	public ModelAndView getindex(@RequestParam(defaultValue="1") Integer PAGENOW){
		ModelAndView mav=new ModelAndView("/user/literature_Pro");
		mav.addObject("literature", literatureDao.SelectPAGE(getCriterion(), PAGENOW));
		mav.addObject("inform", getInform(6));
		mav.addObject("currentPage", PAGENOW);
		mav.addObject("countPage", getLiteratureCount());
		return mav;
	}
	/*private List<Literature> getLiterature(Integer iLiterature){
		List<Literature> list_Literature=new ArrayList<>();
		List<Literature> list_Literatures=literatureDao.SelectAll(getCriterion());
		if(list_Literatures!=null){
			if(list_Literatures.size()>0){
				if(list_Literatures.size()>=iLiterature){
					for(Integer i=0;i<iLiterature;i++){
						list_Literature.add(list_Literatures.get(i));
					}
				}else {
					for(Integer i=0;i<list_Literatures.size();i++){
						list_Literature.add(list_Literatures.get(i));
					}
				}
			}else{
				list_Literature=null;
			}
		}else{
			list_Literature=null;
		}
		return list_Literature;
	}*/
	@RequestMapping(value = "literatureID")
	public ModelAndView literatureID(Literature literature){
		ModelAndView mav=new ModelAndView("/user/details/literature_details");
		if(literature.getId()!=0){
			Literature literatures=literatureDao.SelectID(literature.getId());
			mav.addObject("object", literatures);
			mav.addObject("inform", getInform(6));
		}
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
	private Integer getLiteratureCount() {
		Integer PAGECount = literatureDao.getCountPAGE(getCriterion());//获取总页数
		if (PAGECount % 16 == 0) {
			PAGECount = PAGECount / 16;
		} else {
			PAGECount = (PAGECount / 16) + 1;
		}
		return PAGECount; //分页处理
	}
	private  List<Criterion> getCriterion(){
		List<Criterion> criterion=new ArrayList<>();
		return criterion;
	}
	@Autowired
	private LiteratureDao literatureDao;
	@Autowired
	private InformDao informDao;
}
