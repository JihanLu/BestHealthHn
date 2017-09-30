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

import com.bst.dao.ReplyTowDao;
import com.bst.dao.UserDao;
import com.bst.entity.ReplyTow;
import com.bst.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("admin/replyTow")
public class ReplyTowController {
	@Autowired
	private ReplyTowDao replyTowDao;
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
				ReplyTow replyTow = replyTowDao.SelectID(Long.valueOf(item[i]));
				if (replyTow != null) {
					replyTowDao.Delete(replyTow);
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
				ReplyTow replyTow = replyTowDao.SelectID(id);
				if (replyTow != null) {
					int i = replyTowDao.Delete(replyTow);
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
			@RequestParam(defaultValue = "1") int pageNow) {

		ModelAndView modelAndView = new ModelAndView("admin/luntan/luntan_list3");
		List<Criterion> criterion = new ArrayList<>();
		criterion.add(Restrictions.eq("account", title));

		User user1 = userDao.SelectUID(criterion);
		criterion.clear();
		if (user1 != null) {
			criterion.add(Restrictions.eq("huifuID", user1.getUserID()));// 获取查找用户id做条件

		} else {
			criterion.add(Restrictions.eq("huifuID", Long.valueOf(0)));// 获取查找用户id做条件

		}

		List<ReplyTow> listrReplyTow = replyTowDao.SelectPAGE(criterion, pageNow);

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		for (ReplyTow replyTow : listrReplyTow) {
			User user = userDao.SelectID(replyTow.getHuifuID());//// 评论者
			jsonObject.element("replyTowID", replyTow.getReplyTowID());
			jsonObject.element("huifu", user.getAccount());// 评论者
			jsonObject.element("huifuc", replyTow.getContent());
			jsonObject.element("time", replyTow.getReplyTime().toString().substring(0, 19));
			jsonArray.add(jsonObject);
		}
		modelAndView.addObject("list", jsonArray);
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = replyTowDao.getCountPAGE(criterion);
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

	@RequestMapping(value = "/list2")
	public ModelAndView list2(@RequestParam(defaultValue = "1") int pageNow, @RequestParam(defaultValue = "0") long id,
			@RequestParam(defaultValue = "") String title) {
		// 通过帖子id查询所有的评论回复
		ModelAndView modelAndView = new ModelAndView("admin/luntan/luntan_list3");
		List<Criterion> criterion = new ArrayList<>();
		if (id != 0) {
			criterion.add(Restrictions.eq("replyOneID", id));
		}
		if (!title.equals("")) {
			criterion.add(Restrictions.eq("account", title));
			User user1 = userDao.SelectUID(criterion);
			criterion.clear();
			if (user1 != null) {
				criterion.add(Restrictions.eq("topicUserID", user1.getUserID()));
			} else {
				criterion.add(Restrictions.eq("topicUserID", Long.valueOf(0)));
			}
		}
		List<ReplyTow> listrReplyTow = replyTowDao.SelectPAGE(criterion, pageNow);

		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		for (ReplyTow replyTow : listrReplyTow) {
			User user = userDao.SelectID(replyTow.getHuifuID());//// 评论者
			jsonObject.element("replyTowID", replyTow.getReplyTowID());
			jsonObject.element("huifu", user.getAccount());// 评论者
			jsonObject.element("huifuc", replyTow.getContent());
			jsonObject.element("time", replyTow.getReplyTime().toString().substring(0, 19));
			jsonArray.add(jsonObject);
		}
		
		modelAndView.addObject("list", jsonArray);
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = replyTowDao.getCountPAGE(criterion);
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
}
