package com.antke.website.utils;

import com.infosec.NetSignServer;

public class BOCOMUtil {
	
	
	//加密方法
	public static String NSMakeSecurityEnvelopMsg(byte[] plaintext) throws Exception{
			NetSignServer NsEncryptedServer=new NetSignServer();
			NsEncryptedServer.NSSetPlainText(plaintext);
			byte[] nsMakeMsg = NsEncryptedServer.NSSignedAndEncryptedEnvelop("C=CN,O=BANKCOMM CA,OU=BANKCOMM,OU=CCMerchants,CN=040@[e7a62b99f4cd40209b8dc16d30e1606e]@000", "C=CN,O=BANKCOMM CA,CN=creditcard.bankcomm.com");
			int errCode=NsEncryptedServer.getLastErrnum();
			String res=null;
			if(errCode==0)
			{
			 res = new String(nsMakeMsg);  // byte[] 转 string
			}
			System.out.println("加密后的报文==================================="+"加密报文["+res+"]错误码："+errCode);
			return res;
		}
	//解密方法
		public static String NSOpenSecurityEnvelopMsg(String plaintext) throws Exception
		{
			NetSignServer NsOpenServer=new NetSignServer();
			NsOpenServer.NSDecryptedAndVerifiedEnvelop(plaintext.getBytes(), "C=CN,O=BANKCOMM CA,OU=BANKCOMM,OU=CCMerchants,CN=040@[e7a62b99f4cd40209b8dc16d30e1606e]@000");
			int errCode=NsOpenServer.getLastErrnum();
			byte[] nsOpenMsg=NsOpenServer.NSGetPlainText();
			String resOut=null;
			if(errCode==0)
			{
				resOut=new String(nsOpenMsg);
			}
			System.out.println("返回加密后的报文==================================="+"解密报文["+resOut+"]错误码："+errCode);
			return resOut;
		}
		
		
		public static void main(String[] args) {
			try {
				String string = "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";
				String msg = BOCOMUtil.NSOpenSecurityEnvelopMsg(string);
				System.out.println(msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

}
