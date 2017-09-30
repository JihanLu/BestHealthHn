package com.bst.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.ActivityDao;
import com.bst.dao.InformDao;
import com.bst.entity.Activity;
import com.bst.entity.Inform;

@Controller
@RequestMapping("user/activity")
public class UserActivityController {
	@RequestMapping(value = "activitys")
	public ModelAndView getindex(@RequestParam(defaultValue="1") Integer PAGENOW){
		ModelAndView mav=new ModelAndView("/user/activity_arr");
		mav.addObject("activity", activityDao.SelectPAGE(getCriterion(), PAGENOW));
		mav.addObject("inform", getInform(6));
		mav.addObject("currentPage", PAGENOW);
		mav.addObject("countPage", getActivityCount());
		return mav;
	}
	/*private List<Activity> getActivity(Integer iActivity){
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
	}*/
	@RequestMapping(value = "activityID")
	public ModelAndView activityID(Activity activity){
		ModelAndView mav=new ModelAndView("/user/details/activity_details");
		if(activity.getId()!=0){
			Activity activitys=activityDao.SelectID(activity.getId());
			mav.addObject("object", activitys);
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
	private Integer getActivityCount() {
		Integer PAGECount = activityDao.getCountPAGE(getCriterion());//获取总页数
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
	private ActivityDao activityDao;
	@Autowired
	private InformDao informDao;
}
