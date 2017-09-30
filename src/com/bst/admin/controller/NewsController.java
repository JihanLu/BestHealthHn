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

import com.bst.dao.NewsDao;
import com.bst.entity.Admin;
import com.bst.entity.News;
import com.bst.util.SessionUtil;
import com.bst.util.ThumbnailsOf;

/**
 * 咨询新闻
 * @author fumingqi
 * 2017年7月26日
 */
@Controller
@RequestMapping("admin/news")
public class NewsController {
	@Autowired
	private NewsDao newsDao;
	
	@RequestMapping(value = "/insertjsp")
	public ModelAndView insertjsp(){
		return new ModelAndView("admin/news/news_add");
	}
	
	@RequestMapping(value="/selectTitle")
	public ModelAndView selectTitle(@RequestParam(defaultValue="") String title,@RequestParam(defaultValue = "1") int pageNow){
		ModelAndView modelAndView = new ModelAndView("admin/news/news_list");
		List<Criterion> criterion=new ArrayList<>();
		criterion.add(Restrictions.like("title", "%"+title+"%"));
		modelAndView.addObject("newslist",newsDao.SelectPAGE(criterion, pageNow));
		long rowCount = newsDao.getCountPAGE(criterion);
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
	public ModelAndView insert(News news,@RequestParam(value = "image", required = false) MultipartFile file,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String path = ThumbnailsOf.Thumbnails(file, request, 250, "/picture/");
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			news.setAuthor(admin.getAdminsName());
		}else{
			news.setAuthor("admin");
		}
		news.setTime(new Date());
		news.setPhoto(path);
		news.setClicks(0);
		if(news.getTopid()==1||news.getTopid()==0){
			news.setTopid(news.getTopid());
		}else{
			news.setTopid(0);
		}
		int i=newsDao.Insert(news);
		
		if(i!=0){
			modelAndView.setViewName("redirect:/admin/news/selectAll.html");
		}else{
			modelAndView.addObject("message", "通告添加失败");
			modelAndView.setViewName("admin/fail");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/selectAll")
	public ModelAndView selectAll(@RequestParam(defaultValue = "1") int pageNow) {
		ModelAndView modelAndView = new ModelAndView("admin/news/news_list");
		List<Criterion> criterion = new ArrayList<>();
		modelAndView.addObject("newslist", newsDao.SelectPAGE(criterion, pageNow));
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = newsDao.getCountPAGE(criterion);
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
	public ModelAndView select(@RequestParam(defaultValue="0") long id) {
		ModelAndView modelAndView = new ModelAndView("admin/news/news_edit");
		News news=newsDao.SelectID(id);
		modelAndView.addObject("news", news);
		return modelAndView;
	}
	
	@RequestMapping(value = "/delectAll")
	public void delectAll(@RequestParam(defaultValue="") String items,HttpServletResponse response,
			HttpServletRequest request){
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			String[] item=items.split(",");
			for (int i = 0; i < item.length; i++) {
				News news = newsDao.SelectID(Long.valueOf(item[i]));
				if (news != null) {
					List<String> listimg = ThumbnailsOf.getImageSrc(news.getContent());
					int a = newsDao.Delete(news.getId());
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
	public void delect(@RequestParam(defaultValue="0") long id,HttpServletResponse response,
			HttpServletRequest request) {
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			if(id!=0){
				News news= newsDao.SelectID(id);
				if (news != null) {
					List<String> listimg = ThumbnailsOf.getImageSrc(news.getContent());
					
					int i = newsDao.Delete(id);
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

			}else{
				response.getWriter().print("{\"del\":\"2\"}");
			}	
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@RequestMapping(value = "/updateView")
	public ModelAndView updateView(@RequestParam(defaultValue="0") int id) {
		ModelAndView modelAndView = new ModelAndView("admin/news/news_edit");
		News news=newsDao.SelectID(id);
		modelAndView.addObject("news", news);
		return modelAndView;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView update(News a,HttpServletRequest request,@RequestParam(value = "image", required = false) MultipartFile file) {
		ModelAndView modelAndView = new ModelAndView("admin/fail");
		News news=newsDao.SelectID(a.getId());
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			news.setAuthor(admin.getAdminsName());
		}
		if(news!=null){
			if(file.getSize()!=0){
				String path = ThumbnailsOf.Thumbnails(file, request, 250, "/picture/");
				news.setPhoto(path);
			}
			news.setContent(a.getContent());
			news.setTitle(a.getTitle());
			news.setSources(a.getSources());
			if(a.getTopid()==1||a.getTopid()==0){
				news.setTopid(a.getTopid());
			}else{
				news.setTopid(0);
			}
			int i=newsDao.Update(news);
			if(i!=0){
				modelAndView.setViewName("redirect:/admin/news/selectAll.html");
			}else{
				modelAndView.addObject("message", "通告修改失败");
			}
		}else{
			modelAndView.addObject("message", "通告修改失败");
		}
		return modelAndView;
	}
}
