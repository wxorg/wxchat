package wx.com.entity;

import wx.com.entity.event.Msg_Event;
import wx.com.entity.receive.Msg_Text;




/** 
* @ClassName: InMessage 
* @Description: TODO(微信公众平台) 
* @author jiang 
* @date 2013-11-27 上午9:32:50 
*  
*/ 
public class InMessage {

	private String ToUserName;
	private String FromUserName;
	private int CreateTime;
	private String MsgType = "text";
	private Long MsgId;
	// 文本消息
	private String Content;
	// 图片消息
	private String PicUrl;
	// 位置消息
	private String Location_X;
	private String Location_Y;
	private Long Scale;
	private String Label;
	// 链接消息
	private String Title;
	private String Description;
	private String Url;
	// 语音信息
	private String MediaId;
	private String Format;
	private String Recognition;
	// 事件
	private String Event;
	private String EventKey;
	private String Ticket;
	
	private String Latitude;
	private String Longitude;
	private String Precision;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public int getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(int createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getLocationX() {
		return Location_X;
	}

	public void setLocationX(String locationX) {
		Location_X = locationX;
	}

	public String getLocationY() {
		return Location_Y;
	}

	public void setLocationY(String locationY) {
		Location_Y = locationY;
	}

	public Long getScale() {
		return Scale;
	}

	public void setScale(Long scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
	
	
	
	
	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public Msg_Text convertMsg_Text(){
		
		Msg_Text msg_Text = new Msg_Text();
		msg_Text.setToUserName(this.getToUserName());
		msg_Text.setFromUserName(this.getFromUserName());
		msg_Text.setCreateTime(this.getCreateTime());
		msg_Text.setContent(this.getContent());
		msg_Text.setMsgType(this.getMsgType());
		
		return msg_Text;
		

	}
		
	public Msg_Event convertMsg_Event(){
		
		Msg_Event msg_Event = new Msg_Event();
		
		msg_Event.setToUserName(this.getToUserName());
		msg_Event.setFromUserName(this.getFromUserName());
		msg_Event.setCreateTime(this.getCreateTime());
		msg_Event.setMsgType(this.getMsgType());
		msg_Event.setEvent(this.getEvent());
		msg_Event.setEventKey(this.getEventKey());
		msg_Event.setTicket(this.getEventKey());
		msg_Event.setLatitude(this.getLatitude());
		msg_Event.setLongitude(this.getLongitude());
		msg_Event.setPrecision(this.getPrecision());
		
		return msg_Event;
	}
	
	
}

