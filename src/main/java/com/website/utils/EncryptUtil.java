package com.website.utils;

import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.log4j.Logger;


public class EncryptUtil {

	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger.getLogger(EncryptUtil.class);
    /**
     * 解密方法
     * @param message
     * @param key
     * @return
     */
    public static String decryptForMap(String message,String key) throws Exception {
    	String decStr = null;
    	Map<String, String> paramsMap = null;
		log.debug("解密串：" + message);
		log.debug("解密KEY：" + key);
		decStr = java.net.URLDecoder.decode(decryptProcess(message,key), "utf-8") ;
//		paramsMap = CommonsUtil.parseParams(decStr);
		log.info("参数解密结果：" + decStr);
    	return decStr;
    }
    
    /**
	 * 解密逻辑方法
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */  
    private static String decryptProcess(String message,String key) throws Exception {   
            byte[] bytesrc =convertHexString(message);      
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");       
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));      
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");      
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);      
            IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));   
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);         
            byte[] retByte = cipher.doFinal(bytesrc);        
            return new String(retByte);    
    }
    
    /**
     * 16进制数组数转化
     * @param ss
     * @return
     */
    private static byte[] convertHexString(String ss) throws Exception {    
        byte digest[] = new byte[ss.length() / 2];    
        for(int i = 0; i < digest.length; i++)    
        {    
        String byteString = ss.substring(2 * i, 2 * i + 2);    
        int byteValue = Integer.parseInt(byteString, 16);    
        digest[i] = (byte)byteValue;    
        }    
        return digest;    
    }
    
    
}
