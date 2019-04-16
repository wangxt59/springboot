package com.antke.website.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class qiniuUtil {

	static String accessKey = FileUtil.getProperty("qn_accessKey");
	static String secretKey = FileUtil.getProperty("qn_secretKey");
	static String bucket = FileUtil.getProperty("qn_bucket");
	static String path=FileUtil.getProperty("qn_path");
	
	public static Map upload(byte[] bs) throws JSONException{
	
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		
		//如果是Windows情况下，格式是 D:\\qiniu\\test.png
		//String localFilePath = "D:\\pro_1.jpg";
		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String key =UUID.randomUUID().toString();
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		String returnPath="";
		try {
		    Response response = uploadManager.put(bs, key, upToken);
		    //解析上传成功的结果
		    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		    System.out.println(putRet.key);
		    System.out.println(putRet.hash);
		    System.out.println(response.bodyString());
		    System.out.println(key);
		    returnPath=handleUrl(path)+key;
		} catch (QiniuException ex) {
		    Response r = ex.response;
		    System.err.println(r.toString());
		    try {
		        System.err.println(r.bodyString());
		    } catch (QiniuException ex2) {
		        //ignore
		    }
		}
		
		String is_open=FileUtil.getProperty("is_open");//1:开启
		if(is_open!=null && is_open.equals("1")){
			//鉴暴
			String violence=violence(path+key);//label 0正常；1暴恐。
			System.out.println("violence="+violence);
			if(violence!=null && violence.equals("1"))
			{
				returnMap.put("qualified", "2");//是否合格   1：是   2：否
				//替换图片路径
				//returnMap.put("image_url",path+"77ffac39-39c7-4518-8e30-981d9d85d2f0");
				returnMap.put("image_url","");
				return returnMap;
			}
			//鉴黄
			String yellow = yellow(path+key);//0色情；1性感；2正常。
			System.out.println("yellow="+yellow);
			if(yellow !=null){
				if(yellow.equals("0") || yellow.equals("1"))
				{
					returnMap.put("qualified", "2");//是否合格   1：是   2：否
					//替换图片路径
					//returnMap.put("image_url",path+"77ffac39-39c7-4518-8e30-981d9d85d2f0");
					returnMap.put("image_url","");
					return returnMap;
				}
				
			}
			
			
			
		}
		//returnMap.put("image_url", path+key+"!g1");
		returnMap.put("image_url", path+key);
		returnMap.put("qualified", "1");//是否合格   1：是   2：否
		return returnMap;
	}
	//鉴暴
	public static String violence(String url) throws JSONException{
		String jsonstr=sendGet(url,"terror");
		System.out.println("jsonstr="+jsonstr);
	    JSONObject obj = new JSONObject(jsonstr.toString());  
	    JSONArray obj2 = obj.getJSONArray("fileList");  
		JSONObject resultObj = obj2.optJSONObject(0);
		String label = resultObj.getString("label");//0:正常   1：暴恐
		System.out.println(label);
		
		return label;
	}
	//鉴黄
	public static String yellow(String url)throws JSONException{
		String jsonstr=sendGet(url,"pulp");
		System.out.println("jsonstr="+jsonstr);
		JSONObject obj = new JSONObject(jsonstr.toString());  
	    //JSONArray obj2 = obj.getJSONArray("pulp");  
		String object = obj.getString("pulp");// 0色情；1性感；2正常。
		String[] label=object.split(",");
		System.out.println(label[1]);
		
		return label[1];
	}
	
	
	//发送请求
	public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Host",path);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	
	private static String handleUrl(String url) {

	    String result = url;

	    int beginIndex = result.indexOf("//");
	    if (beginIndex != -1) {
	        int endIndex = result.indexOf("/", beginIndex + 2);
	        if (endIndex == -1) {
	            int questionIndex = result.indexOf("?");
	            if(questionIndex==-1){
	                result += "/";
	            }else {
	                result = result.replaceFirst("/?[?]", "/?");
	            }
	        }
	    }
	    return result;
	}
	
}
