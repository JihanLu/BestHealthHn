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
import com.bst.dao.RecommendDao;
import com.bst.entity.Inform;
import com.bst.entity.Recommend;

@Controller
@RequestMapping("user/recommend")
public class UserRecommendController {
	@RequestMapping(value = "recommends")
	public ModelAndView getindex(@RequestParam(defaultValue="1") Integer PAGENOW){
		ModelAndView mav=new ModelAndView("/user/pro_Pro");
		mav.addObject("recommend", recommendDao.SelectPAGE(getCriterion(), PAGENOW));
		mav.addObject("inform", getInform(6));
		mav.addObject("currentPage", PAGENOW);
		mav.addObject("countPage", getRecommendCount());
		return mav;
	}
	/*private List<Recommend> getRecommend(Integer iRecommend){
		List<Recommend> list_Recommend=new ArrayList<>();
		List<Recommend> list_Recommends=recommendDao.SelectAll(getCriterion());
		if(list_Recommends!=null){
			if(list_Recommends.size()>0){
				if(list_Recommends.size()>=iRecommend){
					for(Integer i=0;i<iRecommend;i++){
						list_Recommend.add(list_Recommends.get(i));
					}
				}else {
					for(Integer i=0;i<list_Recommends.size();i++){
						list_Recommend.add(list_Recommends.get(i));
					}
				}
			}else{
				list_Recommend=null;
			}
		}else{
			list_Recommend=null;
		}
		return list_Recommend;
	}*/
	@RequestMapping(value = "recommendID")
	public ModelAndView recommendID(Recommend recommend){
		ModelAndView mav=new ModelAndView("/user/details/recommend_details");
		if(recommend.getId()!=0){
			Recommend recommends=recommendDao.SelectID(recommend.getId());
			mav.addObject("object", recommends);
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
	private Integer getRecommendCount() {
		Integer PAGECount = recommendDao.getCountPAGE(getCriterion());//获取总页数
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
	private RecommendDao recommendDao;
	@Autowired
	private InformDao informDao;
}
