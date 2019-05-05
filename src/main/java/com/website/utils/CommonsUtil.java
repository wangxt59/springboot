package com.website.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.format.Alignment;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;


/**
 * 通用规则
 * @author bizf
 *
 */
public class CommonsUtil {
	private static Long plsessionID = 0l;
	private static SnowFlake snowFlake = new SnowFlake(2, 10);
    /**
	 * 日志文件中的sessionID长度
	 */
	public static final int SESSION_ID_LEN = 15;
	public static String getRandomNum() {
		StringBuffer buf = new StringBuffer("a,b,c,d,e,f,g,h,i,g,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
		buf.append(",A,B,C,D,E,F,G,H,I,G,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z");
		buf.append(",~,@,#,$,%,^,&,*,(,),_,+,|,`,.");
		buf.append(",1,2,3,4,5,6,7,8,9,0");
		String[] arr = buf.toString().split(",");

		return getPswd(arr);
	}

	/**
	 * 生成随机码
	 * 
	 * @param arr
	 * @return
	 */
	public static String getPswd(String[] arr) {
		StringBuffer b = new StringBuffer();
		java.util.Random r;
		int k;
		for (int i = 0; i < 15; i++) {
			r = new java.util.Random();
			k = r.nextInt();
			b.append(String.valueOf(arr[Math.abs(k % 76)]));
		}
		return b.toString();
	}
	
	/**
	 * 生成6位随机编码
	 * @return
	 */
	public static String getPassword(){
		Random r = new Random(); 
		Double d = r.nextDouble(); 
		String s = d + ""; 
		s=s.substring(3,3+6); 
		
		
		return s;
	}
	/**
	 * 去除重复值
	 * 
	 * @param s
	 * @return
	 */
	public static List printMap1(String[] s) {
		List<String> list = new LinkedList<String>();
		List<String> list2 = Arrays.asList(s);
		list.addAll(list2);
		return list;

	}

	public static String[] array_unique(String[] a) {
		// array_unique
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < a.length; i++) {
			if (!list.contains(a[i])) {
				list.add(a[i]);
			}
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	/**
	 * 替换null为数字
	 * @param _parm
	 * @return
	 */
	public static String replaceNullToNumber(Long _parm) {
		if (_parm == null) {
			return "0";
		}
		return Long.toString(_parm);
	}
	/**
	 * 替换null为数字
	 * @param _parm
	 * @return
	 */
	public static String replaceNullToNumber(Integer _parm) {
		if (_parm == null) {
			return "0";
		}
		return Integer.toString(_parm);
	}
	/**
	 * 替换null为字符串
	 * @param _parm
	 * @return
	 */
	public static String replaceNullToNumberByString(String _parm) {
		if (_parm == null||"".equals(_parm)||"null".equals(_parm)) {
			return "0";
		}
		return _parm;
	}
	
	public static BigDecimal replaceNullToNumberByBigDecimal(String _parm) {
		if (_parm == null||"".equals(_parm)||"null".equals(_parm)) {
			return BigDecimal.valueOf(Double.valueOf("0"));
		}
		return BigDecimal.valueOf(Double.valueOf(_parm));
	}
	
	public static String replaceNullToSpace(String _parm) {
		if (_parm == null || "".equals(_parm) || "null".equals(_parm)) {
			return "";
		}
		return _parm;
	}

	/**
	 * 分页列表
	 * 
	 * @param page
	 *            当前页数
	 * @param total
	 *            总页数
	 * @param pagesList
	 *            返回的分页列表
	 * @return
	 */
	public static List<Integer> getPageList(int page, int total, List<Integer> pageList) {
		if (total > 0 && total <= 5) {
			for (int i = 1; i <= total; i++) {
				pageList.add(i);
			}
		} else if (page >= total - 2) {
			for (int i = total - 4; i <= total; i++) {
				pageList.add(i);
			}
		} else if (page < 5) {
			for (int i = 1; i <= 5; i++) {
				pageList.add(i);
			}
		} else {
			for (int i = page - 2; i <= page + 2; i++) {
				pageList.add(i);
			}
		}
		return pageList;
	}

	/**
	 * float数值四舍五入
	 * @param _num
	 * @return
	 */
	public static float getRound(){
		float _num = 6;
		_num = (float)(Math.round(_num*100))/100;
		return _num;
	}
	
	public static String getErrorInfo(String returnType, String code,
			String errorDesc) {
		StringBuffer stringBuff = new StringBuffer();
		if ("1".equals(returnType)) {
			stringBuff.append("<resmap><resultcode>");
			stringBuff.append(code);
			stringBuff.append("</resultcode><resultdesc>");
			stringBuff.append(errorDesc);
			stringBuff.append("</resultdesc></resmap>");
		}else {
			stringBuff.append("{\"resultcode\":\"");
			stringBuff.append(code);
			stringBuff.append("\",\"resultdesc\":\"");
			stringBuff.append(errorDesc);
			stringBuff.append("\"}");
		}
		return stringBuff.toString();
	}

	/**
	 * 生产主键ID规则
	 * @param _parm
	 * @return
	 */
	public static String getPrimaryKey(){
		String _parm = "";
		String systemflag = FileUtil.getProperty("systemflag");
		if(systemflag !=null && !"".equals(systemflag)){
			_parm = snowFlake.nextId()+"";
		}
		return _parm;
	}
	
	/**
	 * 返回6位编号
	 * @return
	 */
	public static String getShortPrimaryKey(){
		String _parm = ""+snowFlake.nextId();
		String redomNum=_parm.substring(3,9);
		return redomNum;
	}
	
	/**
	 * 生成标准编码
	 * @param _parm 编号
	 * @return
	 */
	public static String getStandardKey(String _parm){
		String timeKey = DateUtil.getDayStamp();//yyyyMMdd
		String shortKey = getShortPrimaryKey();//6位自增数
		return timeKey+_parm+shortKey;
	}
	/**
	 * 替换文件后缀操作
	 * @param _parm 原始文件名称（包括其全路径）
	 * @param replacement 替换者
	 * @return
	 */
	public static String replaceSuffix(String _parm, String replacement){
		if(null != _parm && !"".equals(_parm)
				&& null != replacement && !"".equals(replacement)){
			if(_parm.indexOf('.') != -1
					&& replacement.lastIndexOf('.') != -1){
				StringBuffer temp = new StringBuffer();
				temp.append(_parm.substring(0, _parm.lastIndexOf('.')));
				temp.append(replacement);
				return temp.toString();
			}
		}
		return "";
	}
	
	/**
	 * 单元格转化工具(不加粗版)
	 * @param fontSize 字号
	 * @param align 对齐方式
	 * @param bls 单元格边框加粗类型
	 * @param c 列值（起始单元格）
	 * @param r 行值（起始单元格）
	 * @param cont 内容
	 * @return
	 */
	public static Label cellFormatNO_BOLD(int fontSize, Alignment align, BorderLineStyle bls, Colour colour, int c, int r, String cont){
		/** 
         * 定义单元格样式 
         */  
        WritableFont wf_temp = new WritableFont(WritableFont.ARIAL, fontSize,  
                WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,  
                jxl.format.Colour.BLACK); // 定义格式 字体 下划线 斜体 粗体 颜色  
        
        WritableCellFormat wcf_temp = new WritableCellFormat(wf_temp); // 单元格定义  
        try {
        	wcf_temp.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//设置垂直对齐方式
			wcf_temp.setBackground(jxl.format.Colour.WHITE);
			wcf_temp.setAlignment(align); // 设置对齐方式  
			wcf_temp.setBorder(jxl.format.Border.ALL, bls, jxl.format.Colour.GRAY_25); //设置边框
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        Label tempLabel=new Label(c,r,cont,wcf_temp);
        return tempLabel;
	}
	
	/**
	 * 单元格转化工具(加粗版)
	 * @param fontSize 字号
	 * @param align 对齐方式
	 * @param bls 单元格边框加粗类型
	 * @param c 列值（起始单元格）
	 * @param r 行值（起始单元格）
	 * @param cont 内容
	 * @return
	 */
	public static Label cellFormatBOLD(int fontSize, Alignment align, BorderLineStyle bls, Colour colour, int c, int r, String cont){
		/** 
         * 定义单元格样式 
         */  
        WritableFont wf_temp = new WritableFont(WritableFont.ARIAL, fontSize,  
                WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,  
                jxl.format.Colour.BLACK); // 定义格式 字体 下划线 斜体 粗体 颜色  
        
        WritableCellFormat wcf_temp = new WritableCellFormat(wf_temp); // 单元格定义  
        try {
        	wcf_temp.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//设置垂直对齐方式
			wcf_temp.setBackground(jxl.format.Colour.WHITE);
			wcf_temp.setAlignment(align); // 设置对齐方式  
			wcf_temp.setBorder(jxl.format.Border.ALL, bls, colour); //设置边框
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        Label tempLabel=new Label(c,r,cont,wcf_temp);
        return tempLabel;
	}
	
	public static boolean isNotEmpty(String str) {
		if(str==null || "".equals(str.trim()) || ("null").equals(str.trim())){
			return false ;
		}else{
			return true ;
		}
	}
	
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim()) || ("null").equals(str.trim())){
			return true ;
		}else{
			return false ;
		}
	}
	
	
	/**
	 * 根据当前序列号，生成新的SessionID
	 * 
	 * @param num
	 * @param len
	 * @return
	 */
	public static String newSessionID() {
		synchronized (plsessionID) {
			plsessionID++;
		}
		String newSessionID = Long.toHexString(plsessionID);

		if (newSessionID.length() >= (SESSION_ID_LEN)) {
			return newSessionID.substring(0, SESSION_ID_LEN);
		}

		int additionalLen =SESSION_ID_LEN - newSessionID.length();
		for (int i = 0; i < additionalLen; i++) {
			newSessionID = "0" + newSessionID;
		}
		return newSessionID;

	}
	
	public static String getRandomCoupon() {
		StringBuffer buf_num = new StringBuffer("1,2,3,4,5,6,7,8,9,0");
		String[] arr_num = buf_num.toString().split(",");
		
		StringBuffer b = new StringBuffer();
		java.util.Random r;
		int k;
		for (int i = 0; i < 10; i++) {
			r = new java.util.Random();
			k = r.nextInt();
			b.append(String.valueOf(arr_num[Math.abs(k % 10)]));
		}
		return "LFT"+b.toString();
		
	}
	
	/**
	 * 验证数字
	 * @param str
	 * @return
	 */
	public static boolean isNumer(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if(isEmpty(str) || !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
	
	public static String getWeixinErrorInfo(String returnType, String code,String errorDesc) {
		StringBuffer stringBuff = new StringBuffer();
		if ("1".equals(returnType)) {
			stringBuff.append("<xml><return_code><![CDATA[");
			stringBuff.append(code);
			stringBuff.append("]]></return_code><return_msg><![CDATA[");
			stringBuff.append(errorDesc);
			stringBuff.append("]]></return_msg></xml>");
		}else {
			stringBuff.append("{\"resultcode\":\"");
			stringBuff.append(code);
			stringBuff.append("\",\"resultdesc\":\"");
			stringBuff.append(errorDesc);
			stringBuff.append("\"}");
		}
		return stringBuff.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getStandardKey("101"));
	}
	//【生成32位UUID】
	public static String getUUID() {  
		return UUID.randomUUID().toString().replace("-", "");  
	}  
	
	
	/**
	 * Autor   :Anmbition
	 * function：new List and add to parameter
	 * descript：String
	 */
	public final static List<String> create_List(String... args) {
	    return Arrays.asList(args);
	}
	
	/**
	 * Autor   :Anmbition
	 * function：new List and add to parameter
	 * descript：Integer
	 */
	public final static List<Integer> create_List(Integer... args) {
	    return Arrays.asList(args);
	}
	
	//生成随机8位数
	public static String generateNumber() {
		String no = "";
		// 初始化备选数组
		int[] defaultNums = new int[10];
		for (int i = 0; i < defaultNums.length; i++) {
			defaultNums[i] = i;
		}

		Random random = new Random();
		int[] nums = new int[LENGTH];
		// 默认数组中可以选择的部分长度
		int canBeUsed = 10;
		// 填充目标数组
		for (int i = 0; i < nums.length; i++) {
			// 将随机选取的数字存入目标数组
			int index = random.nextInt(canBeUsed);
			nums[i] = defaultNums[index];
			// 将已用过的数字扔到备选数组最后，并减小可选区域
			swap(index, canBeUsed - 1, defaultNums);
			canBeUsed--;
		}
		if (nums.length > 0) {
			for (int i = 0; i < nums.length; i++) {
				no += nums[i];
			}
		}

		return no;
	}

	private static final int LENGTH = 6;

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static String generateNumber2() {
		String no = "";
		int num[] = new int[6];
		int c = 0;
		for (int i = 0; i < 6; i++) {
			num[i] = new Random().nextInt(10);
			c = num[i];
			for (int j = 0; j < i; j++) {
				if (num[j] == c) {
					i--;
					break;
				}
			}
		}
		if (num.length > 0) {
			for (int i = 0; i < num.length; i++) {
				no += num[i];
			}
		}
		return no;
	}
	
	/**
	 * 生成标准编码
	 * @param _parm 编号
	 * @return
	 */
	public static String getStandardKey1(String _parm){
		String timeKey = DateUtil.getDayStamp();//yyyyMMdd
		String shortKey = generateNumber2();//6位自增数
		return timeKey+_parm+shortKey;
	}
	
}
