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
import com.bst.dao.NewsDao;
import com.bst.entity.Inform;
import com.bst.entity.News;

@Controller
@RequestMapping("user/news")
public class UserNewsController {
	@RequestMapping(value = "newss")
	public ModelAndView getindex(@RequestParam(defaultValue="1") Integer PAGENOW){
		ModelAndView mav=new ModelAndView("/user/news_arr");
		mav.addObject("news", newsDao.SelectPAGE(getCriterion(), PAGENOW));
		mav.addObject("inform", getInform(6));
		mav.addObject("currentPage", PAGENOW);
		mav.addObject("countPage", getNewsCount());
		return mav;
	}
	/*private List<News> getNews(Integer iNews){
		List<News> list_News=new ArrayList<>();
		List<News> list_Newss=newsDao.SelectAll(getCriterion());
		if(list_Newss!=null){
			if(list_Newss.size()>0){
				if(list_Newss.size()>=iNews){
					for(Integer i=0;i<iNews;i++){
						list_News.add(list_Newss.get(i));
					}
				}else {
					for(Integer i=0;i<list_Newss.size();i++){
						list_News.add(list_Newss.get(i));
					}
				}
			}else{
				list_News=null;
			}
		}else{
			list_News=null;
		}
		return list_News;
	}*/
	@RequestMapping(value = "newsID")
	public ModelAndView newsID(News news){
		ModelAndView mav=new ModelAndView("/user/details/news_details");
		if(news.getId()!=0){
			News newss=newsDao.SelectID(news.getId());
			newss.setClicks(newss.getClicks()+1);
			newsDao.Update(newss);
			mav.addObject("object", newss);
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
	private Integer getNewsCount() {
		Integer PAGECount = newsDao.getCountPAGE(getCriterion());//获取总页数
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
	private NewsDao newsDao;
	@Autowired
	private InformDao informDao;
}
