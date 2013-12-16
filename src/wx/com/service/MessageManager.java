package wx.com.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.XStream;





import wx.com.dao.IMsgDAO;
import wx.com.entity.InMessage;
import wx.com.entity.Msg_Base;
import wx.com.entity.event.Msg_Event;
import wx.com.entity.receive.Msg_Text;
import wx.com.entity.send.Article;
import wx.com.entity.send.Msg_News_Out;
import wx.com.entity.send.Msg_News_Out1;
import wx.com.entity.send.Msg_Text_Out;
import wx.com.util.ConfigureClass;
import wx.com.util.StringUtil;
import wx.com.util.XStreamFactory;

/** 
* @ClassName: MessageManager   Service
* @Description: TODO(微信公众平台) 
* @author jiang 
* @date 2013-11-28 上午8:52:39 
*  
*/ 
@Service
public class MessageManager implements IMessageManager {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Resource
	private IMsgDAO msgDAO;

	
	@Override
	@Transactional
	public String msg_Handler(InMessage msg) {
		// TODO Auto-generated method stub
       
        String type = msg.getMsgType();
		String xmlStr="";
		try {
			Method mtd = this.getClass().getMethod(type+"MsgHandler", InMessage.class,IMsgDAO.class);

			xmlStr = String.valueOf(mtd.invoke(MessageManager.class.newInstance(), msg,msgDAO));
				
			
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("SecurityException:"+e);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("NoSuchMethodException:"+e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("IllegalArgumentException:"+e);
		} catch (IllegalAccessException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("IllegalAccessException:"+e);
		} catch (InvocationTargetException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("InvocationTargetException:"+e);
		} catch (InstantiationException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("InstantiationException:"+e);
		}
		
		if("".equals(xmlStr)){
			xmlStr = defualtReplayIndex(msg);
		}
		return xmlStr;
	}

	public IMsgDAO getMsgDAO() {
		return msgDAO;
	}

	public void setMsgDAO(IMsgDAO msgDAO) {
		this.msgDAO = msgDAO;
	}
	
	
	
	public String textMsgHandler(InMessage msg,IMsgDAO msgDAO){
		
		Msg_Text msg_Text = msg.convertMsg_Text();
		String content = msg_Text.getContent();
		
		String output="";
		Msg_Text_Out textOut = new Msg_Text_Out();
		
		textOut.setToUserName(msg_Text.getFromUserName());
		textOut.setFromUserName(msg_Text.getToUserName());
		textOut.setCreateTime(StringUtil.getTime());
		XStream xs = XStreamFactory.init(true);
		xs.alias("xml", Msg_Text_Out.class);
		xs.autodetectAnnotations(true);
		
		if(null!=msgDAO){

			if(StringUtil.isNumeric(content)){
				
				textOut.setContent(msgDAO.getIndex(Integer.valueOf(content)));	
				output = xs.toXML(textOut);
//				getTextXml(msg,msgDAO.getIndex(Integer.valueOf(content)));
						
			}else{
	
				output = newsReplyIndex(msg);
			}
			
			
			logger.info("回复消息："+output);
			
		}else{
			
		    logger.error("msgDAO is null");
		    output="";
		    
		}
		
		
		
		
		return output;
	}
	
	
	
	
	public String eventMsgHandler(InMessage msg,IMsgDAO msgDAO){
		
		String key = msg.getEvent();
		
		Msg_Event msg_Event = msg.convertMsg_Event();
		
		if(key.equals(Msg_Base.MSG_ENVENT_SUB)){
			
			msgDAO.updateSub(msg_Event);
			return subcribeReplayIndex(msg);
			
		}else if(key.equals(Msg_Base.MSG_ENVENT_LOCATION)){
			
			msgDAO.saveLocation(msg_Event);
			return subcribeReplayIndex(msg);
			
		}else if(key.equals(Msg_Base.MSG_ENVENT_SCAN)){
			
			msgDAO.updateSub(msg_Event);
			return subcribeReplayIndex(msg);
			
		}else if(key.equals(Msg_Base.MSG_ENVENT_CLICK)){
			
//			msgDAO.updateSub(msg_Event);
			return textMsgHandler(msg,msgDAO);
			
		}else{
			
			return subcribeReplayIndex(msg);
		}
		
		
	}
	
	
	
	
	
	
	public String defualtReplayIndex(InMessage msg){
		
		String content = "默认索引";
		return getTextXml(msg,content);
	}
	
	public String subcribeReplayIndex(InMessage msg){
		
		String content = "关注索引";
		return getTextXml(msg,content);
	}
	
	
	public String getTextXml(InMessage msg,String content){
		
		Msg_Text_Out textOut = new Msg_Text_Out();
		
		textOut.setToUserName(msg.getFromUserName());
		textOut.setFromUserName(msg.getToUserName());
		textOut.setCreateTime(StringUtil.getTime());
		textOut.setContent(content);
		XStream xs = XStreamFactory.init(true);
		xs.alias("xml", Msg_Text_Out.class);
		xs.autodetectAnnotations(true);
		return xs.toXML(textOut);
		
	}
	
	
	public String newsReplyIndex(InMessage msg){
		
		Msg_News_Out msg_News = new Msg_News_Out();
		msg_News.setToUserName(msg.getFromUserName());
		msg_News.setFromUserName(msg.getToUserName());
		msg_News.setCreateTime(StringUtil.getTime());
//		msg_News.setMsgType("new");
		msg_News.setArticleCount(Integer.valueOf(2));
		Article article1 = new Article();
		article1.setTitle("图片1展示");
		article1.setDiscription("图片1展示图片1展示图片1展示图片1展示图片1展示");
		article1.setPicUrl(ConfigureClass.getWEBURL()+"/static/a1.jpg");
		article1.setUrl(ConfigureClass.getWEBURL()+"/static/a1.jpg");
		
		Article article2 = new Article();
		article2.setTitle("图片2展示");
		article2.setDiscription("图片2展示图片2展示图片2展示图片2展示图片2展示");
		article2.setPicUrl(ConfigureClass.getWEBURL()+"/static/a2.jpg");
		article2.setUrl(ConfigureClass.getWEBURL()+"/static/a2.jpg");
		
		
		msg_News.getArticles().add(article1);
		msg_News.getArticles().add(article2);
		
		XStream xs = XStreamFactory.init(true);
		xs.alias("xml", Msg_News_Out.class);
//		xs.processAnnotations(Msg_News_Out.class);
//		xs.processAnnotations(Article.class);
		xs.autodetectAnnotations(true);
		return xs.toXML(msg_News);
	}
	
	

}
