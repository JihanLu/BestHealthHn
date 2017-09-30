package com.bst.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.NewsDao;
import com.bst.dao.ReplyOneDao;
import com.bst.dao.ReplyTowDao;
import com.bst.dao.TopicDao;
import com.bst.dao.UserDao;
import com.bst.entity.News;
import com.bst.entity.ReplyOne;
import com.bst.entity.ReplyTow;
import com.bst.entity.Topic;
import com.bst.entity.User;
import com.bst.util.EncoderByMd5;
import com.bst.util.ModelParam;
import com.bst.util.SessionUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("user/phone")
public class PhoneController {
	@Autowired
	private ReplyOneDao replyOneDao;
	@Autowired
	private ReplyTowDao replyTowDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private TopicDao topicDao;
	
	
	@RequestMapping(value = "/insert2")
	public void insert2(ModelParam modelParam, HttpServletResponse response, HttpServletRequest request) {
		try {// 当前添加的内容是发帖人回复
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			User user = (User) SessionUtil.getSession(request);
			if (user != null) {
				// 获取要被回复的id，回复的id为当前登录的id
				ReplyTow replyTow = new ReplyTow();
				Date date=new Date();
				replyTow.setReplyTime(date);// 设置时间
				replyTow.setContent(modelParam.getContent());// 设置回复内容
				replyTow.setTopicID(modelParam.getTopicID());// 设置帖子的id
				replyTow.setHuifuID(user.getUserID());// 发帖人回复的回复者
				replyTow.setBeihuifuID(modelParam.getBeihuiID());// 评论者的id被恢复着
				replyTow.setReplyOneID(modelParam.getRepltOneID());// 一级回复id
				long i = replyTowDao.Insert(replyTow);
				if (i != 0) {
					JSONObject jsonObject=new JSONObject();
					User user1=userDao.SelectID(modelParam.getBeihuiID());
					if (user.getName().equals("") || user.getName() == null) {// 昵称为空时候使用账号
						jsonObject.element("treplyName", user.getAccount());// 发帖人的账号
					} else {
						jsonObject.element("treplyName", user.getName());// 发帖人的昵称
					}
					if (user1.getName().equals("") || user1.getName() == null) {// 昵称为空时候使用账号
						jsonObject.element("treplyName1", user1.getAccount());// 发帖人的账号
					} else {
						jsonObject.element("treplyName1", user1.getName());// 发帖人的昵称
					}
					jsonObject.element("treplyUserPhoto", user.getHeadPhoto());
					jsonObject.element("treplyContent", modelParam.getContent());
					SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					jsonObject.element("treplyTime", sfd.format(date));
					jsonObject.element("thuifuID", user.getUserID());
					jsonObject.element("tbeihuifuID", modelParam.getBeihuiID());
					response.getWriter().print("{\"i\":\"2\",\"list\":"+jsonObject+"}");
				} else {
					response.getWriter().print("{\"i\":\"1\"}");// 恢复失败
				}
			} else {
				response.getWriter().print("{\"i\":\"0\"}");// 登录去
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/insert1")
	public void insert1(ModelParam modelParam, HttpServletResponse response, HttpServletRequest request) {
		try {// 当前登录的就是回复的id//当前添加的内容就是评论者评论发帖人
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			User user = (User) SessionUtil.getSession(request);
			if (user != null) {
				ReplyOne replyOne = new ReplyOne();
				Date date=new Date();
				replyOne.setReplyTime(date);// 设置时间
				replyOne.setContent(modelParam.getContent());// 设置回复内容
				replyOne.setTopicID(modelParam.getTopicID());// 设置帖子的id
				replyOne.setHuifuID(user.getUserID());// 评论者id
				replyOne.setBeihuifuID(modelParam.getBeihuiID());// 发布者id被回复
				long i = replyOneDao.Insert(replyOne);
				if (i != 0) {
					JSONObject jsonObject=new JSONObject();
					User user1=userDao.SelectID(modelParam.getBeihuiID());
					if (user.getName().equals("") || user.getName() == null) {// 昵称为空时候使用账号
						jsonObject.element("replyName", user.getAccount());// 发帖人的账号
					} else {
						jsonObject.element("replyName", user.getName());// 发帖人的昵称
					}
					if (user1.getName().equals("") || user1.getName() == null) {// 昵称为空时候使用账号
						jsonObject.element("replyName1", user1.getAccount());// 发帖人的账号
					} else {
						jsonObject.element("replyName1", user1.getName());// 发帖人的昵称
					}
					jsonObject.element("replyUserPhoto", user.getHeadPhoto());
					jsonObject.element("replyContent", modelParam.getContent());
					SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					jsonObject.element("replyTime", sfd.format(date));
					jsonObject.element("replyOneId", i);
					jsonObject.element("huifuID", user.getUserID());
					jsonObject.element("beihuifuID", modelParam.getBeihuiID());
					response.getWriter().print("{\"i\":\"2\",\"list\":"+jsonObject+"}");
				} else {
					response.getWriter().print("{\"i\":\"1\"}");// 恢复失败
				}

			} else {
				response.getWriter().print("{\"i\":\"0\"}");// 登录去
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/insert")
	public void insert(@RequestParam(defaultValue = "") String content, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			User user = (User) SessionUtil.getSession(request);
			if (user != null) {
				Topic topic = new Topic();
				topic.setContent(content);// 发帖内容
				topic.setTime(new Date());// 发帖时间
				topic.setTopicUserID(user.getUserID());// 发布人的用户id
				int i = topicDao.Insert(topic);
				if (i != 0) {
					
					response.getWriter().print("{\"i\":\"1\"}");
				} else {
					response.getWriter().print("{\"i\":\"0\"}");
				}
			} else {
				response.getWriter().print("{\"i\":\"2\"}");
			}

			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value = "/selectTopic")
	public void selectTopic(@RequestParam(defaultValue = "1") int pageNow,HttpServletResponse response){// 获取所有的帖子
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			List<Criterion> criterions = new ArrayList<>();
			List<Topic> listTopic = topicDao.SelectPAGE(criterions, pageNow);
			criterions.clear();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			JSONObject jsonObject1 = new JSONObject();
			JSONArray jsonArray1 = new JSONArray();
			JSONObject jsonObject2 = new JSONObject();
			JSONArray jsonArray2 = new JSONArray();
			if(listTopic.size()>0){
			for (Topic topic : listTopic) {//遍历所有的帖子
				criterions.add(Restrictions.eq("topicID", topic.getTopicID()));// 通过帖子id查询关于这个帖子的所有信息
				List<ReplyOne> listReplyOne = replyOneDao.SelectAll(criterions);// 获取所有的一级评论
				criterions.clear();// 清楚条件
				jsonObject.element("topicID", topic.getTopicID());// 帖子id
				jsonObject.element("time", topic.getTime().toString().substring(0, 19));// 发帖子时间
				jsonObject.element("content", topic.getContent());// 发帖子内容
				User user = userDao.SelectID(topic.getTopicUserID());
				if (user != null) {
					jsonObject.element("fa_ID", user.getUserID());
					if (user.getName().equals("") || user.getName() == null) {// 昵称为空时候使用账号
						jsonObject.element("name", user.getAccount());// 发帖人的账号
					} else {
						jsonObject.element("name", user.getName());// 发帖人的昵称
					}
					jsonObject.element("userPhoto", user.getHeadPhoto());// 回复人的头像
				}
				for (ReplyOne replyOne : listReplyOne) {
					// 帖子id和一级回复的id去查找相关的二级回复
					criterions.add(Restrictions.eq("topicID", topic.getTopicID()));
					criterions.add(Restrictions.eq("replyOneID", replyOne.getReplyOneID()));
					List<ReplyTow> replyTowlist = replyTowDao.SelectAll(criterions);//二级所有的列表
					criterions.clear();
					for (ReplyTow replyTow : replyTowlist) {//遍历所有的二级信息
						User userReply21 = userDao.SelectID(replyTow.getHuifuID());// 回复
						User userReply22 = userDao.SelectID(replyTow.getBeihuifuID());// 被回复
						jsonObject2.element("ttopicID", topic.getTopicID());// 帖子id
						jsonObject2.element("treplyOneID", replyTow.getReplyOneID());// 一级回复id
						if (userReply21 != null) {// 回复的信息
							jsonObject2.element("thuifuID", replyTow.getHuifuID());
							if (userReply21.getName().equals("") || userReply21.getName() == null) {// 昵称为空时候使用账号
								jsonObject2.element("treplyName", userReply21.getAccount());// 回复人的账号
							} else {
								jsonObject2.element("treplyName", userReply21.getName());// 回复人的昵称
							}
							jsonObject2.element("treplyUserPhoto", userReply21.getHeadPhoto());// 回复人的头像
						}
						if (userReply22 != null) {// 被回复的信息
							jsonObject2.element("tbeihuifuID", replyTow.getBeihuifuID());
							if (userReply22.getName().equals("") || userReply22.getName() == null) {
								jsonObject2.element("treplyName1", userReply22.getAccount());
							} else {
								jsonObject2.element("treplyName1", userReply22.getName());
							}
						}
						jsonObject2.element("treplyTime", replyTow.getReplyTime().toString().substring(0, 19));// 回复时间
						jsonObject2.element("treplyContent", replyTow.getContent());// 回复内容
						jsonArray2.add(jsonObject2);
						
					}
					jsonObject1.element("listTwo", jsonArray2);//放入一级对象当做属性
					jsonArray2.clear();
					
					jsonObject1.element("replyOneId", replyOne.getReplyOneID());// 回复id
					User userReply = userDao.SelectID(replyOne.getHuifuID());// 回复
					User userReply2 = userDao.SelectID(replyOne.getBeihuifuID());// 被回复
					if (userReply != null) {// 回复的信息
						jsonObject1.element("huifuID", replyOne.getHuifuID());
						if (userReply.getName().equals("") || userReply.getName() == null) {// 昵称为空时候使用账号
							jsonObject1.element("replyName", userReply.getAccount());// 回复人的账号
						} else {
							jsonObject1.element("replyName", userReply.getName());// 回复人的昵称
						}
						jsonObject1.element("replyUserPhoto", userReply.getHeadPhoto());// 回复人的头像
					}
					if (userReply2 != null) {// 被回复的信息
						jsonObject1.element("beihuifuID", replyOne.getBeihuifuID());
						if (userReply2.getName().equals("") || userReply2.getName() == null) {
							jsonObject1.element("replyName1", userReply2.getAccount());
						} else {
							jsonObject1.element("replyName1", userReply2.getName());
						}
					}
					jsonObject1.element("replyTime", replyOne.getReplyTime().toString().substring(0, 19));// 回复时间
					jsonObject1.element("replyContent", replyOne.getContent());// 回复内容
					jsonArray1.add(jsonObject1);// 对象放入数组
				}
				jsonObject.element("listOne", jsonArray1);//放入帖子对象作为属性
				jsonArray.add(jsonObject);
				jsonArray1.clear();
			}
			response.getWriter().print("{\"list\":"+jsonArray+",\"i\":\"1\"}");
		}else{
			response.getWriter().print("{\"i\":\"0\"}");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "skipPhone")//手机主页
	public ModelAndView getSkipPhone(){
		ModelAndView mav=new ModelAndView("/phone/news");
		return mav;
	}
	@RequestMapping(value = "skipPhoneExit")//退出登陆
	public ModelAndView getSkipPhoneExit(HttpSession session){
		ModelAndView mav=new ModelAndView("redirect:/user/phone/skipNews.html");
		session.removeAttribute("user");
		return mav;
	}
	@RequestMapping(value = "skipLogin")//跳转登陆
	public ModelAndView getSkipLogin(){
		ModelAndView mav=new ModelAndView("/phone/login");
		return mav;
	}
	@RequestMapping(value = "skipRegister")//跳转注册
	public ModelAndView getSkipRegister(){
		ModelAndView mav=new ModelAndView("/phone/register");
		return mav;
	}
	@RequestMapping(value = "skipNews")//跳转新闻
	public ModelAndView getSkipNews(){
		ModelAndView mav=new ModelAndView("/phone/news");
		return mav;
	}
	@RequestMapping(value = "skipLantan")//跳转论坛
	public ModelAndView getSkipLantan(HttpServletRequest request,HttpSession session){
		ModelAndView mav=new ModelAndView("/phone/tribune");
		User user=(User) SessionUtil.getSession(request);
		List<Topic> list_Topic=topicDao.SelectAll(getCriterion());
		if(user!=null){
			User userl=userDao.SelectID(user.getUserID());
			mav.addObject("user", userl);
			session.removeAttribute("user");
			session.setAttribute("user", userl);
		}
		mav.addObject("dynamic", list_Topic.size());
		return mav;
	}
	@RequestMapping(value = "skipUserInfo")//跳转个人资料
	public ModelAndView skipUserInfo(HttpServletRequest request,HttpSession session){
		ModelAndView mav=new ModelAndView("/phone/personinfo");
		User user=(User) SessionUtil.getSession(request);
		if(user!=null){
			User userl=userDao.SelectID(user.getUserID());
			session.removeAttribute("user");
			session.setAttribute("user", userl);
			mav.addObject("user", userl);
		}else{
			mav.setViewName("/phone/login");
		}
		return mav;
	}
	@RequestMapping(value = "UpdateUserInfo",method=RequestMethod.POST)//更新个人资料
	public void UpdateUserInfo(HttpServletRequest request,User user,HttpServletResponse response,
			HttpSession session){
		try{
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			if(user!=null){
				List<Criterion> criterions=new ArrayList<>();
				criterions.add(Restrictions.eq("name", user.getName().trim()));
				List<User> users=userDao.SelectAll(criterions);
				if(users.size()==0){
					if(user.getUserID()!=0){
						User userl=userDao.SelectID(user.getUserID());
						userl.setName(user.getName());
						userl.setPhone(user.getPhone());
						if(user.getSex().equals("nan") || user.getSex().equals("nv")){
							userl.setSex(user.getSex());
						}
						userDao.Update(userl);
						session.removeAttribute("user");
						session.setAttribute("user", userl);
						response.getWriter().print("{\"a\":\"5\"}");
					}else{
						response.getWriter().print("{\"a\":\"0\"}");
					}
				}else if(users.size()==1){
					if(users.get(0).getUserID()==user.getUserID()){
						if(user.getUserID()!=0){
							User userl=userDao.SelectID(user.getUserID());
							userl.setName(user.getName());
							userl.setPhone(user.getPhone());
							if(user.getSex().equals("nan") || user.getSex().equals("nv")){
								userl.setSex(user.getSex());
							}
							userDao.Update(userl);
							session.removeAttribute("user");
							session.setAttribute("user", userl);
							response.getWriter().print("{\"a\":\"5\"}");
						}else{
							response.getWriter().print("{\"a\":\"0\"}");
						}
					}else{
						response.getWriter().print("{\"a\":\"1\"}");
						session.removeAttribute("user");
						session.setAttribute("user", user);
					}
				}else{
					response.getWriter().print("{\"a\":\"1\"}");
					session.removeAttribute("user");
					session.setAttribute("user", user);
				}
			}else{
				response.getWriter().print("{\"a\":\"0\"}");
			}
			response.getWriter().flush();
			response.getWriter().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "logins")//页面获取session值
	public ModelAndView getlogins(User user,HttpSession session){
		ModelAndView mav=new ModelAndView("redirect:/user/phone/skipPhone.html");
		User users=userDao.SelectID(user.getUserID());
		session.removeAttribute("user");
		session.setAttribute("user", users);
		mav.addObject("user", users);
		return mav;
	}
	@RequestMapping(value = "add",method=RequestMethod.POST)//用户添加
	public void getadd(HttpServletResponse response,User user,HttpSession session){
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			if(user==null){
				response.getWriter().print("{\"a\":\"0\"}");
				//setJson="0";
			}else{
				if(user.getAccount()!=null){
					List<Criterion> criterions=new ArrayList<>();
					criterions.add(Restrictions.eq("account", user.getAccount()));
					User userl=userDao.SelectUID(criterions);
					if(userl==null){
						User users=new User();
						users.setAccount(user.getAccount());
						users.setHeadPhoto("moren.png");
						users.setPassword(EncoderByMd5.EncoderMd5(user.getPassword()));
						users.setPhone(user.getPhone());
						String uuid=UUID.randomUUID().toString();
						users.setName("bst"+uuid.substring(0,7));
						users.setSex("nan");
						users.setTime(new Date());
						long i=userDao.Insert(users);
						if(i!=0){
							response.getWriter().print("{\"a\":\"8\",\"id\":\""+i+"\"}");
							/*setJson="8";*/
						}else{
							response.getWriter().print("{\"a\":\"2\"}");
							/*setJson="2";*/
						}
					}else{
						response.getWriter().print("{\"a\":\"1\"}");
						/*setJson="1";*/
					}
				}else{
					response.getWriter().print("{\"a\":\"0\"}");
					//setJson="0";
				}
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "luntan")//论坛便利
	public void getLuntan(Integer PAGENOW,HttpServletResponse response){
 		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		Integer i=getTopicCount();
		try{
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");
			if(PAGENOW<=i){
				List<Topic> list_Topic=topicDao.SelectPAGE(getCriterion(), PAGENOW);
				if(list_Topic!=null){
					if(list_Topic.size()>0){
						for(Topic topic1:list_Topic){
							if(topic1.getTime()!=null&&topic1.getTitle()!=null&&topic1.getTopicUserID()!=0){
								User userl=userDao.SelectID(topic1.getTopicUserID());
								if(userl!=null){
									jsonObject=JSONObject.fromObject(topic1);
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									jsonObject.element("name",userl.getName().toString());
									jsonObject.element("time",sdf.format(topic1.getTime()));
									jsonObject.element("headPhoto",userl.getHeadPhoto().toString());
									jsonArray.add(jsonObject);
								}
							}else{
								response.getWriter().print("{\"i\":\"0\"}");
							}	
						}
						response.getWriter().print("{\"list\":"+jsonArray+",\"i\":\"1\"}");
					}else{
						response.getWriter().print("{\"i\":\"0\"}");
					}
				}else{
					response.getWriter().print("{\"i\":\"0\"}");
				}
			}else{
				response.getWriter().print("{\"i\":\"0\"}");
			}
			response.getWriter().flush();
			response.getWriter().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "wapHeadPhoto")//获取头像信息
	public ModelAndView getwapHeadPhoto(@RequestParam(defaultValue="0")long userID,HttpServletRequest request){
		ModelAndView mav=new ModelAndView("/phone/uploadhead");
		User user=null;
		if(userID!=0){
			 user=userDao.SelectID(userID);
		}else{
			User userl=(User) SessionUtil.getSession(request);
			user=userDao.SelectID(userl.getUserID());
		}
		mav.addObject("user", user);
		return mav;
	}
	@RequestMapping(value = "news")//便利新闻
	public void getNews(Integer PAGENOW,HttpServletResponse response){
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		Integer i=getNewsCount();
		try{
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");
			if(PAGENOW<=i){
				List<News> list_News=newsDao.SelectPAGE(getCriterion(), PAGENOW);
				if(list_News!=null){
					if(list_News.size()>0){
						for(News news1:list_News){
							if(news1.getTime()!=null){
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								SimpleDateFormat sds = new SimpleDateFormat("HH:mm:ss");
								String new_Yea = sdf.format(news1.getTime());
								String new_Data = sds.format(news1.getTime());
								jsonObject.element("id", news1.getId());
								jsonObject.element("new_Yea", new_Yea.toString());
								jsonObject.element("new_Data", new_Data.toString());
								jsonObject.element("new_IMG", news1.getPhoto());
								jsonObject.element("new_title", news1.getTitle());
								jsonObject.element("read", news1.getClicks());
								
								jsonArray.add(jsonObject);
							}else{
								response.getWriter().print("{\"i\":\"0\"}");
							}
						}
						response.getWriter().print("{\"list\":"+jsonArray+",\"i\":\"1\"}");
					}else{
						response.getWriter().print("{\"i\":\"0\"}");
					}
				}else{
					response.getWriter().print("{\"i\":\"0\"}");
				}
			}else{
				response.getWriter().print("{\"i\":\"0\"}");
			}
			response.getWriter().flush();
			response.getWriter().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "newsDetails")//新闻详情
	public ModelAndView getnewsDetails(News news){
		ModelAndView mav=new ModelAndView("/phone/xiangqing");
		News newsl=newsDao.SelectID(news.getId());
		newsl.setClicks(newsl.getClicks()+1);
		newsDao.Update(newsl);
		mav.addObject("news", newsl);
		return mav;
	}
	//个人信息
	@RequestMapping(value = "userInfo")
	public void getuserInfo(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		User userl=(User) SessionUtil.getSession(request);
		try{
			if(userl!=null){
				User user=userDao.SelectID(userl.getUserID());
				session.removeAttribute("user");
				session.setAttribute("user", user);
				response.getWriter().print("{\"a\":\"7\",\"id\":\""+user.getUserID()+"\"}");
			}else{
				response.getWriter().print("{\"a\":\"6\"}");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "login",method=RequestMethod.POST)//登陆判断
	public void getlogin(User user,@RequestParam(defaultValue="0")long userID,HttpSession session,HttpServletResponse response){
		try{
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");
			if(user==null){
				user=userDao.SelectID(userID);
			}
			if(user!=null){
				if(user.getAccount()!=null){
					List<Criterion> criterions=new ArrayList<>();
					criterions.add(Restrictions.eq("account", user.getAccount()));
					User users=userDao.SelectUID(criterions);
					if(users!=null){
						if(users.getPassword().equals(EncoderByMd5.EncoderMd5(user.getPassword().trim()))){
							response.getWriter().print("{\"a\":\"7\",\"id\":\""+users.getUserID()+"\"}");
						}else{
							response.getWriter().print("{\"a\":\"6\"}"); //密码错误
						}
					}else{
						response.getWriter().print("{\"a\":\"5\"}"); //用户名不存在
					}
				}else{
					response.getWriter().print("{\"a\":\"4\"}"); //用户名为空
				}
			}else{
				response.getWriter().print("{\"a\":\"0\"}"); //用户为空
			}
			response.getWriter().flush();
			response.getWriter().close();
		}catch(Exception e){
			e.printStackTrace();
		}
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
	private Integer getTopicCount() {
		Integer PAGECount = topicDao.getCountPAGE(getCriterion());//获取总页数
		if (PAGECount % 10 == 0) {
			PAGECount = PAGECount / 10;
		} else {
			PAGECount = (PAGECount / 10) + 1;
		}
		return PAGECount; //分页处理
	}
	private List<Criterion> getCriterion(){
		List<Criterion> criterion=new ArrayList<>();
		return criterion;
	}
	
}
