package com.bst.admin.controller;

/**
 * Created by javon on 2017/9/17.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.entity.ForumInfo;
import com.bst.dao.ForumInfoDao;

@Controller
@RequestMapping("admin/forum")
public class ForumController {
    @Autowired
    private ForumInfoDao forumInfoDao;

    @RequestMapping(value = "/forums")
    public ModelAndView forumInfo(@RequestParam(defaultValue = "0") long id, String content,
                              @RequestParam(defaultValue = "") String mark) {
        ModelAndView modelAndView = new ModelAndView();
        if (!mark.equals("")) {
            //  0论坛简介 1组委会名单 2组织机构 3宗旨与主题

            ForumInfo forumInfo = forumInfoDao.SelectID(id);
            if (forumInfo != null) {// 修改
                forumInfo.setContent(content);
                int i = forumInfoDao.Update(forumInfo);
                if (i != 0) {
                    modelAndView.setViewName("redirect:/admin/forum/selectAll.html?mark="+mark+"");
                } else {
                    modelAndView.addObject("message", "论坛相关信息管理更新失败");
                    modelAndView.setViewName("admin/fail");
                }
            } else {

                ForumInfo forumInfo1 = new ForumInfo();
                forumInfo1.setContent(content);
                forumInfo1.setTime(new Date());
                forumInfo1.setMark(mark);
                int i = forumInfoDao.Insert(forumInfo1);
                if (i != 0) {
                    modelAndView.setViewName("redirect:/admin/forum/selectAll.html?mark="+mark+"");
                } else {
                    modelAndView.addObject("message", "论坛简介添加失败");
                    modelAndView.setViewName("admin/fail");
                }
            }
        }else{
            modelAndView.addObject("message", "操作失败");
            modelAndView.setViewName("admin/fail");
        }
        return modelAndView;
    }

    @RequestMapping(value = "selectAll")
    public ModelAndView selectAll(String mark) {
        ModelAndView modelAndView = new ModelAndView("admin/intro1");
        List<Criterion> criterion=new ArrayList<>();
        criterion.add(Restrictions.eq("mark", mark));
        List<ForumInfo> list_intro=forumInfoDao.SelectAll(criterion);
        if(list_intro!=null){
            if(list_intro.size()>0){
                modelAndView.addObject("forumInfo",list_intro.get(0));
            }
        }
        if(mark.equals("0")){
            modelAndView.addObject("title", "论坛简介");
        }else if(mark.equals("1")){
            modelAndView.addObject("title", "组委会名单");
        }else if(mark.equals("2")){
            modelAndView.addObject("title", "组织机构");
        }else if(mark.equals("3")){
            modelAndView.addObject("title", "宗旨与主题");
        }
        modelAndView.addObject("mark", mark);
        return modelAndView;
    }

    @RequestMapping(value = "download")
    public ModelAndView download(){
        ModelAndView modelAndView = new ModelAndView("admin/download");
        return modelAndView;
    }
}
