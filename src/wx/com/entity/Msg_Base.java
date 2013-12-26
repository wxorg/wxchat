package wx.com.entity;





import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@MappedSuperclass
public class Msg_Base {
	public final static String MSG_TYPE_TEXT = "text";
	public final static String MSG_TYPE_LOCATION = "location";
	public final static String MSG_TYPE_IMAGE = "image";
	public final static String MSG_TYPE_LINK = "link";
	public final static String MSG_TYPE_VOICE = "voice";
	public final static String MSG_TYPE_EVENT = "event";
	
	public final static String MSG_TYPE_NEWS = "news";
	public final static String MSG_TYPE_MUSIC = "music";
	
	public final static String MSG_ENVENT_SUB="subscribe";
	public final static String MSG_ENVENT_UNSUB="unsubscribe";
	public final static String MSG_ENVENT_SCAN="scan";
	public final static String MSG_ENVENT_LOCATION="LOCATION";
	public final static String MSG_ENVENT_CLICK="CLICK";

	@Id
	@GeneratedValue(generator = "system-id")        
	@GenericGenerator(name = "system-id", strategy = "increment") 
	@XStreamOmitField
	protected long id;
	
	@Column(length=32)
	@XStreamAlias("ToUserName")
	protected String toUserName;
	
	@Column(length=32)
	@XStreamAlias("FromUserName")
	protected String fromUserName;
	
	@Column(length=32)
	@XStreamAlias("CreateTime")
	protected int createTime;
	
	@Column(length=32)
	@XStreamAlias("MsgType")
	protected String msgType;
	
	

	
	public Msg_Base(){
		
	}
	
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	
	
	

}
