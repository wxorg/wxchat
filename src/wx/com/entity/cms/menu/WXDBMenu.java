package wx.com.entity.cms.menu;

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
@Table(name="WXMenu")
@XStreamAlias("xml")
public class WXDBMenu {
	
	@Id
	@GeneratedValue(generator = "system-id")        
	@GenericGenerator(name = "system-id", strategy = "increment") 
	@XStreamOmitField
	private int menuId;
	
	@Column(length=4000)
	@XStreamAlias("menuJson")
	private String menuJson;
	
	@XStreamAlias("platId")
	private int platId;
	
	@XStreamAlias("isValid")
	private boolean isValid;
	
	@XStreamAlias("creatTime")
	private Timestamp createTime;
	
	@XStreamAlias("updateTime")
	private Timestamp updateTime;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuJson() {
		return menuJson;
	}
	public void setMenuJson(String menuJson) {
		this.menuJson = menuJson;
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
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
