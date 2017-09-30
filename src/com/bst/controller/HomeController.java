package com.bst.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.ActivityDao;
import com.bst.dao.InformDao;
import com.bst.dao.IntroDao;
import com.bst.dao.LiteratureDao;
import com.bst.dao.NewsDao;
import com.bst.dao.RecommendDao;
import com.bst.entity.Activity;
import com.bst.entity.Inform;
import com.bst.entity.Intro;
import com.bst.entity.Literature;
import com.bst.entity.News;
import com.bst.entity.Recommend;
/*@Scope(value="prototype")*/
@Controller
@RequestMapping("user/index")
public class HomeController {
	public HomeController() {
		System.out.println("HomeController.HomeController()");
	}
	@RequestMapping(value = "home")
	public ModelAndView getindex(){
		System.out.println(HomeController.this);
		ModelAndView mav=new ModelAndView("/user/index");
		mav.addObject("activity", getActivity(10));
		mav.addObject("intro", getIntro(5));
		mav.addObject("inform", getInform(5));
		mav.addObject("literature", getLiterature(10));
		mav.addObject("news", getNews(10));
		for (int i =1; i < 5; i++) {
			mav.addObject("news"+i, getNews1(i));
		}
		mav.addObject("recommend", getRecommend(3));
		return mav;
	}
	private List<Activity> getActivity(Integer iActivity){
		List<Activity> list_Activity=new ArrayList<>();
		List<Activity> list_Activitys=activityDao.SelectAll(getCriterion());
		if(list_Activitys!=null){
			if(list_Activitys.size()>0){
				if(list_Activitys.size()>=iActivity){
					for(Integer i=0;i<iActivity;i++){
						list_Activity.add(list_Activitys.get(i));
					}
				}else {
					for(Integer i=0;i<list_Activitys.size();i++){
						list_Activity.add(list_Activitys.get(i));
					}
				}
			}else{
				list_Activity=null;
			}
		}else{
			list_Activity=null;
		}
		return list_Activity;
	}
	private List<Intro> getIntro(Integer iIntro){
		List<Intro> list_Intro=new ArrayList<>();
		List<Intro> list_Intros=introDao.SelectAll(getCriterion());
		if(list_Intros!=null){
			if(list_Intros.size()>0){
				if(list_Intros.size()>=iIntro){
					for(Integer i=0;i<iIntro;i++){
						list_Intro.add(list_Intros.get(i));
					}
				}else {
					for(Integer i=0;i<list_Intros.size();i++){
						list_Intro.add(list_Intros.get(i));
					}
				}
			}else{
				list_Intro=null;
			}
		}else{
			list_Intro=null;
		}
		return list_Intro;
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
	private List<Literature> getLiterature(Integer iLiterature){
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
	}
	private List<News> getNews(Integer iNews){
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
	}
	private News getNews1(Integer iNews){
		News news1=new News();
		List<Criterion> criterions=new ArrayList<>();
		criterions.add(Restrictions.eq("topid", 1));
		criterions.add(Restrictions.ne("photo", ""));
		List<News> list_Newss=newsDao.SelectAll(criterions);
		if(list_Newss!=null){
			if(list_Newss.size()>0){
				if(list_Newss.size()>=iNews){
						news1=list_Newss.get(iNews-1);
				}
			}else{
				news1=null;
			}
		}else{
			news1=null;
		}
		return news1;
	}
	private List<Recommend> getRecommend(Integer iRecommend){
		List<Recommend> list_Recommend=new ArrayList<>();
		List<Criterion> criterions=new ArrayList<>();
		criterions.add(Restrictions.ne("photo", ""));
		List<Recommend> list_Recommends=recommendDao.SelectAll(criterions);
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
	}
	private  List<Criterion> getCriterion(){
		List<Criterion> criterion=new ArrayList<>();
		return criterion;
	}
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private IntroDao introDao;
	@Autowired
	private InformDao informDao;
	@Autowired
	private LiteratureDao literatureDao;
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private RecommendDao recommendDao;
}
