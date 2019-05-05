package com.website.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

//import net.sf.json.JSONObject;


 


/**
 * Created by 74750 on 2018/3/28.
 */

public class BaiduMapUtil {
    static final double DEF_PI = 3.14159265359; // PI
    static final double DEF_2PI= 6.28318530712; // 2*PI
    static final double DEF_PI180= 0.01745329252; // PI/180.0
    static final double DEF_R =6370693.5; // radius of earth

    /**
     * 求两坐标点距离
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static double GetDistance
    (double lon1, double lat1, double lon2, double lat2)
    {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > DEF_PI)
            dew = DEF_2PI - dew;
        else if (dew < -DEF_PI)
            dew = DEF_2PI + dew;
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
        // 勾股定理求斜边长
        distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    public static ArrayList<String> getGeocoderLatitude(String address){  
        BufferedReader in = null;  
        ArrayList<String>  array = new ArrayList<String> ();
        try {  
            address = URLEncoder.encode(address, "UTF-8");  
            URL tirc = new URL("http://api.map.baidu.com/geocoder?address="+ address +"&output=json&key="+"7d9fbeb43e975cd1e9477a7e5d5e192a");  
            in = new BufferedReader(new InputStreamReader(tirc.openStream(),"UTF-8"));  
            String res;  
            StringBuilder sb = new StringBuilder("");  
            while((res = in.readLine())!=null){  
                sb.append(res.trim());  
            }  
            String str = sb.toString();  
            if(str != null && !str.equals("")){  
                int lngStart = str.indexOf("lng\":");  
                int lngEnd = str.indexOf(",\"lat");  
                int latEnd = str.indexOf("},\"precise");  
                if(lngStart > 0 && lngEnd > 0 && latEnd > 0){  
                    String lng = str.substring(lngStart+5, lngEnd);//经度
                    String lat = str.substring(lngEnd+7, latEnd);//纬度
                    //添加到集合中
                    array.add(lng);
                    array.add(lat);
                }  
            }  
        }catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                in.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
		return array;  
    } 
    
    //通过经纬度获取地址
    public static String getAddressWithMap(String lng, String lat){
    	String address = null;
    	try {
			JSONObject obj = BaiduMapUtil.getAddress(lng, lat, "nLpN5iKztxIWsPqgwsyrruUG");
			if (obj != null) {
				String province = obj.getJSONObject("result").getJSONObject("addressComponent").getString("province");
				String city = obj.getJSONObject("result").getJSONObject("addressComponent").getString("city");
				String district = obj.getJSONObject("result").getJSONObject("addressComponent").getString("district");
				String description = obj.getJSONObject("result").getJSONArray("poiRegions").getJSONObject(0).getString("name");
				address = province+city+district+description;
				//System.out.println(province+city+district+description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
    }
    
    /**
	 * 根据参数将非百度坐标转换为百度坐标，供getAddress方法使用
	 */
	public static JSONObject getAddress(String longitude, String latitude, String ak) throws Exception {
		URL url = new URL("http://api.map.baidu.com/geocoder/v2/?ak=" + ak
				+ "&location=" + latitude + "," + longitude + "&output=json");

		JSONObject object = getJSONObjectByUrl(url);

		// 返回的json串格式
		// {"status":0,"result":{"location":{"lng":96.32298699999997,"lat":39.98342407140365},"formatted_address":"甘肃省酒泉市瓜州县","business":"","addressComponent":{"country":"中国","country_code":0,"province":"甘肃省","city":"酒泉市","district":"瓜州县","adcode":"620922","street":"","street_number":"","direction":"","distance":""},"pois":[],"poiRegions":[],"sematic_description":"","cityCode":37}}
		return object;
	}

	/**
	 * 根据不同的url获取不同的json串
	 * 
	 * @param url
	 */
	public static JSONObject getJSONObjectByUrl(URL url) throws Exception {

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.addRequestProperty("User-Agent", "Mozilla/4.0");
		/**
		 * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
		 * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
		 */
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.addRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		OutputStreamWriter out = new OutputStreamWriter(connection
				.getOutputStream(), "utf-8");
		out.flush();
		out.close();
		// 一旦发送成功，用以下方法就可以得到服务器的回应：
		String res;
		InputStream l_urlStream;
		l_urlStream = connection.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				l_urlStream, "UTF-8"));
		StringBuilder sb = new StringBuilder("");
		while ((res = in.readLine()) != null) {
			sb.append(res.trim());
		}
		String str = sb.toString();
		JSONObject obj = null;
		// StringUtils.isBlank(str)判断转化后的str是否为空字符串
		if (!StringUtils.isBlank(str)) {
			obj = JSONObject.parseObject(str);
		}
		return obj;
	}

	/**
	 * 根据参数将非百度坐标转换为百度坐标，供getAddress方法使用
	 */
	public static JSONObject convertCoordinate(String longitude,
			String latitude, String ak)
			throws Exception {

		URL url = new URL("http://api.map.baidu.com/geoconv/v1/?coords="
				+ longitude + "," + latitude + "&from=1&to=5&ak=" + ak);
		JSONObject object = getJSONObjectByUrl(url);
		return object;
	}
}
