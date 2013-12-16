package wx.com.controller.accept;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wx.com.entity.InMessage;
import wx.com.service.IMessageManager;
import wx.com.util.StringUtil;
import wx.com.util.XStreamFactory;




import com.thoughtworks.xstream.XStream;

@Controller
public class WXPushMsg {
	
	private Logger logger = Logger.getLogger(getClass());

			
	@Resource(name="messageManager") 
    public IMessageManager messageManager;    

	/**
	 * @param param
	 * @param httRequest
	 * @param httpRespon
	 */
	@RequestMapping(value="weixin",method = RequestMethod.POST)
	public void getPostData(HttpServletRequest httRequest,HttpServletResponse httpRespon){
		
		
		httpRespon.setCharacterEncoding("utf-8");
		httpRespon.setContentType("text/xml;charset=utf-8");
		
		try {

			ServletInputStream in = httRequest.getInputStream();
			XStream xs = XStreamFactory.init(true);
			xs.alias("xml", InMessage.class);
			String inputxml = StringUtil.inputStream2String(in);
		
			logger.info("请求消息："+inputxml);
			InMessage inMessage = (InMessage)xs.fromXML(inputxml);
			
			
			String output = messageManager.msg_Handler(inMessage);
			
			httpRespon.getWriter().write(output);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("IOException:"+e);
		} catch(Exception e){
			e.printStackTrace();
			logger.error("IOException:"+e);
		}
		
	
			

							
		
	}

	public IMessageManager getMessageManager() {
		return messageManager;
	}

	public void setMessageManager(IMessageManager messageManager) {
		this.messageManager = messageManager;
	}

}
