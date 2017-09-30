package com.bst.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.ActivityDao;
import com.bst.entity.Activity;
import com.bst.entity.Admin;
import com.bst.util.SessionUtil;
import com.bst.util.ThumbnailsOf;

/**
 * 
 * @author fumingqi 2017年7月24日 活动安排
 */
@Controller
@RequestMapping("admin/activity")
public class ActivityController {
	@Autowired
	private ActivityDao activityDao;

	@RequestMapping(value = "/insertjsp")
	public ModelAndView insertjsp() {
		return new ModelAndView("admin/activity/activity_add");
	}

	@RequestMapping(value = "/selectTitle")
	public ModelAndView selectTitle(@RequestParam(defaultValue = "") String title,@RequestParam(defaultValue = "1") int pageNow) {

		ModelAndView modelAndView = new ModelAndView("admin/activity/activity_list");
		List<Criterion> criterion = new ArrayList<>();
		criterion.add(Restrictions.like("title", "%" + title + "%"));
		modelAndView.addObject("actitylist", activityDao.SelectPAGE(criterion, pageNow));
		long rowCount = activityDao.getCountPAGE(criterion);
		if (rowCount != 0) {
			int totalPage = (int) (rowCount / 10);// 共有几页
			if (rowCount % 10 > 0) {
				totalPage = (int) (rowCount / 10 + 1);
			}
			if (totalPage == 0) {
				totalPage = 1;
			}
			modelAndView.addObject("totalPage", totalPage);
		}
		modelAndView.addObject("pageNow", pageNow);
		modelAndView.addObject("title", title);
		return modelAndView;
	}

	@RequestMapping(value = "/insert")
	public ModelAndView insert(Activity activity,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		activity.setTime(new Date());
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			activity.setAuthor(admin.getAdminsName());
		}else{
			activity.setAuthor("admin");
		}
		int i = activityDao.Insert(activity);
		if (i != 0) {
			modelAndView.setViewName("redirect:/admin/activity/selectAll.html");
		} else {
			modelAndView.addObject("message", "活动添加失败");
			modelAndView.setViewName("admin/fail");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/selectAll")
	public ModelAndView selectAll(@RequestParam(defaultValue = "1") int pageNow) {
		ModelAndView modelAndView = new ModelAndView("admin/activity/activity_list");
		
		List<Criterion> criterion = new ArrayList<>();
		modelAndView.addObject("actitylist", activityDao.SelectPAGE(criterion, pageNow));
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = activityDao.getCountPAGE(criterion);
		if (rowCount != 0) {
			int totalPage = (int) (rowCount / 10);// 共有几页
			if (rowCount % 10 > 0) {
				totalPage = (int) (rowCount / 10 + 1);
			}
			if (totalPage == 0) {
				totalPage = 1;
			}
			modelAndView.addObject("totalPage", totalPage);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/select")
	public ModelAndView select(@RequestParam(defaultValue = "0") long id) {
		ModelAndView modelAndView = new ModelAndView("admin/activity/activity_edit");
		Activity activity = activityDao.SelectID(id);
		modelAndView.addObject("activity", activity);
		return modelAndView;
	}

	@RequestMapping(value = "/delectAll")
	public void delectAll(@RequestParam(defaultValue = "") String items, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			String[] item = items.split(",");
			for (int i = 0; i < item.length; i++) {
				Activity activity = activityDao.SelectID(Long.valueOf(item[i]));
				if (activity != null) {
					List<String> listimg = ThumbnailsOf.getImageSrc(activity.getContent());
					int a = activityDao.Delete(activity.getId());
					if (a != 0) {
						for (int b = 0; b < listimg.size(); b++) {
							ThumbnailsOf.deleteFile(request, listimg.get(b));
						}
					} 
				}
			}
			response.getWriter().print("{\"delpall\":\"1\"}");
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/delect")
	public void delect(@RequestParam(defaultValue = "0") long id, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			if (id != 0) {
				Activity activity = activityDao.SelectID(id);
				if (activity != null) {
					List<String> listimg = ThumbnailsOf.getImageSrc(activity.getContent());
					
					int i = activityDao.Delete(id);
					if (i != 0) {
						for (int a = 0; a < listimg.size(); a++) {
							//删除服务器对应的文件
							ThumbnailsOf.deleteFile(request, listimg.get(a));
						}
						response.getWriter().print("{\"del\":\"0\"}");
					} else {
						response.getWriter().print("{\"del\":\"1\"}");
					}
				} else {
					response.getWriter().print("{\"del\":\"2\"}");
				}

			} else {
				response.getWriter().print("{\"del\":\"2\"}");
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/updateView")
	public ModelAndView updateView(@RequestParam(defaultValue = "0") int id) {
		ModelAndView modelAndView = new ModelAndView("admin/activity/activity_edit");
		Activity activity = activityDao.SelectID(id);
		modelAndView.addObject("activity", activity);
		return modelAndView;
	}

	@RequestMapping(value = "/update")
	public ModelAndView update(Activity a,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/fail");
		Activity activity = activityDao.SelectID(a.getId());
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			activity.setAuthor(admin.getAdminsName());
		}
		if (activity != null) {
			activity.setTitle(a.getTitle());
			activity.setContent(a.getContent());
			activity.setSources(a.getSources());
			int i = activityDao.Update(activity);
			if (i != 0) {
				modelAndView.setViewName("redirect:/admin/activity/selectAll.html");
			} else {
				modelAndView.addObject("message", "活动修改失败");
			}
		} else {
			modelAndView.addObject("message", "活动修改失败");
		}
		return modelAndView;
	}
}
