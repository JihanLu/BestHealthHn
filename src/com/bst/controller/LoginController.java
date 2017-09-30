package com.bst.controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

import com.bst.dao.UserDao;
import com.bst.entity.User;
import com.bst.util.EncoderByMd5;
import com.bst.util.SessionUtil;

import sun.misc.BASE64Decoder;

@Controller
@RequestMapping("user/indes")
public class LoginController {
public LoginController() {
	System.out.println("LoginController.LoginController()");
}
	@RequestMapping(value = "/Exit")
	public ModelAndView ExitLogin(HttpSession session){
		ModelAndView mav=new ModelAndView();
		session.removeAttribute("user");
		mav.setViewName("redirect:/user/index/home.html");
		return mav;
	}
	
	@RequestMapping(value = "/Exit1")
	public ModelAndView ExitLogin1(HttpSession session){
		ModelAndView mav=new ModelAndView();
		session.removeAttribute("user");
		mav.setViewName("redirect:/user/luntan/selectTopic.html");
		return mav;
	}
	
	
	public  boolean GenerateImage(String imgStr,HttpServletRequest request,String myFileName) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片C:\Users\Element\Desktop\1
			//String imgFilePath = "C:/Users/Element/Desktop/1.jpg";// 新生成的图片
			// 上传文件的到服务器的地址
			String filepath = request.getServletContext().getRealPath("/picture/" + myFileName);
			OutputStream out = new FileOutputStream(filepath);
			out.write(b);			
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public  String getUUID() {
		return UUID.randomUUID().toString();// 当前时间
	}
	@RequestMapping(value="/updateTopPhoto")
	public void getUpdateTopPhoto(User user,HttpServletResponse response,HttpServletRequest request,HttpSession session){
		try{
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			
			if(user.getUserID()==0){
				response.getWriter().print("{\"a\":\"0\"}");
			}else{
				if(user.getHeadPhoto()==null){
					response.getWriter().print("{\"a\":\"0\"}");
				}else{
					String imgStr=user.getHeadPhoto().substring(22);
					String myFileName=getUUID()+".jpg";
					GenerateImage(imgStr, request, myFileName);
					User users=userDao.SelectID(user.getUserID());
					users.setHeadPhoto(myFileName);
					userDao.Update(users);
					session.setAttribute("user", users);
					response.getWriter().print("{\"a\":\"1\",\"myFileName\":\""+myFileName+"\"}");
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/look")
	public ModelAndView look(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) SessionUtil.getSession(request);
		if (user != null) {
			modelAndView.addObject("user", user);
			modelAndView.setViewName("user/info");
		} else {
			modelAndView.addObject("mess", "请登录");
			modelAndView.setViewName("user/forum");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/updatepass")
	public void updatepass(HttpServletResponse response, @RequestParam(defaultValue = "") String account,
			@RequestParam(defaultValue = "") String phone, @RequestParam(defaultValue = "") String password,HttpSession session) {
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			List<Criterion> criterions = new ArrayList<>();
			criterions.add(Restrictions.eq("account", account));
			criterions.add(Restrictions.eq("phone", phone));
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

	@RequestMapping(value = "/forget")
	public ModelAndView forget() {
		ModelAndView modelAndView = new ModelAndView("user/forge_Pass");
		return modelAndView;
	}

	@RequestMapping(value = "update")
	public void update(HttpServletResponse response, @RequestParam(defaultValue = "0") long id,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String password,HttpSession session) {
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			if (id != 0) {
				List<Criterion> criterions=new ArrayList<>();
				criterions.add(Restrictions.eq("name", name));
				List<User> list_User=userDao.SelectAll(criterions);
				if(list_User.size()==0){
					User user = userDao.SelectID(id);
					if (user != null) {
						user.setName(name);
						user.setPhone(phone);
						if(!user.getPassword().equals(password)){
							user.setPassword(EncoderByMd5.EncoderMd5(password));
						}
						int i = userDao.Update(user);
						session.setAttribute("user", user);
						if (i != 0) {
							response.getWriter().print("{\"i\":\"1\"}");
						} else {
							response.getWriter().print("{\"i\":\"0\"}");
						}
					} else {
						response.getWriter().print("{\"i\":\"2\"}");
					}
				}else if(list_User.size()==1){
					User user = userDao.SelectID(id);
					if(user!=null){
						if(!user.getName().equals(name)){
							response.getWriter().print("{\"i\":\"3\"}");
						}else{
							user.setName(name);
							user.setPhone(phone);
							if(!user.getPassword().equals(password)){
								user.setPassword(EncoderByMd5.EncoderMd5(password));
							}
							int i = userDao.Update(user);
							session.setAttribute("user", user);
							if (i != 0) {
								response.getWriter().print("{\"i\":\"1\"}");
							} else {
								response.getWriter().print("{\"i\":\"0\"}");
							}
						}
					}else{
						response.getWriter().print("{\"i\":\"0\"}");
					}
				}else if(list_User.size()>=2){
					response.getWriter().print("{\"i\":\"3\"}");
				}else{
					response.getWriter().print("{\"i\":\"0\"}");
				}
			} else {
				response.getWriter().print("{\"i\":\"0\"}");
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "login")
	public String getlogin(User user, HttpSession session) throws Exception {
		String setJson = null;
		if (user != null) {
			if (user.getAccount() != null) {
				List<Criterion> criterions = new ArrayList<>();
				criterions.add(Restrictions.eq("account", user.getAccount()));
				User users = userDao.SelectUID(criterions);
				if (users != null) {
					if (users.getPassword().equals(EncoderByMd5.EncoderMd5(user.getPassword()))) {
						session.setAttribute("user", users);
						//System.out.println(users);
						setJson = "7";
					} else {
						setJson = "6"; // 密码错误
					}
				} else {
					setJson = "5"; // 用户名不存在
				}
			} else {
				setJson = "4"; // 用户名为空
			}
		} else {
			setJson = "0"; // 用户为空
		}
		return setJson;
	}

	@ResponseBody
	@RequestMapping(value = "add")
	public String getadd(User user, HttpSession session) throws Exception {
		String setJson = null;
		if (user == null) {
			setJson = "0";
		} else {
			if (user.getAccount() != null) {
				List<Criterion> criterions = new ArrayList<>();
				criterions.add(Restrictions.eq("account", user.getAccount()));
				User userl = userDao.SelectUID(criterions);
				if (userl == null) {
					User users=new User();
					users.setAccount(user.getAccount());
					users.setHeadPhoto("moren.png");
					users.setPassword(EncoderByMd5.EncoderMd5(user.getPassword()));
					users.setPhone(user.getPhone());
					String uuid  =  UUID.randomUUID().toString();
					users.setName("bst"+uuid.substring(0,7));
					users.setSex("nan");
					users.setTime(new Date());
					long i=userDao.Insert(users);
					if(i!=0){
						session.setAttribute("user", users);
						setJson = "8";
					} else {
						setJson = "2";
					}
				} else {
					setJson = "1";
				}
			} else {
				setJson = "0";
			}
		}
		return setJson;
	}

	@Autowired
	private UserDao userDao;
}
