package wx.com.entity.send;

import wx.com.entity.Msg_Base;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Msg_Text_Out extends Msg_Base {
	
	@XStreamAlias("MsgType")
	private String	msgType	= "text";
	// 文本消息
	
	@XStreamAlias("Content")
	private String	content;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
	

}
