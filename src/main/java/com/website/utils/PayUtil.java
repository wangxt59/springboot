package com.website.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class PayUtil {
	
		private static String driver = "com.mysql.jdbc.Driver";
		private static  String url="jdbc:mysql://rm-2zeu82e43xff77edivo.mysql.rds.aliyuncs.com:3306/fzonline?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
		private static String user="fzonline";
		private static String password="SqGXjBjeK29XyeXo";

//	private static String Key = "AJ0CG2JFBLzQU4Kt0hcSjNjGVw6Rsthd";
//    private static String appid = "wx842e081c56963c08";
//    private static String mch_id = "1497761012";
    
//	private static String Key = "057B07F6A839420C87200D60F728CB81";
//    private static String appid = "wxc4810ddeb1c433c5";
//    private static String mch_id = "1489561552";
	public static Map<String, String> refund(Map<String, String> parameters)
			throws Exception {
		String channel = parameters.get("channel");
		Connection connection = getConnection();
		String sql = "select id,appid,secret,mch_id,plan_id,pay_key,channel,name,create_date,update_date,zh_path from plat_channel where channel = ?";
		PreparedStatement pstat =  connection.prepareStatement(sql);
		pstat.setString(1, channel);
		ResultSet rs = pstat.executeQuery();
		rs.next();
		String keyStorePath  = rs.getString("zh_path");
		String Key = rs.getString("pay_key");
		String appid = rs.getString("appid");
		String mch_id = rs.getString("mch_id");
		// 证书文件(微信商户平台-账户设置-API安全-API证书-下载证书)
//		String keyStorePath = "/Users/cf/Downloads/cert/apiclient_cert.p12";
		
//		String keyStorePath = "/Users/cf/Downloads/apiclient_cert_846311.p12";
//		String keyStorePath  = "/dat/selfFreezer/cert/apiclient_cert.p12";
		
//		String keyStorePath = "/Users/cf/Downloads/hhcert/apiclient_cert.p12";
		// 证书密码（默认为商户ID）
		String password = mch_id;
		// 实例化密钥库
		KeyStore ks = KeyStore.getInstance("PKCS12");  
		// 获得密钥库文件流
		FileInputStream fis = new FileInputStream(keyStorePath);  
		// 加载密钥库
		ks.load(fis, password.toCharArray());
		// 关闭密钥库文件流
		fis.close();
		// 实例化密钥库
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());  
		// 初始化密钥工厂
		kmf.init(ks, password.toCharArray());
		 
		// 创建SSLContext
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());
		// 获取SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		
		String orderTotal = parameters.get("order_total");
		String refundTotal = parameters.get("refund_total");
		String orderTradeNo = parameters.get("order_trade_no");
		String refundTradeNo = parameters.get("refund_trade_no");
		
		String UTF8 = "UTF-8";
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("appid",appid);//appid
        paramMap.put("mch_id",mch_id);//商户号
        paramMap.put("nonce_str",WXPayUtil.generateNonceStr());//随机字符串不超过32位
//        paramMap.put("out_trade_no","T7781120180310153441");//商户订单号
//        paramMap.put("out_refund_no","11111112222223333");//商户退款单号
//        paramMap.put("total_fee","1");//订单金额
//        paramMap.put("refund_fee","1");//退款金额
        
        paramMap.put("out_trade_no",orderTradeNo);//商户订单号
        paramMap.put("out_refund_no",refundTradeNo);//商户退款单号
        paramMap.put("total_fee",orderTotal);//订单金额
        paramMap.put("refund_fee",refundTotal);//退款金额
        
        String sign = WXPayUtil.generateSignature(paramMap,Key);
        System.out.println("sign="+sign);
        paramMap.put("sign",sign);//签名

        String reqBody = WXPayUtil.mapToXml(paramMap);
        URL httpUrl = new URL("https://api.mch.weixin.qq.com/secapi/pay/refund");
        HttpsURLConnection conn = (HttpsURLConnection) httpUrl.openConnection();
        conn.setRequestProperty("Host", "api.mch.weixin.qq.com");
        conn.setSSLSocketFactory(ssf);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(10*1000);
        conn.setReadTimeout(10*1000);
        conn.connect();
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(reqBody.getBytes(UTF8));

        //获取内容
        InputStream inputStream = conn.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF8));
        final StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        String resp = stringBuffer.toString();
        if (stringBuffer!=null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStream!=null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStream!=null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(WXPayUtil.xmlToMap(resp).toString());
		
		return WXPayUtil.xmlToMap(resp);
		
	}
	


	    public static Connection getConnection() {
	        Connection conn=null;
	        try {
	//这两句话会抛异常！
	            Class.forName(driver);    //加载数据库
	            conn=DriverManager.getConnection(url,user,password); //和数据库建立连接


	        } catch(ClassNotFoundException e) {
	            e.printStackTrace(); //异常处理不明白，就按照这么写了
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return conn; //方法要记得返回一个连接对象
	    }

	    public static void main(String[] args) throws SQLException {
	    	String channel = "03";
			Connection connection = getConnection();
			String sql = "select id,appid,secret,mch_id,plan_id,pay_key,channel,name,create_date,update_date,zh_path from plat_channel where channel = ?";
			PreparedStatement pstat =  connection.prepareStatement(sql);
			pstat.setString(1, channel);
			ResultSet rs = pstat.executeQuery();
			rs.next();
			String keyStorePath  = rs.getString("zh_path");
			System.out.println(keyStorePath);
		}
	
}
