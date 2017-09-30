package com.bst.admin.controller;

import java.util.ArrayList;
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
import com.bst.dao.TopicDao;
import com.bst.dao.UserDao;
import com.bst.entity.Topic;
import com.bst.entity.User;

@Controller
@RequestMapping("admin/topic")
public class TopicController {
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/delectAll")
	public void delectAll(@RequestParam(defaultValue = "") String items, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			String[] item = items.split(",");
			for (int i = 0; i < item.length; i++) {
				Topic topic = topicDao.SelectID(Long.valueOf(item[i]));
				if (topic != null) {
					topicDao.Delete(topic);
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
				Topic topic = topicDao.SelectID(id);
				if (topic != null) {
					int i = topicDao.Delete(topic);
					if (i != 0) {

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/selectTitle")
	public ModelAndView selectTitle(@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "1") Integer pageNow) {

		ModelAndView modelAndView = new ModelAndView("admin/luntan/luntan_list");
		List<Criterion> criterion = new ArrayList<>();
		criterion.add(Restrictions.eq("account", title));
		User user1 = userDao.SelectUID(criterion);
		criterion.clear();
		if (user1 != null) {
			criterion.add(Restrictions.eq("topicUserID", user1.getUserID()));// 获取查找用户id做条件

		} else {
			criterion.add(Restrictions.eq("topicUserID", Long.valueOf(0)));// 获取查找用户id做条件

		}
		List<Topic> listTopic = topicDao.SelectPAGE(criterion, pageNow);
		List<User> userlist = new ArrayList<>();
		for (Topic topic : listTopic) {
			User user = userDao.SelectID(topic.getTopicUserID());
			userlist.add(user);
		}
		modelAndView.addObject("list", listTopic);
		modelAndView.addObject("userlist", userlist);
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = topicDao.getCountPAGE(criterion);
		criterion.clear();
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
		modelAndView.addObject("title", title);
		return modelAndView;
	}

	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam(defaultValue = "1") int pageNow,
			@RequestParam(defaultValue = "") String title) {
		ModelAndView modelAndView = new ModelAndView("admin/luntan/luntan_list");
		List<Criterion> criterion = new ArrayList<>();
		if (!title.equals("")) {
			criterion.add(Restrictions.eq("account", title));
			User user1 = userDao.SelectUID(criterion);
			criterion.clear();
			if (user1 != null) {
				criterion.add(Restrictions.eq("topicUserID", user1.getUserID()));
			}else {
				criterion.add(Restrictions.eq("topicUserID", Long.valueOf(0)));
			}
		} 
		List<Topic> listTopic = topicDao.SelectPAGE(criterion, pageNow);
		List<User> userlist = new ArrayList<>();
		for (Topic topic : listTopic) {
			User user = userDao.SelectID(topic.getTopicUserID());
			userlist.add(user);
		}
		modelAndView.addObject("list", listTopic);
		modelAndView.addObject("userlist", userlist);
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = topicDao.getCountPAGE(criterion);
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
		modelAndView.addObject("title", title);
		return modelAndView;
	}

}
