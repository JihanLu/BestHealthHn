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

import com.bst.dao.LiteratureDao;
import com.bst.entity.Admin;
import com.bst.entity.Literature;
import com.bst.util.SessionUtil;
import com.bst.util.ThumbnailsOf;

/**
 * 文献管理
 * @author fumingqi
 * 2017年7月27日
 */
@Controller
@RequestMapping("admin/literature")
public class LiteratureController {
	@Autowired
	private LiteratureDao literaturedao;
	
	@RequestMapping(value = "/insertjsp")
	public ModelAndView insertjsp(){
		return new ModelAndView("admin/literature/literature_add");
	}
	
	@RequestMapping(value="/selectTitle")
	public ModelAndView selectTitle(@RequestParam(defaultValue="") String title,@RequestParam(defaultValue = "1") int pageNow){
		ModelAndView modelAndView = new ModelAndView("admin/literature/literature_list");
		List<Criterion> criterion=new ArrayList<>();
		criterion.add(Restrictions.like("title", "%"+title+"%"));
		modelAndView.addObject("literaturelist",literaturedao.SelectPAGE1(criterion, pageNow));
		long rowCount = literaturedao.getCountPAGE(criterion);
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
	public ModelAndView insert(@RequestParam(value = "image", required = false) MultipartFile file,Literature literature,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		literature.setTime(new Date());
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			literature.setAuthor(admin.getAdminsName());
		}else{
			literature.setAuthor("admin");
		}
		String path = ThumbnailsOf.Thumbnails(file, request, 250, "/picture/");
		literature.setTime(new Date());
		literature.setPhoto(path);
		int i=literaturedao.Insert(literature);
		if(i!=0){
			modelAndView.setViewName("redirect:/admin/literature/selectAll.html");
		}else{
			modelAndView.addObject("message", "文献添加失败");
			modelAndView.setViewName("admin/fail");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/selectAll")
	public ModelAndView selectAll(@RequestParam(defaultValue = "1") int pageNow) {
		ModelAndView modelAndView = new ModelAndView("admin/literature/literature_list");
		List<Criterion> criterion = new ArrayList<>();
		modelAndView.addObject("literaturelist", literaturedao.SelectPAGE1(criterion, pageNow));
		modelAndView.addObject("pageNow", pageNow);
		long rowCount = literaturedao.getCountPAGE(criterion);
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
		ModelAndView modelAndView = new ModelAndView("admin/literature/literature_edit");
		Literature literature=literaturedao.SelectID(id);
		modelAndView.addObject("literature", literature);
		return modelAndView;
	}
	
	@RequestMapping(value = "/delectAll")
	public void delectAll(@RequestParam(defaultValue="") String items,HttpServletResponse response,HttpServletRequest request){
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			String[] item=items.split(",");
			for (int i = 0; i < item.length; i++) {
				Literature literature=literaturedao.SelectID(Long.valueOf(item[i]));
				if(literature!=null){
					List<String> listimg = ThumbnailsOf.getImageSrc(literature.getContent());
					int a=literaturedao.Delete(literature);
					if(a!=0){
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
	public void delect(@RequestParam(defaultValue="0") long id,HttpServletResponse response,HttpServletRequest request) {
		try {
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			if(id!=0){
				Literature literature=literaturedao.SelectID(id);
				if(literature!=null){
					
					int i=literaturedao.Delete(literature);
					if(i!=0){
						ThumbnailsOf.deleteFile(literature.getContent(), request, "/picture/");
						response.getWriter().print("{\"del\":\"0\"}");
					}else{
						response.getWriter().print("{\"del\":\"1\"}");
					}
				}else{
					response.getWriter().print("{\"del\":\"2\"}");
				}
			}else{
				response.getWriter().print("{\"del\":\"3\"}");
			}	
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@RequestMapping(value = "/updateView")
	public ModelAndView updateView(@RequestParam(defaultValue="0") int id) {
		ModelAndView modelAndView = new ModelAndView("admin/literature/literature_edit");
		Literature literature=literaturedao.SelectID(id);
		modelAndView.addObject("literature", literature);
		return modelAndView;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView update(@RequestParam(value = "image", required = false) MultipartFile file, Literature a,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/fail");
		Literature literature=literaturedao.SelectID(a.getId());
		Admin admin=(Admin) SessionUtil.getSessionAdmin(request);
		if(admin!=null){
			literature.setAuthor(admin.getAdminsName());
		}
		if(literature!=null){
			if(file.getSize()!=0){
				String path = ThumbnailsOf.Thumbnails(file, request, 250, "/picture/");
				literature.setPhoto(path);
			}
			ThumbnailsOf.deleteFile(literature.getContent(), request, "/picture/");
			literature.setTitle(a.getTitle());
			literature.setContent(a.getContent());
			literature.setSources(a.getSources());
			int i=literaturedao.Update(literature);
			if(i!=0){
				modelAndView.setViewName("redirect:/admin/literature/selectAll.html");
			}else{
				modelAndView.addObject("message", "文献修改失败");
			}
		}else{
			modelAndView.addObject("message", "文献修改失败");
		}
		return modelAndView;
	}
}
