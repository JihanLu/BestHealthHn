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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.RecommendDao;
import com.bst.entity.Admin;
import com.bst.entity.Recommend;
import com.bst.util.SessionUtil;
import com.bst.util.ThumbnailsOf;

/**
 * 
 * @author fumingqi 2017年7月24日 产品安排
 */
@Controller
@RequestMapping("admin/recommend")
public class RecommendController {
	@Autowired
	private RecommendDao recommendDao;

	@RequestMapping(value = "/insertjsp")
	public ModelAndView insertjsp() {
		return new ModelAndView("admin/recommend/recommend_add");
	}

	@RequestMapping(value = "/selectTitle")
	public ModelAndView selectTitle(@RequestParam(defaultValue = "") String title,@RequestParam(defaultValue = "1") int pageNow) {

		ModelAndView modelAndView = new ModelAndView("admin/recommend/recommend_list");
		List<Criterion> criterion = new ArrayList<>();
		criterion.add(Restrictions.like("title", "%" + title + "%"));
		modelAndView.addObject("recommendlist", recommendDao.SelectPAGE1(criterion, pageNow));
		long rowCount = recommendDao.getCountPAGE(criterion);
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
	public ModelAndView insert(Recommend recommend,@RequestParam(value = "image", required = false) MultipartFile file,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String path = ThumbnailsOf.Thumbnails(file, request, 250, "/picture/");
		recommend.setPhoto(path);
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			recommend.setAuthor(admin.getAdminsName());
		}else{
			recommend.setAuthor("admin");
		}
		recommend.setTime(new Date());
		int i = recommendDao.Insert(recommend);
		if (i != 0) {
			modelAndView.setViewName("redirect:/admin/recommend/selectAll.html");
		} else {
			modelAndView.addObject("message", "产品添加失败");
			modelAndView.setViewName("admin/fail");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/selectAll")
	public ModelAndView selectAll(@RequestParam(defaultValue = "1") int pageNow) {
		ModelAndView modelAndView = new ModelAndView("admin/recommend/recommend_list");
		List<Criterion> criterion = new ArrayList<>();
		modelAndView.addObject("recommendlist", recommendDao.SelectPAGE1(criterion, pageNow));
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = recommendDao.getCountPAGE(criterion);
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
		ModelAndView modelAndView = new ModelAndView("admin/recommend/recommend_edit");
		Recommend recommend = recommendDao.SelectID(id);
		modelAndView.addObject("recommend", recommend);
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
				Recommend recommend = recommendDao.SelectID(Long.valueOf(item[i]));
				if (recommend != null) {
					List<String> listimg = ThumbnailsOf.getImageSrc(recommend.getContent());
					int a = recommendDao.Delete(recommend.getId());
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
				Recommend recommend = recommendDao.SelectID(id);
				if (recommend != null) {
					List<String> listimg = ThumbnailsOf.getImageSrc(recommend.getContent());
					
					int i = recommendDao.Delete(id);
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
		ModelAndView modelAndView = new ModelAndView("admin/recommend/recommend_edit");
		Recommend recommend = recommendDao.SelectID(id);
		modelAndView.addObject("recommend", recommend);
		return modelAndView;
	}

	@RequestMapping(value = "/update")
	public ModelAndView update(Recommend a,HttpServletRequest request,@RequestParam(value = "image", required = false) MultipartFile file) {
		ModelAndView modelAndView = new ModelAndView("admin/fail");
		Recommend recommend = recommendDao.SelectID(a.getId());
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			recommend.setAuthor(admin.getAdminsName());
		}
		if (recommend != null) {
			if(file.getSize()!=0){
				String path = ThumbnailsOf.Thumbnails(file, request, 250, "/picture/");
				recommend.setPhoto(path);
			}
			ThumbnailsOf.deleteFile(recommend.getContent(), request, "/picture/");
			recommend.setTitle(a.getTitle());
			recommend.setContent(a.getContent());
			recommend.setSources(a.getSources());
			int i = recommendDao.Update(recommend);
			if (i != 0) {
				modelAndView.setViewName("redirect:/admin/recommend/selectAll.html");
			} else {
				modelAndView.addObject("message", "产品修改失败");
			}
		} else {
			modelAndView.addObject("message", "产品修改失败");
		}
		return modelAndView;
	}
}
