package wx.com.entity.cms.index;

public class Index {
	
	
	public String id;
	/**
	 * index Type 1
	 */
	public byte indexType;
	public byte msgType;
	public long creatTime;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte getIndexType() {
		return indexType;
	}
	public void setIndexType(byte indexType) {
		this.indexType = indexType;
	}
	public byte getMsgType() {
		return msgType;
	}
	public void setMsgType(byte msgType) {
		this.msgType = msgType;
	}
	public long getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(long creatTime) {
		this.creatTime = creatTime;
	}
	
	
	

}
