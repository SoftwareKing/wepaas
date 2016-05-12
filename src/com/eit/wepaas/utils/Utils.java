package com.eit.wepaas.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Utils {
	
	public static String generateUUID4(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
    /**
	 * ��ժҪ��Ϣת��Ϊ��Ӧ�ı���
	 * @param code ��������
	 * @param message ժҪ��Ϣ
	 * @return ��Ӧ�ı����ַ���
	 */
	private static String Encode(String code,String message){
		MessageDigest md;
		String encode = null;
		try {
			md = MessageDigest.getInstance(code);
			encode = byteArrayToHexString(md.digest(message
					.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encode;
	}
	
	 public static String byteArrayToHexString(byte[] b) {
		    StringBuffer sb = new StringBuffer(b.length * 2);
		    for (int i = 0; i < b.length; i++) {
		      int v = b[i] & 0xff;
		      if (v < 16) {
		        sb.append('0');
		      }
		      sb.append(Integer.toHexString(v));
		    }
		    return sb.toString().toUpperCase();
	 }

	 /** 
	     * ��ժҪ��Ϣת����SHA-512���� 
	     * @param message ժҪ��Ϣ 
	     * @return SHA-512����֮����ַ��� 
	     */  
	    public static String sha512Encode(String message){  
	        return Encode("SHA-512",message);  
	    }  
	    
	    public static void main(String args[]){
	    	System.out.println(Utils.sha512Encode("password").toLowerCase());
	    }

}
