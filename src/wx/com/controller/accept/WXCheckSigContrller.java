package wx.com.controller.accept;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import wx.com.util.ConfigureClass;
import wx.com.util.StringUtil;




/** 
* @ClassName: WXCheckSigContrller 
* @Description: TODO(微信公众平台) 
* @author jiang 
* @date 2013-11-25 下午5:08:46 
*  
*/ 
@Controller
public class WXCheckSigContrller {
	
	private Logger logger = Logger.getLogger(getClass());
	

	/**
	 * @param param
	 * @param httRequest
	 * @param httpRespon
	 */
	@RequestMapping(value="weixin",method = RequestMethod.GET)
	public void checkSig(@RequestParam Map<String, Object> param,HttpServletRequest httRequest,HttpServletResponse httpRespon){
		
		String signature="";
		String timestamp ="";
		String nonce ="";
		String echostr="";
		
		
		httpRespon.setContentType("text/plain;charset=utf-8");
		httpRespon.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = httpRespon.getWriter();
			
		
		
			String token=ConfigureClass.getTOKEN();
			logger.info("token:"+token);
				
			if(null!=param.get("signature")){
				signature = (String) param.get("signature");
				logger.info("signature:"+signature);
			}
		
		
			if(null!=param.get("timestamp")){
				timestamp = (String) param.get("timestamp");
				logger.info("timestamp:"+timestamp);
			}
		
			if(null!=param.get("nonce")){
				nonce = (String) param.get("nonce");
				logger.info("nonce:"+nonce);
			}
		
			if(null!=param.get("echostr")){
				echostr = (String) param.get("echostr");
				logger.info("echostr:"+echostr);
			}
		
		
			String[] tmpArray = {token,timestamp,nonce};
			
			//字典排序
			Arrays.sort(tmpArray);
		
		
			String tmpStr = "";
		
			for(int i =0;i<tmpArray.length;i++){
				tmpStr+= tmpArray[i];
			}
		
			//字符串SHA1加密
			
			
			logger.info("SHAEncrypt:"+StringUtil.SHAEncrypt(tmpStr));
			if(StringUtil.checkSignature(token, signature, timestamp, nonce)){

				logger.info("signature is true");
				out.write(echostr);
				
			}else{
				logger.info("signature is error");
				out.write("error signature");
			}
			
			
			
			out.flush();
			out.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("IOException:"+e);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("NoSuchAlgorithmException:"+e);
		}
		
		
		
	}
	
	
	

}
