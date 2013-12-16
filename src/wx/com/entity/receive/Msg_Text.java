package wx.com.entity.receive;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import wx.com.entity.Msg_Base;



import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
* @ClassName: Msg_Text 
* @Description: TODO(微信公众平台) 
* @author jiang 
* @date 2013-11-26 下午2:34:32 
*  
*/ 
@Entity
@Table(name="W_Msg_Text")
@XStreamAlias("xml")
public class Msg_Text extends Msg_Base{
	
	@Column(length=2000)
	@XStreamAlias("Content")
	private String content;
	
	@Column(length=30)
	@XStreamAlias("MsgId")
	private long msgId;

	public String getContent() {
		return content;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
