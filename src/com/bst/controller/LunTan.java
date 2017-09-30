package com.bst.controller;

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

import com.bst.dao.InformDao;
import com.bst.dao.ReplyOneDao;
import com.bst.dao.ReplyTowDao;
import com.bst.dao.TopicDao;
import com.bst.dao.UserDao;
import com.bst.entity.Inform;
import com.bst.entity.ReplyOne;
import com.bst.entity.ReplyTow;
import com.bst.entity.Topic;
import com.bst.entity.User;
import com.bst.util.ModelParam;
import com.bst.util.SessionUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 论坛
 * 
 * @author fumingqi 2017年7月28日
 */
@Controller
@RequestMapping("user/luntan")
public class LunTan {
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ReplyOneDao replyOneDao;
	@Autowired
	private ReplyTowDao replyTowDao;

	@RequestMapping(value = "/insert2")
	public void insert2(ModelParam modelParam, HttpServletResponse response, HttpServletRequest request) {
		try {// 当前添加的内容是发帖人回复
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			// System.out.println(modelParam);
			User user = (User) SessionUtil.getSession(request);
			if (user != null) {
				// 获取要被回复的id，回复的id为当前登录的id
				ReplyTow replyTow = new ReplyTow();
				replyTow.setReplyTime(new Date());// 设置时间
				replyTow.setContent(modelParam.getContent());// 设置回复内容
				replyTow.setTopicID(modelParam.getTopicID());// 设置帖子的id
				replyTow.setHuifuID(user.getUserID());// 发帖人回复的回复者
				replyTow.setBeihuifuID(modelParam.getBeihuiID());// 评论者的id被恢复着
				replyTow.setReplyOneID(modelParam.getRepltOneID());// 一级回复id
				long i = replyTowDao.Insert(replyTow);
				if (i != 0) {
					response.getWriter().print("{\"i\":\"2\"}");
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
			// System.out.println(modelParam);
			User user = (User) SessionUtil.getSession(request);
			if (user != null) {
				ReplyOne replyOne = new ReplyOne();
				replyOne.setReplyTime(new Date());// 设置时间
				replyOne.setContent(modelParam.getContent());// 设置回复内容
				replyOne.setTopicID(modelParam.getTopicID());// 设置帖子的id
				replyOne.setHuifuID(user.getUserID());// 评论者id
				replyOne.setBeihuifuID(modelParam.getBeihuiID());// 发布者id
				long i = replyOneDao.Insert(replyOne);
				if (i != 0) {
					response.getWriter().print("{\"i\":\"2\"}");
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
	public ModelAndView selectTopic(@RequestParam(defaultValue = "1") int pageNow) {// 获取所有的帖子
		ModelAndView modelAndView = new ModelAndView("user/forum");
		List<Criterion> criterions = new ArrayList<>();
		List<Topic> listTopic = topicDao.SelectPAGE(criterions, pageNow);

		long rowCount = topicDao.getCountPAGE(criterions);
		criterions.clear();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject1 = new JSONObject();
		JSONArray jsonArray1 = new JSONArray();
		JSONObject jsonObject2 = new JSONObject();
		JSONArray jsonArray2 = new JSONArray();
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
				jsonObject1.element("replyTow", jsonArray2);//放入一级对象当做属性
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
			jsonObject.element("replyOne", jsonArray1);//放入帖子对象作为属性
			jsonArray.add(jsonObject);
			jsonArray1.clear();
		}

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
		// System.out.println(jsonArray);
		modelAndView.addObject("luntanlist", jsonArray);
		modelAndView.addObject("inform", getInform(6));
		return modelAndView;
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
	private  List<Criterion> getCriterion(){
		List<Criterion> criterion=new ArrayList<>();
		return criterion;
	}
	@Autowired
	private InformDao informDao;
}
