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

import com.bst.dao.InformDao;
import com.bst.entity.Admin;
import com.bst.entity.Inform;
import com.bst.util.SessionUtil;
import com.bst.util.ThumbnailsOf;
/**
 * 通知公告
 * @author fumingqi
 * 2017年7月26日
 */
@Controller
@RequestMapping("admin/inform")
public class InformController {
	@Autowired
	private InformDao informDao;
	
	@RequestMapping(value = "/insertjsp")
	public ModelAndView insertjsp(){
		return new ModelAndView("admin/inform/inform_add");
	}
	
	@RequestMapping(value="/selectTitle")
	public ModelAndView selectTitle(@RequestParam(defaultValue="") String title,@RequestParam(defaultValue = "1") int pageNow){
		ModelAndView modelAndView = new ModelAndView("admin/inform/inform_list");
		List<Criterion> criterion=new ArrayList<>();
		criterion.add(Restrictions.like("title", "%"+title+"%"));
		modelAndView.addObject("informlist",informDao.SelectPAGE(criterion, pageNow));
		long rowCount = informDao.getCountPAGE(criterion);
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
	public ModelAndView insert(Inform inform,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		inform.setTime(new Date());
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			inform.setAuthor(admin.getAdminsName());
		}else{
			inform.setAuthor("admin");
		}
		int i=informDao.Insert(inform);
		if(i!=0){
			modelAndView.setViewName("redirect:/admin/inform/selectAll.html");
		}else{
			modelAndView.addObject("message", "通告添加失败");
			modelAndView.setViewName("admin/fail");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/selectAll")
	public ModelAndView selectAll(@RequestParam(defaultValue = "1") int pageNow) {
		ModelAndView modelAndView = new ModelAndView("admin/inform/inform_list");
		List<Criterion> criterion = new ArrayList<>();
		modelAndView.addObject("informlist", informDao.SelectPAGE(criterion, pageNow));
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = informDao.getCountPAGE(criterion);
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
		ModelAndView modelAndView = new ModelAndView("admin/inform/inform_edit");
		Inform inform=informDao.SelectID(id);
		modelAndView.addObject("inform", inform);
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
				Inform inform = informDao.SelectID(Long.valueOf(item[i]));
				if (inform != null) {
					List<String> listimg = ThumbnailsOf.getImageSrc(inform.getContent());
					int a = informDao.Delete(inform.getId());
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
				Inform inform =  informDao.SelectID(id);
				if (inform != null) {
					List<String> listimg = ThumbnailsOf.getImageSrc(inform.getContent());
					
					int i = informDao.Delete(id);
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
		ModelAndView modelAndView = new ModelAndView("admin/inform/inform_edit");
		Inform inform=informDao.SelectID(id);
		modelAndView.addObject("inform", inform);
		return modelAndView;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView update(Inform a,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/fail");
		Inform inform=informDao.SelectID(a.getId());
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			inform.setAuthor(admin.getAdminsName());
		}
		if(inform!=null){
			inform.setTitle(a.getTitle());
			inform.setContent(a.getContent());
			inform.setSources(a.getSources());
			int i=informDao.Update(inform);
			if(i!=0){
				modelAndView.setViewName("redirect:/admin/inform/selectAll.html");
			}else{
				modelAndView.addObject("message", "通告修改失败");
			}
		}else{
			modelAndView.addObject("message", "通告修改失败");
		}
		return modelAndView;
	}
}
