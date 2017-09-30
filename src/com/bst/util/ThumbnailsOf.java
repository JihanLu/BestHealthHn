package com.bst.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import net.coobird.thumbnailator.Thumbnails;
public class ThumbnailsOf{
	
	private ThumbnailsOf(){}
	//其他信息图片
	public static String ThumbnailsUUID(UUID uuid,String photoFileName,File photo, HttpServletRequest request,int length,String PATH) {
		String filename = uuid.toString()+photoFileName.substring(photoFileName.lastIndexOf("."));// UUID方式命名
		try {
			BufferedImage sourceImg = ImageIO.read(photo);
			int i = sourceImg.getWidth(), j = sourceImg.getHeight();
			int szie = i <length ? i > j ? i : j : length;
			String path = request.getSession().getServletContext().getRealPath(PATH);// 获取上传文件路径
			File toFile = new File(path, filename);
			Thumbnails.of(sourceImg).size(szie, szie).toFile(toFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filename;
	}
	
	
	//获取字符串中的所有图片路径
		public static List<String> getImageSrc(String htmlCode) {
			String img="";        
	        Pattern p_image;        
	        Matcher m_image;        
	        List<String> pics = new ArrayList<String>();     
	        pics.clear();
	        String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址        
	        p_image = Pattern.compile      
	                (regEx_img,Pattern.CASE_INSENSITIVE);        
	       m_image = p_image.matcher(htmlCode);      
	       while(m_image.find()){        
	            img = img + "," + m_image.group();        
	            Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //匹配src     
	            while(m.find()){
	               pics.add(m.group(1));     
	            }     
	        }
	     //去除srcList集合里重复的字段
	       List<String> listTemp = new ArrayList<>(); 
	       for(int i=0;i<pics.size();i++){  
	           if(!listTemp.contains(pics.get(i))){  
	               listTemp.add(pics.get(i));  
	           }  
	       }    
	       return listTemp; 
	    }
	
	
	
	//顶部图片
		public static String ThumbnailsThumbnail(File file,String fileName, HttpServletRequest request,int length,String paths) {
			try {
				String uploadPath = request.getSession().getServletContext().getRealPath(paths);
				File toFile = new File(uploadPath, fileName);
				BufferedImage sourceImg = ImageIO.read(toFile);
				int i = sourceImg.getWidth(), j = sourceImg.getHeight();
				int szie = i <length ? i > j ? i : j : length;
				
				Thumbnails.of(sourceImg).size(szie, szie).toFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileName;
		}
	
	
	/**
	 * 单个上传图片处理
	 * @param length 尺寸大小
	 * @param photo 文件
	 * @return fileName
	 */
	public static String Thumbnails(MultipartFile photo, HttpServletRequest request,int length,String PATH) {
		String file=uploadPic(photo,request,PATH);
		try {
			String uploadPath = request.getSession().getServletContext().getRealPath(PATH);
			File toFile = new File(uploadPath, file);
			BufferedImage sourceImg = ImageIO.read(toFile);
			int i = sourceImg.getWidth(), j = sourceImg.getHeight();
			int szie = i <length ? i > j ? i : j : length;
			Thumbnails.of(sourceImg).size(szie, szie).toFile(toFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	/**
	 * 删除单个文件
	 * @param fileName 要删除的文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String fileName, HttpServletRequest request,String PATH) {
		
		String uploadPath = request.getSession().getServletContext().getRealPath(PATH);
		File file = new File(uploadPath, fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				//System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				//System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			//System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}
	
	/**
	 * 删除单个文件
	 * @param fileName 要删除的文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile (HttpServletRequest request,String PATH) {
		
		String uploadPath = request.getSession().getServletContext().getRealPath(PATH);
		File file = new File(uploadPath);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				//System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				//System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			//System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}
	
	//处理在线编辑器内容
	public static String Html(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
																										// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
																									// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			htmlStr = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE).matcher(htmlStr).replaceAll(""); // 过滤script标签

			htmlStr = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE).matcher(htmlStr).replaceAll(""); // 过滤style标签

			htmlStr = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE).matcher(htmlStr).replaceAll(""); // 过滤html标签
			textStr = htmlStr.replaceAll("&ldquo;", "“").replaceAll("&rdquo;", "”").replaceAll("&lsquo;", "‘").replaceAll("&rsquo;", "’").replaceAll("&nbsp;", "").trim();

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}
	public static String uploadPic(MultipartFile file,HttpServletRequest request,String PATH){
	    String path = request.getSession().getServletContext().getRealPath(PATH);
	    String fileName = file.getOriginalFilename();
	    fileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));// UUID方式命名
	    File targetFile = new File(path, fileName);
	    if(!targetFile.exists()){
	        targetFile.mkdirs();
	    }
	    //保存
	    try {
	        file.transferTo(targetFile);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return fileName;
	}
}
