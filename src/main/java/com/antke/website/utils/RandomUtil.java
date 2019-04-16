package com.antke.website.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtil {

	
	/**
	 * 根据时间  和  5位随机数生成userid
	 * @return
	 */
	public static String getRandomFileName() {  
		  
        SimpleDateFormat simpleDateFormat;  
  
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
  
        Date date = new Date();  
  
        String str = simpleDateFormat.format(date);  
  
        Random random = new Random();  
  
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  
  
        return rannum + str;// 当前时间  
    } 
	
	/**
	 * 根据时间  userphone后4位 和  5位随机数生成flow_no
	 * @return
	 */
	public static String getFlow_no(String userPhone) {  
		  
		String str = userPhone.substring(userPhone.length()-4,userPhone.length());
		
        SimpleDateFormat simpleDateFormat;  
  
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
  
        Date date = new Date();  
  
        String time = simpleDateFormat.format(date);  
  
        Random random = new Random();  
  
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  
  
        return time + str + rannum;// 当前时间  
    } 
	/**
	 * 根据时间 9位随机数生成flow_no
	 * @return
	 */
	public static String getFlow_no() {  
		  
        SimpleDateFormat simpleDateFormat;  
  
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
  
        Date date = new Date();  
  
        String time = simpleDateFormat.format(date);  
  
        Random random = new Random();  
  
        int rannum = (int) (random.nextDouble() * (999999999 - 100000000 + 1)) + 10000;// 获取5位随机数  
  
        return time  + rannum;// 当前时间  
    }
	
	/**
	 *  随机生成8位数字Code
	 * @return
	 */
	public static String getCode_no() {  
		  
        Random random = new Random();  
  
        int rannum = (int) (random.nextDouble() * (99999999 - 10000000 + 1)) + 10000;// 获取5位随机数  
  
        return rannum + "";// 当前时间  
    }
	
	
	public static void main(String[] args){
		String randomFileName = getRandomFileName();
		String flow_no = getCode_no();
		System.out.println(randomFileName);
		System.out.println(getFlow_no());
	}
	
}
