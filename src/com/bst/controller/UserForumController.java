package com.bst.controller;

/**
 * Created by javon on 2017/9/17.
 */

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bst.dao.InformDao;
import com.bst.dao.ForumInfoDao;
import com.bst.entity.Inform;
import com.bst.entity.ForumInfo;

@Controller
@RequestMapping("user/forum")
public class UserForumController {
    @Autowired
    private ForumInfoDao forumInfoDao;
    @Autowired
    private InformDao informDao;


    @RequestMapping(value = "selectAll")
    public ModelAndView selectAll(@RequestParam(defaultValue="") String mark) {
        ModelAndView modelAndView = new ModelAndView("/user/introduce");
        List<Criterion> criterion=new ArrayList<>();
        criterion.add(Restrictions.eq("mark", mark));
        List<ForumInfo> list_intro=forumInfoDao.SelectAll(criterion);
        if(list_intro!=null){
            if(list_intro.size()>0){
                modelAndView.addObject("intro",list_intro.get(0));
            }
        }
        if(mark.equals("0")){
            modelAndView.addObject("title", "论坛简介");
            modelAndView.addObject("mark", "1");
        }else if(mark.equals("1")){
            modelAndView.addObject("title", "组委会名单");
            modelAndView.addObject("mark", "2");
        }else if(mark.equals("2")){
            modelAndView.addObject("title", "组织机构");
            modelAndView.addObject("mark", "3");
        }else if(mark.equals("3")){
            modelAndView.addObject("title", "宗旨与主题");
            modelAndView.addObject("mark", "4");
        }
        modelAndView.addObject("pageTitle", "养生论坛");
        modelAndView.addObject("mark", mark);
        modelAndView.addObject("inform",getInform(6));
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
}
