package wx.com.service.cms.auth;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import wx.com.dao.auth.ILoginDAO;
import wx.com.entity.cms.auth.Authorities;

/**
 * 
   * @ClassName: LoginManager
   * @Description: TODO
   * @author Comsys-axin
   * @date 2013年12月28日 下午3:14:07
   *
 */
@Service
@SuppressWarnings("all")
public class LoginManager implements ILoginManager {
	
	@Resource
    public ILoginDAO loginDAO; 
	
	public ILoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(ILoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public Authorities getAuthUserDetail(String username) throws Exception{
		
		Authorities tuser = new Authorities();
		List _list = loginDAO.getAuthUserDetail(username);
		if (_list == null) {
			return null;
		} else {
			if (_list.size() > 0) {
				tuser = (Authorities) _list.get(0);
				return tuser;
			} else {
				return null;
			}
		}
	}
	
	public void SaveAuthUserDetail(Authorities user) throws Exception{
		try{
		
			Authorities userObj = new Authorities();
			userObj.setUserName("alice");
			userObj.setPassword("123");
			userObj.setCreateTime(new Timestamp(System.currentTimeMillis()));//new java.util.Date().getTime())
			userObj.setAccountNonExpired(true);
			userObj.setAccountNonLocked(true);
			userObj.setCredentialsNonExpired(true);
			userObj.setEnabled(true);
			userObj.setInfo("登录帐号");
		
			loginDAO.SaveAuthUserDetail(userObj);
		}catch(Exception ex){
			
		}
		
		
	}

}//LoginManager -- end
