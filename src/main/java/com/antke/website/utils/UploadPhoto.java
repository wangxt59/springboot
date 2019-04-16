package com.antke.website.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * upload photo from qiniu
 */
public class UploadPhoto {
	/**
	 * 根据链接地址找到七牛上相应文件，进行下载，如：
	 * http://rongcloud-image.ronghub.com/image_jpeg__RC-2017-03-01_946_1488362231609?
	 * e=2147483647&token=EcrrKW5AbOMQaDRwc3ReDNvo3-sL_SO1fSUBKV3H:0VT5Cx7suD6uKNcuqVGsa84mq1M
	 * @param fileUrl
	 * @return
	 */
	public static String uploadQianURL(String fileUrl) {
        //获取文件名，文件名实际上在URL中可以找到
//      String fileName = fileUrl.substring(fileUrl.lastIndexOf("/"), fileUrl.indexOf("?")) + ".jpg";
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/")) + ".jpg";
        //这里服务器上要将此图保存的路径
        String savePath = "E:\\photos\\";
        try {
            URL url = new URL(fileUrl);/*将网络资源地址传给,即赋值给url*/
            /*此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流*/
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            /*此处也可用BufferedInputStream与BufferedOutputStream*/
            DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath+fileName));
            /*将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址*/
            byte[] buffer = new byte[4096];
            int count = 0;
            /*将输入流以字节的形式读取并写入buffer中*/
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            out.close();/*后面三行为关闭输入输出流以及网络资源的固定格式*/
            in.close();
            connection.disconnect();
            //返回内容是保存后的完整的URL
            return savePath+fileName;/*网络资源截取并存储本地成功返回true*/

        } catch (Exception e) {
            System.out.println(e + fileUrl + savePath);
            e.printStackTrace();
            return null;
        }
    }

	
}
