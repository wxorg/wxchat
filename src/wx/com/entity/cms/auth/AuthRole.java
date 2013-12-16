package wx.com.entity.cms.auth;

import org.acegisecurity.GrantedAuthority;

public class AuthRole implements GrantedAuthority {
	
	private String id;

	private static final long serialVersionUID = 1L;
	
	public AuthRole(String id){
		this.id = id;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
