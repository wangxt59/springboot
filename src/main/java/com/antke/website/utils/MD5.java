package com.antke.website.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tencent.Main;

public class MD5 {

	private static Log log = LogFactory.getLog(MD5.class);

	/**
	 * MD5编码
	 * 
	 * @param sText
	 *            原始文本
	 * @param sCharsetName
	 *            编码名称
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception {
		System.out.println(encode("admin",""));
	}
	
	public static String encode(String sText, String sCharsetName)
			throws Exception {
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		sCharsetName = sCharsetName == null || sCharsetName.equals("") ? SysConstants.DEFAULT_ENCODE
				: sCharsetName;
		byte[] source = sText.getBytes(sCharsetName);

		java.security.MessageDigest md = java.security.MessageDigest
				.getInstance("MD5");
		md.update(source);
		byte tmp[] = md.digest();

		char str[] = new char[16 * 2];
		int k = 0;
		for (int i = 0; i < 16; i++) {
			byte byte0 = tmp[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}

		s = new String(str);
		log.info("MD5原串=" + sText + ",加密串=" + s);

		return s.toLowerCase();
	}
}
