package wx.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class StringUtil {
	
	
	public static final String inputStream2String(InputStream in) throws UnsupportedEncodingException, IOException{
		if(in == null)
			return "";
		
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n, "UTF-8"));
		}
		return out.toString();
	}
	
	
	
	public static String SHAEncrypt(String inputText) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		 if (inputText == null || "".equals(inputText.trim())) {   
	            throw new IllegalArgumentException("请输入要加密的内容");   
	        }   
	    
	        	
			 
	    MessageDigest m = MessageDigest.getInstance("sha");   
	            
	    m.update(inputText.getBytes());   
	            
	    byte s[] = m.digest();   
	            // m.digest(inputText.getBytes("UTF8"));   
	           
	    return bytetoString(s);   

	}
	
	
	public static String bytetoString(byte[] digest) {
        String str = "";
        String tempStr = "";
        
        for (int i = 0; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            }
            else {
                str = str + tempStr;
  
            }
        }
        return str.toLowerCase();
    }
	
	
	public static final boolean checkSignature(String token,String signature,String timestamp,String nonce) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		List<String> params = new ArrayList<String>();
		params.add(token);
		params.add(timestamp);
		params.add(nonce);
		Collections.sort(params,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		String temp = params.get(0)+params.get(1)+params.get(2);
		return SHAEncrypt(temp).equals(signature);
	}
	
	public static final boolean isNumeric(String str){
		if(null==str||"".equals(str)){
			return false;
		}
		for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i))){
				return false;
				}
			}
		
		return true;
	}
	
	public static final int getTime(){
		
		Long secTime = System.currentTimeMillis()/1000;

		return secTime.intValue();
	}

}
