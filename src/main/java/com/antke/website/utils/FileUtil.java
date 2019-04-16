package com.antke.website.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class FileUtil {
	
	private static Properties propertie;
    private static FileInputStream inputFile;
    private static FileOutputStream outputFile;
	public static Map CACHE = new HashMap();
	private final static Log log = LogFactory.getLog(FileUtil.class);

	public static Properties getProperties(String path, boolean needCache)
			throws Exception {
		Properties p = null;
		try {
			if (needCache) {
				String key = "" + path.hashCode();
				p = (Properties) CACHE.get(key);
				if (p == null) {
					p = new Properties();
					File file = new File(path);
					FileInputStream fis = new FileInputStream(file);
					p.load(fis);
					CACHE.put(key, p);
					fis.close();
					fis = null;
				}
			} else {
				p = new Properties();
				File file = new File(path);
				FileInputStream fis = new FileInputStream(file);
				p.load(fis);
				fis.close();
				fis = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("读properties文件[" + path + "]错，", e);
		}

		return p;
	}

	public static Properties getProperties(String path) throws Exception {
		return getProperties(path, true);
	}

	public static String getFilePath(String path) {
		try {
			path = FileUtil.class.getClassLoader().getResource(path).getFile();
			path = URLDecoder.decode(path, SysConstants.DEFAULT_ENCODE);

		} catch (UnsupportedEncodingException e) {

			log.error(e);
		}
		return path;
	}
	
	/**
	 * 获取配置文件config.properties 信息
	 * @param Property
	 * @return
	 */
	public static String getProperty(String property) {
		String  value = "";
		String path= null;
		try {
			 if(propertie.containsKey(property)) {
		            value = propertie.getProperty(property).trim();//得到某一属性的值
		            return value;
		        }
		        else{
		        	return "";
		        }
		} catch (Exception e) {
			log.error("获取配置文件config.properties 信息失败！", e);
			return null ;
		}
	}
	
	   public static void setConfigResource(String filePath){
	    	propertie = new Properties();
	        try  {
	            inputFile = new FileInputStream(filePath);
	            propertie.load(inputFile);
	            inputFile.close();
	        } catch (FileNotFoundException ex)  {
	            log.info("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
	            ex.printStackTrace();
	        } catch (IOException ex)  {
	            log.info("装载文件--->失败!");
	            ex.printStackTrace();
	        }
	    }
	   
	   /**  
	     * 文件下载	
	     * @param response  
	     * @param realname         	文件真实名字  
	     * @param downloadName 		文件下载时名字  
	     * @param url 				路径
	     */  
	    public static void download(HttpServletResponse response, String realname, String downloadName, String url) {  
	        String fileName = null;  
	        try {  
	            fileName = new String(downloadName.getBytes("GBK"), "ISO-8859-1");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        String realPath = url;
	        String path = realPath;
	        File file = new File(path);  
	        response.reset();  
	        response.setContentType("application/x-download");  
	        response.setCharacterEncoding("utf-8");  
	        response.setContentLength((int) file.length());  
	        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);  
	        byte[] buff = new byte[1024];  
	        BufferedInputStream bis = null;  
	        OutputStream os = null;  
	        try {  
	            os = response.getOutputStream();  
	            bis = new BufferedInputStream(new FileInputStream(file));  
	            int i = 0;  
	            while ((i = bis.read(buff)) != -1) {  
	                os.write(buff, 0, i);  
	                os.flush();  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                bis.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    } 
}

