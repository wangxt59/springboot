package com.antke.website.utils;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.AbstractTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

/**
 * 推送工具类
 * @author wangmingyi
 *
 */
public class PushMessUtil {
	
	/*
	 * ios推送内部实现类
	 */
	private static class PushMessage_IOS{
		//连接APNS
		private static String host = "gateway.sandbox.push.apple.com";//不改，测试用
	    //String host = "gateway.push.apple.com";
		private static int port = 2195;
//		private static String ClassPath = PushMessage_IOS.class.getClass().getResource("/").getPath();
//		private static String certificatePath = ClassPath.substring(1, ClassPath.indexOf("WEB-INF")) + "pushmessage/util/push.p12";//前面生成的用于JAVA后台连接APNS服务的*.p12文件位置//测试用
		private static String certificatePassword = "casystar";//p12文件密码。不改
	    //推送
	    public static void toPushMessage(int unread_messages_num, String message_content, String token){
	    	try{
	    		String certificatePath = FileUtil.getProperty("ios_Push_Certificate");
	    		String deviceToken = token;
	    	 //从客户端获取的deviceToken，在此为了测试简单，写固定的一个测试设备标识。
	            System.out.println("Push Start deviceToken:" + deviceToken);
	            //定义消息模式
	            PayLoad payLoad = new PayLoad();
	            payLoad.addAlert(message_content);
	            payLoad.addBadge(unread_messages_num);//消息推送标记数，小红圈中显示的数字。
	            payLoad.addSound("default");
	            //注册deviceToken
	            PushNotificationManager pushManager = PushNotificationManager.getInstance();
	            pushManager.addDevice("iPhone", deviceToken);
	            //连接APNS
	            pushManager.initializeConnection(host, port, certificatePath, certificatePassword, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
	            //发送推送
	            Device client = pushManager.getDevice("iPhone");
	            System.out.println("推送消息: " + client.getToken()+"\n"+payLoad.toString() +" ");
	            pushManager.sendNotification(client, payLoad);
	            //停止连接APNS
	            pushManager.stopConnection();
	            //删除deviceToken
	            pushManager.removeDevice("iPhone");
	            System.out.println("Push End");
	        }catch (Exception ex){
	            ex.printStackTrace();
	        }

	    }
	}
	
	/*
	 * Android推送内部实现类
	 */
	private static class PushMessage_Android{
//		private static String appId = "muafzLF8hv8T4Q24RDOgi5";
		private static String appId = "CsnaxqEVxg7m8r9hkOJcz";
		private static String appkey = "C4BdMzheEI9tUokT9Sfdx5";
		private static String master = "CGMvE3ZAyb9g2KsVukQd8";
//		private static String CID = "41949df192ea725a42016a0e81851fa9";
		private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

		// 点击通知启动应用
		public static NotificationTemplate NotificationTemplateDemo(String message_content, String message_title) {
			NotificationTemplate template = new NotificationTemplate();
			// 设置APPID与APPKEY
			template.setAppId(appId);
			template.setAppkey(appkey);
			// 设置通知栏标题与内容
			template.setTitle(message_title);
			template.setText(message_title);
			// 配置通知栏图标
			template.setLogo("icon.png");
			// 配置通知栏网络图标
			template.setLogoUrl("");
			// 设置通知是否响铃，震动，或者可清除
			template.setIsRing(true);
			template.setIsVibrate(true);
			template.setIsClearable(true);
			// 透传消息设置
			template.setTransmissionType(1);
			template.setTransmissionContent(message_content);
			return template;
		}
		// 透传（payload）
		public static TransmissionTemplate TransmissionTemplateDemo(String message_content) {
			TransmissionTemplate template = new TransmissionTemplate();
			template.setAppId(appId);
			template.setAppkey(appkey);
			template.setTransmissionType(1);
			template.setTransmissionContent(message_content);
			return template;
		}
		//推送
		public static void toPushMessage(AbstractTemplate template, String token){
			try{
				IGtPush push = new IGtPush(url, appkey, master);
				push.connect();
				
				SingleMessage message = new SingleMessage();
				message.setOffline(true);
				// 离线有效时间，单位为毫秒，可选
				message.setOfflineExpireTime(24 * 3600 * 1000);
				message.setData(template);
				
				Target target1 = new Target();
				
				target1.setAppId(appId);
				target1.setClientId(token);
				
				IPushResult ret = push.pushMessageToSingle(message, target1);
				System.out.println(ret.getResponse().toString());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 推送方法
	 * @param unread_messages_num 未读消息数（初始：0）
	 * @param terminal 终端类型(0：ios、1：android）
	 * @param token 推送令牌
	 * @param message_title 消息标题
	 * @param message_content 消息内容
	 */
	public static void toPushMessage_all(int unread_messages_num, int terminal, String token, String message_title, String message_content){
		/*IOS消息推送*/
		if(0 == terminal){
			PushMessage_IOS.toPushMessage(unread_messages_num, message_content, token);
		}
		/*Android消息推送*/
		else if(1 == terminal){
			TransmissionTemplate transmissionTemplate = PushMessage_Android.TransmissionTemplateDemo(message_content);//透传（payload）
			PushMessage_Android.toPushMessage(transmissionTemplate, token);
			NotificationTemplate notificationTemplate = PushMessage_Android.NotificationTemplateDemo(message_content, message_title);//点击通知启动应用
			PushMessage_Android.toPushMessage(notificationTemplate, token);
		}
	}
	
	
//	public static void main(String[] args) throws Exception {
////		PushMessage_IOS.toPushMessage(1, "test", "cc379440 e3f545ea 5af9a252 d48ec535 f7fbf256 59948");
//		String token2 = "cc379440 e3f545ea 5af9a252 d48ec535 f7fbf256 59948";
//    	try{
//    		 //从客户端获取的deviceToken，在此为了测试简单，写固定的一个测试设备标识。
//            String deviceToken = "cc379440 e3f545ea 5af9a252 d48ec535 f7fbf256 59948c09 e4aa6419 19ef80dd";//
//             System.out.println("Push Start deviceToken:" + deviceToken);
//             //定义消息模式
//             PayLoad payLoad = new PayLoad();
//             payLoad.addAlert("推送成功!");//
//             payLoad.addBadge(1);//消息推送标记数，小红圈中显示的数字。
//             payLoad.addSound("default");//不改
//             //注册deviceToken
//             PushNotificationManager pushManager = PushNotificationManager.getInstance();
//             pushManager.addDevice("iPhone", deviceToken);//不改
//             //连接APNS
//             String host = "gateway.sandbox.push.apple.com";//不改，测试用
//             //String host = "gateway.push.apple.com";
//             int port = 2195;
//             String certificatePath = "D:\\Workspace\\TestPush\\src\\bin\\push.p12";//前面生成的用于JAVA后台连接APNS服务的*.p12文件位置//测试用
//             String certificatePassword = "casystar";//p12文件密码。不改
//             pushManager.initializeConnection(host, port, certificatePath, certificatePassword, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
//             //发送推送
//             Device client = pushManager.getDevice("iPhone");
//             System.out.println("推送消息: " + client.getToken()+"\n"+payLoad.toString() +" ");
//             pushManager.sendNotification(client, payLoad);
//             //停止连接APNS
//             pushManager.stopConnection();
//             //删除deviceToken
//             pushManager.removeDevice("iPhone");
//             System.out.println("Push End");
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//	}
	
}


