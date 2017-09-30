package com.bst.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.AdminDao;
import com.bst.entity.Admin;
import com.bst.util.EncoderByMd5;

@Controller
@RequestMapping("admin/admin")
public class AdminController {
	@Autowired
	private AdminDao adminDao;
	
	
	@RequestMapping(value="/loginout")
	public ModelAndView loginout(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView("admin/login");
		request.getSession().removeAttribute("adminSession");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/insertjsp")
	public ModelAndView insertjsp() {
		return new ModelAndView("admin/admin/admin_add");
	}
	
	
	@RequestMapping(value="/loginjsp")
	public ModelAndView loginjsp(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("admin/login");
		return modelAndView;
	}
	
	@RequestMapping(value="/login")
	public void login(HttpSession session,String userName, String password, HttpServletRequest request, HttpServletResponse response){
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			List<Criterion> criterions=new ArrayList<>();
			criterions.add(Restrictions.eq("adminsName", userName));
			Admin admin=adminDao.SelectUID(criterions);
			if(admin!=null){
				if(EncoderByMd5.EncoderMd5(password).equals(admin.getPassword())){
					response.getWriter().print("{\"a\":\"0\"}");
					session.removeAttribute("user");
					session.setAttribute("adminSession", admin);
				}else{//密码不正确
					response.getWriter().print("{\"a\":\"1\"}");
				}
			}else{//用户名不存在
				response.getWriter().print("{\"a\":\"2\"}");
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/index")
	public ModelAndView index(){
		
		ModelAndView modelAndView = new ModelAndView("admin/index");
		return modelAndView;
	}
	// 管理员添加
	@ResponseBody
	@RequestMapping(value = "/insert")
	public String insert(Admin admin) throws Exception{
		String setJson=null;
		/*ModelAndView modelAndView = new ModelAndView();
		admin.setTime(new Date());
		admin.setPassword(EncoderByMd5.EncoderMd5(admin.getPassword()));
		int i = adminDao.Insert(admin);
		if (i != 0) {
			modelAndView.setViewName("redirect:/admin/admin/selectAll.html");
		} else {
			modelAndView.addObject("message", "管理员添加失败");
			modelAndView.setViewName("admin/fail");
		}
		return modelAndView;*/
		if(admin!=null){
			List<Criterion> criterion=new ArrayList<>();
			criterion.add(Restrictions.eq("adminsName", admin.getAdminsName()));
			List<Admin> list_Admin=adminDao.SelectAll(criterion);
			if(list_Admin.size()==0){
				admin.setTime(new Date());
				admin.setPassword(EncoderByMd5.EncoderMd5(admin.getPassword()));
				adminDao.Insert(admin);
				setJson="7";
			}else{
				setJson="5";//cunzai
			}
			
		}else{
			setJson="0";
		}
		return setJson;
	}

	@RequestMapping(value = "/selectTitle")
	public ModelAndView selectTitle(@RequestParam(defaultValue = "") String title) {

		ModelAndView modelAndView = new ModelAndView("admin/admin/admin_list");
		List<Criterion> criterion = new ArrayList<>();
		criterion.add(Restrictions.like("adminsName", "%" + title + "%"));
		modelAndView.addObject("adminlist", adminDao.SelectAll(criterion));
		modelAndView.addObject("title", title);
		return modelAndView;
	}
	
	@RequestMapping(value = "/selectAll")
	public ModelAndView select() {
		ModelAndView modelAndView = new ModelAndView("admin/admin/admin_list");
		modelAndView.addObject("adminlist", adminDao.selecilist());
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
				Admin admin = adminDao.SelectID(Long.valueOf(item[i]));
				if (admin != null) {
					adminDao.Delete(admin);
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
	public void delect(@RequestParam(defaultValue = "0") long id, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			Admin admin=adminDao.SelectID(id);
			if(admin!=null){
				int i=adminDao.Delete(admin);
				if(i!=0){
					response.getWriter().print("{\"del\":\"0\"}");
				}else{
					response.getWriter().print("{\"del\":\"1\"}");
				}
			}else{
				response.getWriter().print("{\"del\":\"1\"}");
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/updateView")
	public ModelAndView updateView(@RequestParam(defaultValue = "0") long id) {
		ModelAndView modelAndView = new ModelAndView("admin/admin/admin_edit");
		Admin admin=adminDao.SelectID(id);
		modelAndView.addObject("admin", admin);
		return modelAndView;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView update(Admin a) throws Exception {
		ModelAndView modelAndView = new ModelAndView("admin/fail");
		Admin admin = adminDao.SelectID(a.getAdminsID());
		if (admin != null) {
			if(!a.getPassword().equals(admin.getPassword())){
				admin.setPassword(EncoderByMd5.EncoderMd5(a.getPassword()));
			}
			admin.setPhone(a.getPhone());
		
			int i = adminDao.Update(admin);
			if (i != 0) {
				modelAndView.setViewName("redirect:/admin/admin/selectAll.html");
			} else {
				modelAndView.addObject("message", "管理员修改失败");
			}
		} else {
			modelAndView.addObject("message", "管理员修改失败");
		}
		return modelAndView;
	}
}
