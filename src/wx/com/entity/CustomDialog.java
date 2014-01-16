package wx.com.entity;

import java.sql.Timestamp;



public class CustomDialog {
	
	private long id;
	private Timestamp createtime;
	private String toUserName;
	private String fromUserName;
	private String content;
	private int inOrout; //1 receive  2 send
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
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
	public int getInOrout() {
		return inOrout;
	}
	public void setInOrout(int inOrout) {
		this.inOrout = inOrout;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
