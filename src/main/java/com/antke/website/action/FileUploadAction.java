package com.antke.website.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.multipart.MultipartFile;

import com.antke.website.utils.Base64;
import com.antke.website.utils.JacksonUtil;
import com.antke.website.utils.qiniuUtil;
import com.thoughtworks.xstream.core.util.Base64Encoder;



@Controller
@RequestMapping("/fileUpload")
public class FileUploadAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(FileUploadAction.class);
		@RequestMapping("/fileUpload.action")
	    public void fileUpload(
	    		@RequestParam(value = "file", required = false)MultipartFile file,
	    		@RequestParam(value = "paramUrl", required = false,defaultValue="erpimg")String paramUrl,
	    		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	    	try { 
	    	PrintWriter out = null;
	        //response.setContentType("text/html");     
	   //     response.setCharacterEncoding("UTF-8");  
	  //      response.setContentType("multipart/form-data");
//	        String contextpath = request.getContextPath();  
//	        String root_Path="/barterimg"; //存储图片的根目录
//	        String images_path =FileUtil.getProperty("images_path"); //"D://tisimages/";
//	        String images_url =FileUtil.getProperty("images_url"); //"D://tisimages/";
//	        String images_path ="D://tisimages/";
//		    String path= PictureUtil.getPathByModelName(paramUrl);
//		    String pic_name=System.currentTimeMillis()+".jpg";
//			String pic_url =root_Path+ path + pic_name;//入库地址
			
//	        System.out.println(pic_url);  
//	        File targetFile = new File(images_path+root_Path+path, pic_name);  
//	        if(!targetFile.exists()){  
//	            targetFile.mkdirs();  
//	        }  
//	        log.info("上传图片开始");
//	        file.transferTo(targetFile); 
//	        String fileName= file.getName();
//	        
//            Map responMap = new HashMap();
//            responMap.put("images_url", images_url);
//            responMap.put("imageUrl", pic_url);
//            responMap.put("fileName", fileName);
            //String json = JacksonUtil.convertData(responMap,"2");
//			 
//			log.info("回复包："+json);
			//response.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
//        	out = response.getWriter();
//        	out.println(json);
//        	out.flush();
//        	out.close();
			response.setContentType("text/html;charset=UTF-8");
        	Base64Encoder encoder = new Base64Encoder();
        	String img = encoder.encode(file.getBytes());
        	Map responMap = new HashMap();
        	Map map = new HashMap();
        	responMap.put("success", true);
        	Map rsMap = qiniuUtil.upload(Base64.decode(img));
        	responMap.put("image_url", rsMap.get("image_url"));
        	map.put("data", responMap);
        	String json = JacksonUtil.convertData(responMap,"2");
        	System.out.println(rsMap.get("image_url"));
        	out = response.getWriter();
        	out.println(json);
        	out.flush();
        	out.close();
	        }catch(Exception ee) {  
	        	 log.info("上传图片异常",ee);
	            ee.printStackTrace();  
	        }  
	          
	    }  
	    public void init(ServletConfig config) throws ServletException {  
	    	SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	    }
	    
	    @RequestMapping("/imgsUpload.action")
	    public void imgsUpload(
	    		@RequestParam(value = "imgs", required = false)MultipartFile file,
	    		@RequestParam(value = "paramUrl", required = false,defaultValue="erpimg")String paramUrl,
	    		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	    	try { 
	    	PrintWriter out = null;
			response.setContentType("text/html;charset=UTF-8");
        	Base64Encoder encoder = new Base64Encoder();
        	String img = encoder.encode(file.getBytes());
        	Map responMap = new HashMap();
        	Map map = new HashMap();
        	responMap.put("success", true);
        	Map rsMap = qiniuUtil.upload(Base64.decode(img));
        	responMap.put("image_url", rsMap.get("image_url"));
        	map.put("data", responMap);
        	String json = JacksonUtil.convertData(responMap,"2");
        	System.out.println(rsMap.get("image_url"));
        	out = response.getWriter();
        	out.println(json);
        	out.flush();
        	out.close();
	        }catch(Exception ee) {  
	        	 log.info("上传图片异常",ee);
	            ee.printStackTrace();  
	        }  
	          
	    } 
	    
	    @RequestMapping("/videoUpload.action")
	    public void videoUpload(
	    		@RequestParam(value = "video", required = false)MultipartFile file,
	    		@RequestParam(value = "paramUrl", required = false,defaultValue="erpimg")String paramUrl,
	    		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	    	try { 
	    	PrintWriter out = null;
			response.setContentType("text/html;charset=UTF-8");
        	Base64Encoder encoder = new Base64Encoder();
        	String img = encoder.encode(file.getBytes());
        	Map responMap = new HashMap();
        	Map map = new HashMap();
        	responMap.put("success", true);
        	Map rsMap = qiniuUtil.upload(Base64.decode(img));
        	responMap.put("image_url", rsMap.get("image_url"));
        	map.put("data", responMap);
        	String json = JacksonUtil.convertData(responMap,"2");
        	System.out.println(rsMap.get("image_url"));
        	out = response.getWriter();
        	out.println(json);
        	out.flush();
        	out.close();
	        }catch(Exception ee) {  
	        	 log.info("上传图片异常",ee);
	            ee.printStackTrace();  
	        }  
	          
	    } 
}
