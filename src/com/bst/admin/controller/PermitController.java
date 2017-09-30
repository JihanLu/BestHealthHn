package com.bst.admin.controller;

/**
 * Created by javon on 2017/9/19.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin/forum/permit")
public class PermitController {
    @RequestMapping(value = "/show")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("admin/permit");
        return modelAndView;
    }


}
