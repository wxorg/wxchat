package wx.com.dao.auth;

//import javax.annotation.Resource;

//import org.hibernate.SessionFactory;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import wx.com.common.SQLType;
import wx.com.common.util.StringFormatSQL;
import wx.com.entity.cms.auth.Authorities;
import wx.com.service.base.BaseDAO;

@Repository
@SuppressWarnings("all")
public class LoginDAO extends BaseDAO implements ILoginDAO {
	
	private static final long serialVersionUID = 1132213L;
	
	//@Resource
	private String usersByUsernameQuery;
	

	public String getUsersByUsernameQuery() {
		return usersByUsernameQuery;
	}

	public void setUsersByUsernameQuery(String usersByUsernameQuery) {
		this.usersByUsernameQuery = usersByUsernameQuery;
	}

	

	@Override
	public void SaveAuthUserDetail(Authorities authuser ) throws Exception{
		
//		PlatForm platForm = new PlatForm();
//		platForm.setPlatID(1);
//		platForm.setOrigId("gh_9cc49ccae03a");
//		platForm.setPlatName("无线天利深圳分公司");
//		platForm.setValid(true);
//		platForm.setCreateTime(new Timestamp(System.currentTimeMillis()));
		this.save(authuser);
	}
	
	@Override
	public List getAuthUserDetail(String username) throws Exception{
		//System.out.println(usersByUsernameQuery);
		String stringSQL=StringFormatSQL.format(usersByUsernameQuery, username);
		List list = this.query(stringSQL, SQLType.HQL);
		return list;
	}

}
