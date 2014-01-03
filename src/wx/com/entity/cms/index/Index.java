package wx.com.entity.cms.index;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


@Entity
@Table(name="WXIndexs")
@XStreamAlias("xml")
public class Index {
	
	@Id
	@GeneratedValue(generator = "system-id")        
	@GenericGenerator(name = "system-id", strategy = "increment") 
	@XStreamOmitField
	private int indexId;
	
	@XStreamAlias("indexType")
	private short indexType;//0:关注索引,1:默认索引,2:关键字索引,3:搜索索引
	
	@XStreamAlias("msgType")
	private short msgType;//1:文本,2:图片
	
	@XStreamAlias("createTime")
	private Timestamp creatTime;
	
	@XStreamAlias("updateTime")
	private Timestamp updateTime;
	
	@Column(length=200)
	@XStreamAlias("keyWord")
	private String keyWord;
	
	@Column(length=1000)
	@XStreamAlias("text")
	private String text;
	
	@XStreamAlias("mediaId")
	private long mediaId;
	
	@XStreamAlias("platId")
	private int platId;
	
	@XStreamAlias("isValid")
	private boolean isValid;
	
	public int getIndexId() {
		return indexId;
	}
	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}
	public short getIndexType() {
		return indexType;
	}
	public void setIndexType(short indexType) {
		this.indexType = indexType;
	}
	public short getMsgType() {
		return msgType;
	}
	public void setMsgType(short msgType) {
		this.msgType = msgType;
	}
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getMediaId() {
		return mediaId;
	}
	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
	}
	public int getPlatId() {
		return platId;
	}
	public void setPlatId(int platId) {
		this.platId = platId;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	

}
