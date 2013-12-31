package wx.com.entity.cms.plat;

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
@Table(name="WXPlatAcounts")
@XStreamAlias("xml")
public class PlatForm {
	
	@Id
	@GeneratedValue(generator = "system-id")        
	@GenericGenerator(name = "system-id", strategy = "increment") 
	@XStreamOmitField
	private int platID;
	
/*	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/

	@Column(length=200)
	@XStreamAlias("platName")
	private String platName;//公众平台名称
	
	@Column(length=200)
	@XStreamAlias("origId")
	private String origId;//原始ID
	
	@Column(length=200)
	@XStreamAlias("wxCode")
	private String wxCode;//微信号
	
	@Column(length=1)
	@XStreamAlias("serviceType")
	private short serviceType;//账号类型 ,服务类型:1：订阅号；2：服务号
	
	@Column(length=300)
	@XStreamAlias("email")
	private String email;//邮址
	
	@Column(length=100)
	@XStreamAlias("register")
	private String register;//注册人
	
	@Column(length=21)
	@XStreamAlias("registerPhone")
	private String registerPhone;//注册人联系电话
	
	
	@XStreamAlias("createTime")
	private Timestamp createTime;//创建时间
	
	@Column(length=200)
	@XStreamAlias("info")
	private String  info;//其它信息
	
	@XStreamAlias("isValid")
	private boolean isValid;//是否有效
	

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	

	public int getPlatID() {
		return platID;
	}

	public void setPlatID(int platID) {
		this.platID = platID;
	}

	public String getPlatName() {
		return platName;
	}

	public void setPlatName(String platName) {
		this.platName = platName;
	}

	public String getOrigId() {
		return origId;
	}

	public void setOrigId(String origId) {
		this.origId = origId;
	}

	public String getWxCode() {
		return wxCode;
	}

	public void setWxCode(String wxCode) {
		this.wxCode = wxCode;
	}

	public short getServiceType() {
		return serviceType;
	}

	public void setServiceType(short serviceType) {
		this.serviceType = serviceType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getRegisterPhone() {
		return registerPhone;
	}

	public void setRegisterPhone(String registerPhone) {
		this.registerPhone = registerPhone;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	
}
