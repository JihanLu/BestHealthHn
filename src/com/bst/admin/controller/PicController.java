package com.bst.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import eu.bitwalker.useragentutils.UserAgent;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bst.util.PicUtil;
import com.bst.entity.FileParam;

@Controller
@RequestMapping(value="admin/picture")
public class PicController {

    @Autowired
    PicUtil picUtil;

    /**
     * 上传
     * @param request
     * @return
     */
    @RequestMapping(value="upload")
    public String upload(HttpServletRequest request){
        init(request);
        try {
            picUtil.upload(request);
            request.setAttribute("msg", "ok");
            request.setAttribute("map", getMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:list";
    }

    /**
     * 页面跳转
     * @param request
     * @return
     */
    @RequestMapping(value="list")
    public ModelAndView list(HttpServletRequest request){
        init(request);
        request.setAttribute("map", getMap());
        return new ModelAndView("admin/piclist");
    }

    /**
     * 加载页面，异步初始化文件夹中的文件
     * @param request
     * @return
     */
    @RequestMapping(value="dataList")
    @ResponseBody
    public List<FileParam> initData(HttpServletRequest request){
        init(request);
        List<FileParam> fileList = picUtil.listFiles(PicUtil.FILEDIR);
        return fileList;
    }

    /**
     * 下载
     * @param request
     * @param response
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
            picUtil.download(downloadfFileName, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 使用异步的方式删除文件
     * @date 2016年7月21日 上午11:03:57
     * @param fileName
     * @param request
     * @return Map<String,String>
     */
    @RequestMapping(value="remove")
    @ResponseBody
    public Map<String, String> removeFile(String fileName,HttpServletRequest request){
        Map<String, String> map = new HashMap<String, String>();
//        String dir = fileName.substring(0, 8);
        boolean flag = false;
        File file = new File(PicUtil.FILEDIR+"/"+fileName);
        flag = file.delete();
        if(flag){
            map.put("result", "success");
        }
        return map;
    }

    /**
     * 初始化路径
     * @param request
     */
    private void init(HttpServletRequest request) {
        if(PicUtil.FILEDIR == null){
            PicUtil.FILEDIR = request.getSession().getServletContext().getRealPath("/") + "upload/picture";
        }
    }

    /**
     * getMap
     * @return
     */
    private Map<String, String> getMap(){
        Map<String, String> map = new HashMap<String, String>();
        File[] files = new File(PicUtil.FILEDIR).listFiles();
        if(files != null){
            for (File file : files) {
                if(file.isDirectory()){
                    File[] files2 = file.listFiles();
                    if(files2 != null){
                        for (File file2 : files2) {
                            String name = file2.getName();
//                            map.put(file2.getParentFile().getName() + "/" + name, name.substring(name.lastIndexOf("_")+1));
                            map.put(file2.getParentFile().getName() + "/" + name, name);
                        }
                    }
                }
            }
        }
        return map;
    }
}