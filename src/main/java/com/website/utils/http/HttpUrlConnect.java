package com.website.utils.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;

import com.website.utils.CommonsUtil;
import com.website.utils.ErrorCode;


public class HttpUrlConnect {
	private static final Logger log = Logger.getLogger(HttpUrlConnect.class);
	
	public static String getPostResponseWithHttpURL(String requrl,
			String param, int connectiontimeout, int readtimeout,
			String paramType, String charset) {
		if (connectiontimeout == 0) {
			connectiontimeout = 10000;
		}
		if (readtimeout == 0) {
			readtimeout = 25000;
		}
		OutputStreamWriter out = null;
		BufferedReader in = null;
		HttpURLConnection connect = null;
		String result = "";
		try {
			URL url = new URL(requrl);
			connect = (HttpURLConnection) url.openConnection();
			connect.setConnectTimeout(connectiontimeout);
			connect.setReadTimeout(readtimeout);
			connect.setDoInput(true);
			connect.setDoOutput(true);
			connect.setRequestMethod("POST");
			if (paramType.equals("2"))
				connect.setRequestProperty("content-type", "text/json");
			else if (paramType.equals("1"))
				connect.setRequestProperty("content-type", "text/xml");
			else {
				connect.setRequestProperty("content-type", "text/html");
			}
			out = new OutputStreamWriter(connect.getOutputStream(), charset);
			out.write(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(connect
					.getInputStream(), charset));
			String line = null;
			StringBuilder content = new StringBuilder();
			while ((line = in.readLine()) != null) {
				content.append(line);
			}
			result = content.toString();
		}catch (ConnectException e) {
			log.error("请求地址： "+requrl + "  访问服务链接超时，原因：" , e);
			return  CommonsUtil.getErrorInfo(paramType,ErrorCode.SYS_CONNECTION_TIME_CODE,"请求链接超时");
		}catch (InterruptedIOException e) {
			log.error("请求地址： "+requrl + "  访问服务读取超时，原因：" , e);
			return  CommonsUtil.getErrorInfo(paramType,ErrorCode.SYS_READ_TIME_CODE,"请求读取超时");
		}catch (Exception e) {
			log.error("请求地址： "+requrl + "  请求转发失败，原因：" , e);
			return   CommonsUtil.getErrorInfo(paramType,ErrorCode.SYS_ERROR_CODE,"请求转发失败");
		} finally {
			if (out != null)
				try {
					out.close();
					out = null;
				} catch (Exception localException4) {
				}
			if (in != null)
				try {
					in.close();
					in = null;
				} catch (Exception localException5) {
				}
			if (connect != null)
				try {
					connect.disconnect();
					connect = null;
				} catch (Exception localException6) {
				}
		}
		return result;
	}
	
	/** 
     * 发送请求. 
     * @param httpsUrl 
     *            请求的地址 
     * @param xmlStr 
     *            请求的数据 
     */  
    public static String sendPost(String httpsUrl, String xmlStr) {  
        HttpsURLConnection urlCon = null;  
        String line = null; 
        try {
            urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();  
            urlCon.setDoInput(true);  
            urlCon.setDoOutput(true);  
            urlCon.setRequestMethod("POST");  
            urlCon.setRequestProperty("Content-Length",  
                    String.valueOf(xmlStr.getBytes().length));  
            urlCon.setUseCaches(false);  
            //设置为gbk可以解决服务器接收时读取的数据中文乱码问题  
            urlCon.getOutputStream().write(xmlStr.getBytes("gbk"));  
            urlCon.getOutputStream().flush();
            urlCon.getOutputStream().close();
            BufferedReader in = new BufferedReader(new InputStreamReader(  
                    urlCon.getInputStream()));  
             
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
                return line;
            }  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
            
        }  
        return line;
    }  
}
