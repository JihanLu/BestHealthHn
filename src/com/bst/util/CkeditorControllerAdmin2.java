package com.bst.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CkeditorControllerAdmin2{
	
	@RequestMapping("/ckeditorUpload2")
	public void ckeditorUpload(@RequestParam(value="upload") MultipartFile upload,HttpServletResponse response,HttpServletRequest req) throws IOException{
		
		PrintWriter out = response.getWriter();	
		String url="";
		String uploadpath="/picture/";
		if(upload.getSize()>1*1024*1024){  
            out.write("<font color=\"red\" size=\"2\">*文件大小不得大于500k</font>");  
           // return null;  
        }
		//获取上传图片的后缀名
		String subfix =upload.getOriginalFilename().toString().substring(upload.getOriginalFilename().lastIndexOf(".")+1);		
		//获取文件的Type
		String type=upload.getContentType();
		//限制上传的图片格式
		if((type.equals("image/pjpeg") || type.equals("image/jpeg")) && subfix.equals("jpg")){
			
		}else if(type.equals("image/png") && subfix.equals("png")){
			
		}else if(type.equals("image/gif") && subfix.equals("gif")){
			
		}else if(type.equals("image/bmp") && subfix.equals("bmp")){
			
		}else{
			out.write("<font color=\"red\" size=\"2\">文件格式不正确(必须是.jpg/.gif/.bmp/.png文件)</font>");  
          //  return null;
		}
		// 重新命名图片的名称
		String filename = UUID.randomUUID().toString()+upload.getOriginalFilename().toString().substring(upload.getOriginalFilename().lastIndexOf("."));
		// 上传文件的到服务器的地址
		String filepath = req.getServletContext().getRealPath(uploadpath + filename);
		if(subfix.equals("gif")){
			try {
				// 获取上传文件的ioputstream
				InputStream fileInputStream = upload.getInputStream();
				// 将上传文件的ioputstream写人到filepath路径
				FileOutputStream fileOutputStream = new FileOutputStream(filepath);
				// 定义一个数组来接收
				byte[] buffer = new byte[1024];
				int lengch = 0;
				// 遍历ioputstram
				while ((lengch = fileInputStream.read(buffer)) != -1) {
					// 开始写入到filepath地址
					fileOutputStream.write(buffer, 0, lengch);
				}
				fileInputStream.close();
				fileOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{//对不是GIF的图片进行压缩
			String path = req.getSession().getServletContext().getRealPath(uploadpath);// 获取上传文件路径
			// 获取当前时间与UUID组成的文件名
			String fileName = UUID.randomUUID().toString()
					+ upload.getOriginalFilename().substring(upload.getOriginalFilename().indexOf("."));
			BufferedImage sourceImg;
			try {
			// 把图片写入指定的路径中
			File f = new File(path , "/" + fileName);
			if (f.exists() == false) {
				f.getParentFile().mkdirs();// 创建目录及文件
			}
			//保存图片
			upload.transferTo(f);
			//读取图片
			sourceImg = ImageIO.read(f);
			//获取宽高 ,j = sourceImg.getHeight()
			int i = sourceImg.getWidth();		
			int szie = i <500 ? i : 500;
			//根据宽高压缩
			net.coobird.thumbnailator.Thumbnails.of(sourceImg).size(szie, sourceImg.getHeight()).toFile(f);
		  } catch (Exception e) {
			e.printStackTrace();
		 }	
			url = fileName;
		}
		//System.out.println(req.getContextPath()+uploadpath  + url);
		  out.write(req.getContextPath()+uploadpath  + url);
		  out.flush();
		  out.close();
	}
}
