package com.bst.controller;

import com.bst.entity.FileParam;
import com.bst.util.PicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user/forum/permit")
public class UserPermitController {

    @Autowired
    PicUtil picUtil;
    @RequestMapping("showList")
    public ModelAndView showList(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/user/permit");
        modelAndView.addObject("pageTitle", "养生论坛");
        modelAndView.addObject("title", "许可批复文件");
        init(request);
        List<FileParam> picList = picUtil.listFiles(PicUtil.FILEDIR);
        modelAndView.addObject("picList",picList);
        return modelAndView;
    }

    private void init(HttpServletRequest request) {
        if(PicUtil.FILEDIR == null){
            PicUtil.FILEDIR = request.getSession().getServletContext().getRealPath("/") + "upload/picture";
        }
    }
}
