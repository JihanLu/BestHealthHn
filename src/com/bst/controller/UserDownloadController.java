package com.bst.controller;

import com.bst.entity.FileParam;
import com.bst.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("user/forum/file")
public class UserDownloadController {

    @Autowired
    FileUtil fileUtil;

    @RequestMapping("showList")
    public ModelAndView showList(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/user/download");
        modelAndView.addObject("pageTitle", "养生论坛");
        modelAndView.addObject("title", "在线下载");
        init(request);
        List<FileParam> fileList = fileUtil.listFiles(FileUtil.FILEDIR);
        modelAndView.addObject("fileList",fileList);
        return modelAndView;
    }
    /**
     * @description 下载文件
     * @date 2016年7月21日 上午11:03:51
     * @param request
     * @param response
//     * @param fileName
     * @return void
     */
    @RequestMapping(value="download")
    public void download(HttpServletRequest request, HttpServletResponse response){
        init(request);
        try {
            String downloadfFileName = request.getParameter("fileName");
            downloadfFileName = new String(downloadfFileName.getBytes("iso-8859-1"),"utf-8");
//            String fileName = downloadfFileName.substring(downloadfFileName.indexOf("_")+1);
            String fileName = downloadfFileName;
            String userAgent = request.getHeader("User-Agent").toLowerCase();
            byte[] bytes = (userAgent.contains("msie")||userAgent.contains("like gecko")) ? fileName.getBytes() : fileName.getBytes("UTF-8");
            fileName = new String(bytes, "ISO-8859-1");
            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", fileName));
//            FileOperateUtil.download(downloadfFileName, response.getOutputStream());
            fileUtil.download(downloadfFileName, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 初始化路径
     * @date 2016年7月21日 上午11:04:08
     * @param request
     * @return void
     */
    private void init(HttpServletRequest request) {
        if(FileUtil.FILEDIR == null){
            FileUtil.FILEDIR = request.getSession().getServletContext().getRealPath("/") + "upload/document";
        }
    }
}