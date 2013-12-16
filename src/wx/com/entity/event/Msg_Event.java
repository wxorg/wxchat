package wx.com.entity.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wx.com.entity.Msg_Base;

/** 
* @ClassName: Event_Sub 
* @Description: TODO(微信公众平台) 关注 、取消关注事件
* @author jiang 
* @date 2013-11-28 下午7:20:21 
*  
*/ 
public class Msg_Event extends Msg_Base {
	
	@XStreamAlias("Event")
	private String event;
	
	@XStreamAlias("EventKey")
	private String eventKey;
	
	@XStreamAlias("Ticket")
	private String ticket;
	
	@XStreamAlias("Latitude")
	private String latitude;
	
	@XStreamAlias("Longitude")
	private String longitude;
	
	@XStreamAlias("Precision")
	private String precision;
	
	
	

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}
	
	
	

}
