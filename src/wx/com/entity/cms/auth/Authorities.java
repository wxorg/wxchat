package wx.com.entity.cms.auth;

//import java.sql.Date;
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
@Table(name="Authorities")
@XStreamAlias("xml")
public class Authorities  {
	
	
	@Id
	@GeneratedValue(generator = "system-id")        
	@GenericGenerator(name = "system-id", strategy = "increment") 
	@XStreamOmitField
	private int AuthID=0;
	
	@Column(length=50)
	@XStreamAlias("UserName")
	private String UserName;
	
	@Column(length=50)
	@XStreamAlias("Password")
	private String Password;
	
	@XStreamAlias("CreateTime")
	private Timestamp CreateTime;
	
	@XStreamAlias("Enabled")
	private boolean Enabled;
	
	@XStreamAlias("AccountNonExpired")
	private boolean AccountNonExpired;
	
	@XStreamAlias("AccountNonExpired")
	private boolean CredentialsNonExpired;
	
	@XStreamAlias("AccountNonExpired")
	private boolean AccountNonLocked;
	
	@Column(length=200)
	@XStreamAlias("UserName")
	private String Info;
	public int getAuthID() {
		return AuthID;
	}
	public void setAuthID(int authID) {
		AuthID = authID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	public boolean isEnabled() {
		return Enabled;
	}
	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
	public boolean isAccountNonExpired() {
		return AccountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		AccountNonExpired = accountNonExpired;
	}
	public boolean isCredentialsNonExpired() {
		return CredentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		CredentialsNonExpired = credentialsNonExpired;
	}
	public boolean isAccountNonLocked() {
		return AccountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		AccountNonLocked = accountNonLocked;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	

}
