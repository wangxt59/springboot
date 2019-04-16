package com.antke.website.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DateUtil {

	
	/**
	 * 返回两个日期相差 小时
	 * 
	 * @param _date1
	 * @param _date2 大的时间
	 * long[] ACCURAY = {24L * 60L * 60L * 1000L, 60L * 60L * 1000L, 60L * 1000L, 1000L, 1L};
	 * 0:day 1 hour 2：分 3：秒 4：毫秒
	 * @return
	 */													
	public static int getDateDifference(Date d1, Date d2,int accuray) {
		long dayNumber = 0;
		long[] ACCURAY = {24L * 60L * 60L * 1000L, 60L * 60L * 1000L, 60L * 1000L, 1000L, 1L};
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dayNumber = (d2.getTime() - d1.getTime()) / ACCURAY[accuray];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer.parseInt("" + dayNumber) + 1);

	}
	/**
	 * 返回两个日期相差 小时
	 * 
	 * @param _date1
	 * @param _date2 大的时间
	 * long[] ACCURAY = {24L * 60L * 60L * 1000L, 60L * 60L * 1000L, 60L * 1000L, 1000L, 1L};
	 * 0:day 1 hour 2：分 3：秒 4：毫秒
	 * @return
	 */													
	public static int getDateDifference2(Date d1, Date d2,int accuray) {
		long dayNumber = 0;
		long[] ACCURAY = {24L * 60L * 60L * 1000L, 60L * 60L * 1000L, 60L * 1000L, 1000L, 1L};
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dayNumber = (d2.getTime() - d1.getTime()) / ACCURAY[accuray];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer.parseInt("" + dayNumber) + 1);

	}
	
	public static Date format(String format) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			date = sdf.parse(format);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/*
	 * 取得当前时间的字符串形式yyyyMMddHHmmss
	 */
	public static String getCurrTime() {
		return format(new Date(), "yyyyMMddHHmmss");
	}
	
	/*
	 * 转换日期为指定格式的字符串
	 */
	public static String format(Date d) {
		if (d == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(d);
		//        sdf.applyPattern("yyyy-MM-dd");
		return s;
	}
	public static String allformat(Date d) {
		if (d == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String s = sdf.format(d);
		//        sdf.applyPattern("yyyy-MM-dd");
		return s;
	}
	/*
	 * 转换日期为指定格式的字符串

	 * 用例：format(new Now(), "yyyy-MM-dd")
	 *      format(new Now(), "yyyy-MM")
	 */
	public static String format(Date d, String format) {
		if (d == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.applyPattern(format);
		String s = sdf.format(d);
		//        sdf.applyPattern("yyyy-MM-dd");
		return s;
	}

	/**
	 * Description：生成时间戳
	 * @return
	 */
	public static String getTimeStamp() {
		SimpleDateFormat sdfTS = new SimpleDateFormat("yyMMddHHmmss");
		return sdfTS.format(new Date());
	}

	/**
	 * Description：生成时间戳
	 * @return
	 */
	public static String getDayStamp() {
		SimpleDateFormat sdfTS = new SimpleDateFormat("yyyyMMdd");
		return sdfTS.format(new Date());
	}
	
	/**
	 * Description：生成时间戳
	 * @return
	 */
	public static String formatToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newDate = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			Date d1 = sdf.parse(date);
			newDate = df.format(d1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDate;
	}

	/**
	 * Description：将格式yyyy-MM-dd HH:mm:ss 转换成为yyyyMMddHHmmss
	 * @return
	 * @throws ParseException 
	 */
	public static String formatToDateStr(String date) throws ParseException {
		String newDate = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = sdf.parse(date);
		newDate = df.format(d1);
		return newDate;
	}
	

	/**
	 * 当前系统时间
	 */
	public static Date getSysDate() {
		return new Date();
	}

	/*
	 * 取得当前时间的字符串形式yyyy-MM-dd HH:mm:ss
	 */
	public static String getSysTime() {
		return format(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/*
	 * 取得当前时间的字符串形式yyyy-MM-dd
	 */
	public static String getFormatDate() {
		return format(new Date(), "yyyy-MM-dd");
	}
	
	/**
	 * 返回几点几分
	 * 
	 * @return
	 */
	public static String getHourTime() {
		DateFormat format = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		String time = format.format(cal.getTime());
		return time;

	}

	/**
	 * 返回今天
	 * 
	 * @return
	 */
	public static String getToday() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String time = format.format(cal.getTime());

		return time;

	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 字符串转换成时间
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToTime(String str) {

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date StrToAllDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 通过日期算周几
	 * 
	 * @param dt
	 * @return
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);

		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];

	}

	public static String getStarLvById(String starlv_id) {
		if ("40".equals(starlv_id)) {
			return "一星";
		} else if ("41".equals(starlv_id)) {
			return "二星";
		} else if ("42".equals(starlv_id)) {
			return "三星";
		} else if ("43".equals(starlv_id)) {
			return "四星";
		} else if ("44".equals(starlv_id)) {
			return "五星";
		} else if ("46".equals(starlv_id)) {
			return "五星";
		} else {
			return "无";
		}
	}

	/**
	 * 比较两个时间
	 * 
	 * @param _time
	 * @param _type
	 * @return
	 */
	public static boolean getIsTimeBeforeSysdate(String _time, String _type) {

		if (_type.equals("大于")) {
			if (((StrToTime(getCurrTime()).getTime()) - (StrToTime(_time).getTime())) > 0) {
				return true;
			} else {
				return false;
			}

		} else if (_type.equals("小于")) {
			if (((StrToTime(getCurrTime()).getTime()) - (StrToTime(_time).getTime())) < 0) {
				return true;
			} else {
				return false;
			}

		}
		return false;

	}

	public static boolean getIsTimeBeforeOtherTime(String _time, String _time2, String _type) {

		if (_type.equals("大于")) {
			if ((StrToTime(_time2).getTime()) - (StrToTime(_time).getTime()) > 0) {
				return true;
			} else {
				return false;
			}

		} else if (_type.equals("小于")) {
			if ((StrToTime(_time2).getTime()) - (StrToTime(_time).getTime()) < 0) {
				return true;
			} else {
				return false;
			}

		}
		return false;

	}
	
	public static boolean getIsTimeBeforeOtherTime(String _time, String _time2) {

		if ((StrToTime(_time2).getTime()) - (StrToTime(_time).getTime()) > 0) {
			return true;
		} else {
			return false;
		}
	}
	

	/**
	 * 返回当前日期返回本周的周一的日期
	 * 
	 * @param _date1
	 * @return
	 */
	public static String getDateWeekBefore(String _date1) {
		if ("星期日".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, -6);
		} else if ("星期六".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, -5);
		} else if ("星期五".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, -4);
		} else if ("星期四".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, -3);
		} else if ("星期三".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, -2);
		} else if ("星期二".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, -1);
		} else if ("星期一".equals(getWeekOfDate(StrToDate(_date1)))) {
			return _date1;
		}

		return _date1;

	}

	/**
	 * 返回当前日期返回本周的周日的日期
	 * 
	 * @param _date1
	 * @return
	 */
	public static String getDateWeekAfter(String _date1) {
		if ("星期日".equals(getWeekOfDate(StrToDate(_date1)))) {
			return _date1;
		} else if ("星期六".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, 1);
		} else if ("星期五".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, 2);
		} else if ("星期四".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, 3);
		} else if ("星期三".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, 4);
		} else if ("星期二".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, 5);
		} else if ("星期一".equals(getWeekOfDate(StrToDate(_date1)))) {
			return getDaysOper(_date1, 6);
		}

		return _date1;

	}

	/**
	 * 返回日期增加或者减少
	 * 
	 * @param _date1
	 * @return
	 */
	public static String getDaysOper(String _date1, int _days) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String[] date1s = _date1.split("-");
		calendar.set(Integer.parseInt(date1s[0]), Integer.parseInt(date1s[1]) - 1, Integer.parseInt(date1s[2]));
		calendar.add(Calendar.DAY_OF_MONTH, _days);
		return format.format(calendar.getTime());

	}

	/**
	 * 返回日期递增
	 * 
	 * @param _date1
	 * @return
	 */
	public static String getDaysAdd(String _date1) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String[] date1s = _date1.split("-");
		calendar.set(Integer.parseInt(date1s[0]), Integer.parseInt(date1s[1]) - 1, Integer.parseInt(date1s[2]));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return format.format(calendar.getTime());

	}
	
	public static String getWeekendDefine(String _str) {
		StringBuffer sb_week = new StringBuffer();
		if (_str == null || "".equals(_str)) {
			return "";
		} else {
			if ("1".equals("" + _str.charAt(0))) {
				sb_week.append("星期一");
				sb_week.append(",");
			}
			if ("1".equals("" + _str.charAt(1))) {
				sb_week.append("星期二");
				sb_week.append(",");
			}
			if ("1".equals("" + _str.charAt(2))) {
				sb_week.append("星期三");
				sb_week.append(",");
			}
			if ("1".equals("" + _str.charAt(3))) {
				sb_week.append("星期四");
				sb_week.append(",");
			}
			if ("1".equals("" + _str.charAt(4))) {
				sb_week.append("星期五");
				sb_week.append(",");
			}
			if ("1".equals("" + _str.charAt(5))) {
				sb_week.append("星期六");
				sb_week.append(",");
			}
			if ("1".equals("" + _str.charAt(6))) {
				sb_week.append("星期日");
				sb_week.append(",");
			}
			return sb_week.toString();
		}
	}
	
	/**
	 * 把字符串转换为时间
	 * 
	 * @param _parm
	 * @return
	 */
	public static String replaceTimeFromStr(String _parm) {
		if ("0".equals(_parm)) {
			return "00:00";
		} else if ("1".equals(_parm)) {
			return "01:00";
		} else if ("2".equals(_parm)) {
			return "02:00";
		} else if ("3".equals(_parm)) {
			return "03:00";
		} else if ("4".equals(_parm)) {
			return "04:00";
		} else if ("5".equals(_parm)) {
			return "05:00";
		} else if ("6".equals(_parm)) {
			return "06:00";
		} else if ("7".equals(_parm)) {
			return "07:00";
		} else if ("8".equals(_parm)) {
			return "08:00";
		} else if ("9".equals(_parm)) {
			return "09:00";
		} else if ("10".equals(_parm)) {
			return "10:00";
		} else if ("11".equals(_parm)) {
			return "11:00";
		} else if ("12".equals(_parm)) {
			return "12:00";
		} else if ("13".equals(_parm)) {
			return "13:00";
		} else if ("14".equals(_parm)) {
			return "14:00";
		} else if ("15".equals(_parm)) {
			return "15:00";
		} else if ("16".equals(_parm)) {
			return "16:00";
		} else if ("17".equals(_parm)) {
			return "17:00";
		} else if ("18".equals(_parm)) {
			return "18:00";
		} else if ("19".equals(_parm)) {
			return "19:00";
		} else if ("20".equals(_parm)) {
			return "20:00";
		} else if ("21".equals(_parm)) {
			return "21:00";
		} else if ("22".equals(_parm)) {
			return "22:00";
		} else if ("23".equals(_parm)) {
			return "23:00";
		} else {
			return "14:00";
		}
	}
	
	
	public static String getCurrentTimeMillis(){
		return System.currentTimeMillis()+"";
	}
	
	/**
	 * 返回两个时间(格式：HH:mm)的差值
	 * @param _time1 (例：08:00)
	 * @param _time2 (例：09:00)
	 * @return
	 */
	public static int getTimeDifference(String _time1, String _time2){
		String[] temp1 = _time1.split(":");
		String[] temp2 = _time2.split(":");
		int hour1 = Integer.valueOf(temp1[0]);
		int hour2 = Integer.valueOf(temp2[0]);
		int minute1 = Integer.valueOf(temp1[1]);
		int minute2 = Integer.valueOf(temp2[1]);
		
		return (hour1-hour2) == 0 ? minute1-minute2 : hour1-hour2;
		
	}
	
	 /**
     * 取指定期间的第一天
     * @return
     */
    public static String getFirstDayOfMonth(String dateString){
    	String year = dateString.substring(0, 4);
    	String month = dateString.substring(5, 7);
        return year+"-"+month+"-01";
    }
    /**    
     * 得到指定月的最后一天    
     *     
    * @return    2010-09-10
     */     
    public static String getMonthLastDay(String dateString) {   
    	String year = dateString.substring(0, 4);
    	String month = ""+(Integer.valueOf(dateString.substring(5, 7))+1);
    	String date = year+"-"+month+"-01";
     return getBeforeDate(date);      
    }
    /**
     * 得到某一天的前一天
     * @param sdf
     * @param dateString
     * @return
     */
    public static String getBeforeDate(String dateString) {
        Calendar now_Time = Calendar.getInstance();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
            now_Time.setTime(df.parse(dateString));
        } catch (Exception e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        now_Time.add(Calendar.DATE,-1);
        SimpleDateFormat sdNowDate = new SimpleDateFormat("yyyy-MM-dd");
        return sdNowDate.format(now_Time.getTime());
    }
    
    /**
     * 获取今天得后几天
     * @param days
     * @return
     */
    public static String getAfterDate(int days) {
        Calendar now_Time = Calendar.getInstance();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
        	String dateString = getSysTime();
            now_Time.setTime(df.parse(dateString));
        } catch (Exception e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        now_Time.add(Calendar.DATE,days);
        SimpleDateFormat sdNowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdNowDate.format(now_Time.getTime());
    }
    
    
	/**
	 * 返回两个时间差
	 * @param _date1  格式：yyyy-MM-dd HH:mm:ss
	 * @param _date2  格式：yyyy-MM-dd HH:mm:ss
	 * @param accuray 精确度：0——天；1——小时；2——分钟；3——秒；4——毫秒
	 * @return
	 */
	public static long getDateTimeDifference(String _date1, String _date2, int accuray) {
		long Diff = 0;
		/*转化成为相应精确度*/
		long[] ACCURAY = {24L * 60L * 60L * 1000L, 60L * 60L * 1000L, 60L * 1000L, 1000L, 1L};
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date d1 = df.parse(_date1);
			java.util.Date d2 = df.parse(_date2);
			Diff = (d2.getTime() - d1.getTime()) / ACCURAY[accuray];
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return (Integer.parseInt("" + Diff));
		return Diff;
	}
	/**
	 * 时间增减
	 * @param date
	 * @param index：增减数量
	 * @param type 1:分钟 2：小时 3：天 4：月 5：年
	 * 
	 * @return
	 */
	public static Date getLastDateAndNextDate(Date date,int index ,int type){
		SimpleDateFormat df =  null ;
		if(date!=null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			switch (type) {
			case 1:cal.add(cal.MINUTE,index);break;
			case 2:cal.add(cal.HOUR,index);break;
			case 3:cal.add(cal.DATE,index);break;
			case 4:cal.add(cal.MONTH,index);break;
			case 5:cal.add(cal.YEAR,index);break;
			}
			Date endDate = cal.getTime();
			return endDate;
		}else{
			return null ;
		}
		
	}
	
	
	/**获取时间的年月日
	 * @param _date1
	 * @param _date2
	 * @return
	 */													
	public static Date getDate(String _date,String formate) {
		SimpleDateFormat df = new SimpleDateFormat(formate);
		Date time = null ;
		try {
			time = df.parse(_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;

	}
	
	public static long getDateDifference(Date begin , Date end,Integer type){
	        long between = 0;
	        try {
	            between = (begin.getTime() - end.getTime());// 得到两者的毫秒数
	            long day = between / (24 * 60 * 60 * 1000);
		        long hour = (between / (60 * 60 * 1000) - day * 24);
		        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
		        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
		                - min * 60 * 1000 - s * 1000);
		        System.out.println(day + "天" + hour + "小时" + min + "分" + s + "秒" + ms  + "毫秒");
		        if(type==1){
		        	between = day;
		        }else if(type==2){
		        	between = hour;
		        }else if(type==3){
		        	between = min;
		        }else if(type==4){
		        	between = s;
		        }else if(type==5){
		        	between = ms;
		        }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	     return between ;   
	}
	
	
	/**
	 * 把日期转化为==> yyyyMMddHHmmss
	 */
	public static String getCurrDate(Date date) {
		return format(date, "yyyy/MM/dd HH:mm:ss");
	}
	
	public static String getCurrDates(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 把日期转化为==> yyyyMMdd
	 */
	public static String getCurrDateDay(Date date) {
		return format(date, "yyyy/MM/dd");
	}
	
	/**
	 * 返回yyyy-MM-dd格式的当前日期
	 * @return
	 */
	public static String getCurrDateDay() {
		return format(new Date(), "yyyy-MM-dd");
	}
	
	//根据身份证号提取年龄
	public static Integer IDCardNoToAge(String idCardNo){

		int length = idCardNo.length();

		String dates = "";

		if (length == 18) {

			//int se = Integer.valueOf(idCardNo.substring(length - 1)) % 2;
			dates = idCardNo.substring(6, 10);

			SimpleDateFormat df = new SimpleDateFormat("yyyy");

			String year = df.format(new Date());

			int u = Integer.parseInt(year) - Integer.parseInt(dates);

			return u;

		} else {

			if (length == 15) {

				SimpleDateFormat df = new SimpleDateFormat("yyyy");
				String year = df.format(new Date());
				dates = idCardNo.substring(6, 8);
				String y="19"+dates+"";
				int u = Integer.parseInt(year) - Integer.parseInt(y);
				return u;

			} else {
				return 0;
			}

		}

  }
    /** 
     * 以友好的方式显示时间 
     * @param time 
     * @return 
     */  
    public static String friendlyTime(Date time) {  
        //获取time距离当前的秒数  
        int ct = (int)((System.currentTimeMillis() - time.getTime())/1000);  
           
        if(ct == 0) {  
            return "刚刚";  
        }  
           
        if(ct > 0 && ct < 60) {  
            return ct + "秒前";  
        }  
           
        if(ct >= 60 && ct < 3600) {  
            return Math.max(ct / 60,1) + "分钟前";  
        }  
        if(ct >= 3600 && ct < 86400)  
            return ct / 3600 + "小时前";  
        if(ct >= 86400 && ct < 2592000){ //86400 * 30  
            int day = ct / 86400 ;             
            return day + "天前";  
        }  
        if(ct >= 2592000 && ct < 31104000) { //86400 * 30  
            return ct / 2592000 + "月前";  
        }  
        return ct / 31104000 + "年前";  
    }  
    

/**
	 * 日期添加到分钟得到新时间(用于计算考试时间段)
	 * @param day 开始时间
	 * @param x		相隔分钟数（如开考的时间）
	 * @return
	 */
	public static String addDateMinut(String day, int x) {
		//入参的格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制  
        //出参的格式
        SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm:ss");// 24小时制  
        Date date = null;  
        try {  
            date = format.parse(day);  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
        if (date == null)  
            return "";  
        System.out.println("front:" + format.format(date));  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.add(Calendar.MINUTE, x);// 24小时制  
        //得到结算后的结果 yyyy-MM-dd HH:mm
        date = cal.getTime();  
        System.out.println("after:" + format.format(date));  
        cal = null;  
        //转换结果的格式 HH:mm
        return newFormat.format(date);  
  
    } 

	public static String addDateMinut(Date day, int x) {
		
		String days = format(day, "yyyy-MM-dd HH:mm:ss");
		//入参的格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制  
        //出参的格式
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制  
        Date date = null;  
        try {  
            date = format.parse(days);  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
        if (date == null)  
            return "";  
        System.out.println("front:" + format.format(date));  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.add(Calendar.MINUTE, x);// 24小时制  
        //得到结算后的结果 yyyy-MM-dd HH:mm
        date = cal.getTime();  
        System.out.println("after:" + format.format(date));  
        cal = null;  
        //转换结果的格式 HH:mm
        return newFormat.format(date);  
  
    } 
	public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
	
	public static String dateToStamp(Date date) throws ParseException{
        String res;
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
	 /* 
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
	
	public static void main(String[] args){
//		System.out.println("HH:mm==>" + getHourTime());
//		int a=IDCardNoToAge("130503670401001");
		
		String str = "2019-04-03 00:00:00";
		try {
			System.out.println(DateUtil.dateToStamp(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("==========" + getDateTimeDifference(DateUtil.allformat(new Date()),str,4));
//		System.out.println("==========" + getLastDateAndNextDate(new Date(),1,4));
//		System.out.println("==========" + getLastDateAndNextDate(new Date(),1,5));
		/*String address_list = "[{'point_name':'111','point_address':'北京市北京市朝阳区Aape服装店(三里屯太古里店)','longitude':116.45367768413,'latitude':39.93569518969,'province':'北京市','city':'北京市'}]";
		JSONArray json = JSONArray.fromObject(address_list);
		if(json!=null){
			for(int i=0;i<json.size();i++){
			    JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
			    String point_name = job.get("point_name").toString();//自提点名称
				String point_address = job.get("point_address").toString();//自提点地址
				String longitude = job.get("longitude").toString();//经度
				String latitude = job.get("latitude").toString();//纬度
				String point_province = job.get("province").toString();//省
				String point_city = job.get("city").toString();//城市
			    System.out.println(point_name+point_address+longitude+latitude);
			    System.out.println(point_province + point_city);
			    
			}
		}*/
	}
}
