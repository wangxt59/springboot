package com.antke.website.utils;


import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class PictureUtil implements Serializable{
	
	private static final int BUFFER_SIZE = 16 * 2048 ;//缓冲区大小
	private static final String image_Type="jpg,png,PNG,JPG";  //允许上传的文件拓展名
	private static final int image_Length=2048*2048; //上传文件的大小800k

	/**
	 * 拷贝文件
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean copy(File src, File dst)  {
		HttpServletRequest request=ServletActionContext.getRequest();
		
         try  {
            InputStream in = null ;
            OutputStream out = null ;
             try  {
            	 BufferedImage bufferedImage = ImageIO.read(new File(src.getPath()));
            	 int width = bufferedImage.getWidth();
            	 int height=bufferedImage.getHeight();
//            	 mediaItem.setImgSizes(width+"×"+height);//文件尺寸
            	 
            	File f=new File(dst.getParent());
            	if(!f.exists()){
            		f.mkdirs();
            	}
                in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                 byte [] buffer = new byte [BUFFER_SIZE];
                 while (in.read(buffer) > 0 )  {
                    out.write(buffer);
                }
                 try{
                	 int fileSize=Integer.parseInt(dst.length()+"");
//                	 mediaItem.setFilesize(fileSize);//上传文件的大小
                	 if(fileSize>image_Length)//文件大小超出允许范围
                	 {
                		 request.setAttribute("msg", "您上传的文件不能大于"+image_Length/1024+"k");
                		 in.close();
                		 out.close();
                		 dst.delete();
                		 return false; 
                	 }
                 }catch (NumberFormatException e) {
                	 e.printStackTrace();
				}
               
             } finally  {
                 if ( null != in)  {
                    in.close();
                } 
                  if ( null != out)  {
                    out.close();
                } 
            } 
         } catch (Exception e)  {
        	 request.setAttribute("msg", "您上传的图片文件有误，系统不能正常读取！");
        	 e.printStackTrace();
        	 return false;
        } 
         return true;
    } 
	    
	     /**
	      * 图片加水印
	      * @param pressImg 水印图片
	      * @param targetImg 目标图片
	      * @param x
	      * @param y
	      * @param alpha 透明度 0.1-1.0之间的值
	      */
	     public static final boolean waterMark_Image(String pressImg, String targetImg,
	     		int x, int y,float alpha) {
	    	 	boolean flag=true;
	     		try {
	     		//目标文件
	     		float Alpha=alpha;
	     		File _file = new File(targetImg);
	     		Image src = ImageIO.read(_file);
	     		int wideth = src.getWidth(null);
	     		int height = src.getHeight(null);
	     		BufferedImage image = new BufferedImage(wideth, height,
	     		BufferedImage.TYPE_INT_RGB);
	     		Graphics2D g = image.createGraphics();
	     		g.drawImage(src, 0, 0, wideth, height, null);
	     		//水印文件
	     		File _filebiao = new File(pressImg);
	     		Image src_biao = ImageIO.read(_filebiao);
	     		int wideth_biao = src_biao.getWidth(null);
	     		int height_biao = src_biao.getHeight(null);
	     		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
	     		Alpha)); 
	     		g.drawImage(src_biao, x,y, wideth_biao, height_biao, null);
	     		//水印文件结束
	     		g.dispose();
	     		FileOutputStream out = new FileOutputStream(targetImg);
	     		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	     		encoder.encode(image);
	     		out.close();
	     		} catch (Exception e) {
	     			e.printStackTrace();
	        		flag=false;
	     		}finally
	     		{
	     			return flag;
	     		}
	     		}
	     /**
	      * 检查上传的文件是否为允许上传的文件类型
	      * @param String 文件拓展名
	      * @return boolean 是否
	      */
	     public static boolean checkExtName(String extName)
	     {
	    	 boolean flag=false;
	    	 if(extName==null||extName.trim().equals(""))
	    	 {
	    		 return flag;
	    	 }
	    	 if(image_Type.indexOf(extName)!=-1)
	    	 {
	    		 flag=true;
	    	 }
	    	 return flag;
	     }
	     /**
	      * 获取图片的存储目录
	      * @param String modelName 模块名称
	      * @return String  文件在服务器上的存储目录
	      * 规则：当前模块名+年+月+日
	      */
	    public static String getPathByModelName(String modelName)
	    {
	    	if(modelName==null||modelName.trim().equals("")||modelName.trim().equals("null"))
	    	{
	    		return "";
	    	}
	    	Calendar cal=Calendar.getInstance();
	    	return "/"+modelName+"/"+cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+(cal.get(Calendar.DATE))+"/";
	    }
	    /**
	     * 获取随机生成的文件名
	     * @param String 文件名
	     * @return String 随机生成的文件名
	     * 生成规则：系统毫秒+6位随机数+文件拓展名
	     */
	    public static String getRandomFileName(String fileName)
	    {
	    	if(fileName==null||fileName.trim().equals("")||fileName.trim().equals("null"))
	    	{
	    		return "";
	    	}
	    	return System.currentTimeMillis()+(Math.random()+"").substring(12)+fileName.substring(fileName.lastIndexOf("."));
	    }
	    
	    /**
	     * 校验图片尺寸
	     * @param filePath
	     * @return
	     */
	    public static String checkImageSize(String filePath, double fixWidth, double fixHeight){
	    	String message = null;
			try {
				BufferedImage bufferedImage = ImageIO.read(new File(filePath));
				double imageWidth = bufferedImage.getWidth();
				double imageHeight = bufferedImage.getHeight();
				System.out.println("image.width=" + imageWidth + ",image.height=" + imageHeight);
				if(imageWidth != fixWidth || imageHeight != fixHeight){
					message = "图片尺寸必须是：" + (int)fixWidth + "x" + (int)fixHeight + "的图片！";
					System.out.println(message);
					return message;
				}else{
					return message;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return message;
	    }
}
