package com.bst.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.UserDao;
import com.bst.entity.User;
import com.bst.util.EncoderByMd5;

/**
 * 用户管理
 * @author fumingqi
 * 2017年7月28日
 */
@Controller
@RequestMapping("admin/user")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping(value = "/updateView")
	public ModelAndView updateView(@RequestParam(defaultValue="0") long id){
		ModelAndView modelAndView=new ModelAndView();
		User user=userDao.SelectID(id);
		if (user != null) {
			modelAndView.addObject("user", user);
			modelAndView.setViewName("admin/user_edit");
		} else {
			modelAndView.setViewName("redirect:/admin/user/selectAll.html");
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/updatepass")
	public void updatepass(HttpServletResponse response,
			@RequestParam(defaultValue = "") long id, @RequestParam(defaultValue = "") String password,HttpSession session) {
		try {
			List<Criterion> criterions = new ArrayList<>();
			criterions.add(Restrictions.eq("userID", id));
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			User user = userDao.SelectUID(criterions);
			if (user == null) {
				response.getWriter().print("{\"a\":\"0\"}");// 账户或者密码错误
			} else {
				user.setPassword(EncoderByMd5.EncoderMd5(password));
				int i = userDao.Update(user);
				session.setAttribute("user", user);
				if (i != 0) {
					response.getWriter().print("{\"a\":\"1\"}");
				} else {
					response.getWriter().print("{\"a\":\"2\"}");
				}
			}
		
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="/selectAll")
	public ModelAndView select(){
		ModelAndView modelAndView=new ModelAndView("admin/user_list");
		modelAndView.addObject("userlist", 	userDao.selectlist());
		return modelAndView;
	}
	
	@RequestMapping(value = "/selectTitle")
	public ModelAndView selectTitle(@RequestParam(defaultValue = "") String title,@RequestParam(defaultValue = "1") int pageNow) {

		ModelAndView modelAndView = new ModelAndView("admin/user_list");
		List<Criterion> criterion = new ArrayList<>();
		criterion.add(Restrictions.like("account", "%" + title + "%"));
		modelAndView.addObject("userlist", userDao.SelectPAGE(criterion, pageNow));
		long rowCount = userDao.getCountPAGE(criterion);
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
		modelAndView.addObject("title", title);
		return modelAndView;
	}
}
