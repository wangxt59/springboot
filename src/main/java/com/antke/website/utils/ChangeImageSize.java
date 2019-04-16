package com.antke.website.utils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片放大，缩小，剪切的控制类
 * 
 * @author bizf
 * 
 */
public class ChangeImageSize {

	/**
	 * 图片的缩放
	 * 
	 * @param _srcImageFile
	 *            原图片路径
	 * @param _resultImageFile
	 *            改变后图片的路径
	 * @param _scale
	 *            放大缩小的倍数
	 * @param _flag
	 *            放大或者缩小， true为放大，false为缩小
	 */
	public static void scale(String _srcImageFile, String _resultImageFile, int _scale, boolean _flag) {
		try {
			BufferedImage src = ImageIO.read(new File(_srcImageFile)); // 读入文件
			int width = src.getWidth(); // 得到源图宽
			int height = src.getHeight(); // 得到源图长
			if (_flag) {
				// 放大
				width = width * _scale;
				height = height * _scale;
			} else {
				// 缩小
				width = width / _scale;
				height = height / _scale;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "JPEG", new File(_resultImageFile));// 输出到文件流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按固定尺寸放大或者缩小
	 * 
	 * @param srcImageFile
	 * @param resultImageFile
	 * @param _changeWidth
	 * @param _changeHeight
	 */
	public static void scaleByFastnesses(String _srcImageFile, String _resultImageFile, int _changeWidth, int _changeHeight) {
		try {
			BufferedImage src = ImageIO.read(new File(_srcImageFile)); // 读入文件
			int width = src.getWidth(); // 得到源图宽
			int height = src.getHeight(); // 得到源图长

			width = _changeWidth;
			height = _changeHeight;

			Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, "JPEG", new File(_resultImageFile));// 输出到文件流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 切图
	 * 
	 * @param _srcImageFile
	 *            原始路径图片
	 * @param _resultImageFile
	 *            切完后路径的图片
	 * @param _destWidth
	 *            按多少宽度切
	 * @param _destHeight
	 *            按多少高度切
	 */
	public static void cut(String _srcImageFile, String _resultImageFile, int _destWidth, int _destHeight) {
		try {
			Image img;
			ImageFilter cropFilter;
			// 读取源图像
			BufferedImage bi = ImageIO.read(new File(_srcImageFile));
			int srcWidth = bi.getWidth(); // 源图宽度
			int srcHeight = bi.getHeight(); // 源图高度
			if (srcWidth >= _destWidth && srcHeight >= _destHeight) {
				Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
				int cols = 0; // 切片横向数量
				int rows = 0; // 切片纵向数量
				// 计算切片的横向和纵向数量
				if (srcWidth % _destWidth == 0) {
					cols = srcWidth / _destWidth;
				} else {
					cols = (int) Math.floor(srcWidth / _destWidth) + 1;
				}
				if (srcHeight % _destHeight == 0) {
					rows = srcHeight / _destHeight;
				} else {
					rows = (int) Math.floor(srcHeight / _destHeight) + 1;
				}
				// 循环建立切片
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						// 四个参数分别为图像起点坐标和宽高
						cropFilter = new CropImageFilter(j * _destWidth, i * _destHeight, _destWidth, _destHeight);
						img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
						BufferedImage tag = new BufferedImage(_destWidth, _destHeight, BufferedImage.TYPE_INT_RGB);
						Graphics g = tag.getGraphics();
						g.drawImage(img, 0, 0, null); // 绘制缩小后的图
						g.dispose();
						// 输出为文件
						ImageIO.write(tag, "JPEG", new File(_resultImageFile + "w" + i + "_h" + j + ".jpg"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 切图
	 * 
	 * @param _srcImageFile
	 *            原始路径图片
	 * @param _resultImageFile
	 *            切完后路径的图片
	 * @param _destWidth
	 *            按多少宽度切
	 * @param _destHeight
	 *            按多少高度切
	 * @param _X
	 *            按横坐标多少切
	 * @param _Y
	 *            按纵坐标多少切
	 */
	public static void cutByXYPoint(String _srcImageFile, String _resultImageFile, int _X, int _Y, int _destWidth, int _destHeight) {
		try {
			Image img;
			ImageFilter cropFilter;
			// 读取源图像
			BufferedImage bi = ImageIO.read(new File(_srcImageFile));
			int srcWidth = bi.getWidth(); // 源图宽度
			int srcHeight = bi.getHeight(); // 源图高度
			if (srcWidth >= _destWidth && srcHeight >= _destHeight) {
				Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);

				// 四个参数分别为图像起点坐标和宽高
				cropFilter = new CropImageFilter(_X, _Y, _destWidth, _destHeight);
				img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage tag = new BufferedImage(_destWidth, _destHeight, BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(img, 0, 0, null); // 绘制缩小后的图
				g.dispose();
				// 输出为文件
				ImageIO.write(tag, "JPEG", new File(_resultImageFile));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 图像 类型转换
	 * 
	 * @param _sourceImageFile
	 *            原始路径文件
	 * @param _resultImageFile
	 *            生成后路径文件
	 * @param _imageType
	 *            可为（JPEG,GIF,PNG）
	 */
	public static void convert(String _sourceImageFile, String _resultImageFile, String _imageType) {
		try {
			File f = new File(_sourceImageFile);
			f.canRead();
			f.canWrite();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, _imageType, new File(_resultImageFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 彩色转为黑白
	 * 
	 * @param _sourceImageFile
	 *            原始路径文件
	 * @param _resultImageFile
	 *            生成后路径文件
	 */
	public static void gray(String _sourceImageFile, String _resultImageFile) {
		try {
			BufferedImage src = ImageIO.read(new File(_sourceImageFile));
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			src = op.filter(src, null);
			ImageIO.write(src, "JPEG", new File(_resultImageFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static ArrayList filelist = new ArrayList(); 

	public static void refreshFileList(String strPath) { 

	File dir = new File(strPath); 

	File[] files = dir.listFiles(); 

	if (files == null) 

	return; 

	for (int i = 0; i < files.length; i++) { 

	if (files[i].isDirectory()) { 

	refreshFileList(files[i].getAbsolutePath()); 

	} else { 

	String strFileName = files[i].getAbsolutePath().toLowerCase();//包括路径的文件名
	long filesize = files[i].length()/1024;
	System.out.println("size==="+files[i].length()/1024);
//	String filename=files[i].getName();//包括后缀名的文件名
	int f1 = strFileName.indexOf(".");
	String f2 = strFileName.substring(0, f1);//去掉后缀名的文件名
	System.out.println("---"+strFileName);
//	System.out.println("==="+files[i].getName()); 
	System.out.println("f2==="+f2); 
	if(filesize>20){
//		cutByXYPoint(strFileName, f2+"-350350.jpg", 100,0,350,350);//左右各切割100，大小为350*350
//		reduceImg(strFileName,f2+"-350220.jpg",350,220);//350*220  进行等比例缩放
//		reduceImg(strFileName,f2+"-8554.jpg",85,54);//85*54 进行等比例缩放
//		
//		reduceImg(f2+"-350350.jpg",f2+"-6060.jpg",60,60);//60*60 方图等比例缩放
		
		ChangeImageSize.reduceImg(strFileName,f2.replaceAll("ics", "wtcf")+"-166166.jpg",166,166);//166*166方图等比例缩放
    	ChangeImageSize.reduceImg(strFileName,f2.replaceAll("ics", "wtcf")+"-640320.jpg",640,320);//600*470  进行等比例缩放
    	
	}
	
	
	filelist.add(files[i].getAbsolutePath()); 
	} 
	} 
	}

	
	/**
	 * 缩小图片第二版
	 * @param imgsrc
	 * @param imgdist
	 * @param widthdist
	 * @param heightdist
	 */
	public static void reduceImg(String imgsrc, String imgdist, int widthdist,         
	        int heightdist) {         
	    try {         
	        File srcfile = new File(imgsrc);         
	        if (!srcfile.exists()) {         
	            return;         
	        }         
	        Image src = javax.imageio.ImageIO.read(srcfile);         
	        
	        BufferedImage tag= new BufferedImage((int) widthdist, (int) heightdist,         
	                BufferedImage.TYPE_INT_RGB);         
	        
	        tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist,  Image.SCALE_SMOOTH), 0, 0,  null);         
//	        tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist,  Image.SCALE_AREA_AVERAGING), 0, 0,  null);         
	                 
	        FileOutputStream out = new FileOutputStream(imgdist);         
	        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);         
	        encoder.encode(tag);         
	        out.close();         
	        
	    } catch (IOException ex) {         
	        ex.printStackTrace();         
	    }         
	}      
	
	/**
	 * 图片缩小第三版
	 * @param inputFile
	 * @param outputPicName
	 * @param max
	 */
	public static void zoomPicture(File inputFile, String outputPicName,
		    double max) {
		   double maxLimit = max;
		   double ratio = 1.0;
		   try {
		    BufferedImage Bi = ImageIO.read(inputFile);
		    if ((Bi.getWidth() > maxLimit)) {
		     ratio = maxLimit / Bi.getWidth();
		    }
		    int widthdist = (int) Math.floor(Bi.getWidth() * ratio), heightdist = (int) Math
		      .floor(Bi.getHeight() * ratio);
		    BufferedImage tag = new BufferedImage(widthdist, heightdist,
		      BufferedImage.TYPE_INT_RGB);
		    tag.getGraphics().drawImage(
		      Bi.getScaledInstance(widthdist, heightdist,
		        BufferedImage.SCALE_SMOOTH), 0, 0, null);
		    File littleFile = new File(outputPicName);
		    ImageIO.write(tag, "JPEG", littleFile);
		   } catch (Exception ex) {
		    ex.printStackTrace();
		   }
		}


	
	public static BufferedImage createZoomSizeImage(Image image, Component comp, int width, int height) {

		BufferedImage bimg = null;
		AreaAveragingScaleFilter filter = new AreaAveragingScaleFilter(width, height);
		FilteredImageSource producer = new FilteredImageSource(image.getSource(), filter);
		bimg = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		Graphics graphics = bimg.createGraphics();
		graphics.drawImage(comp.createImage(producer), 0, 0, null);
		return bimg;
	}

	public static void main(String[] args) {
		System.out.println("test begin!");
		String _srcImageFile = "E:\\test.png";
		String _resultImageFile = "E:\\test.png";
		int _scale = 2;
		
		scale(_srcImageFile, _resultImageFile, _scale, true);
		System.out.println("test end!");
	}
}
