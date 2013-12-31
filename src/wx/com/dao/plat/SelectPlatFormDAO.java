package wx.com.dao.plat;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import wx.com.common.SQLType;
import wx.com.dao.base.BaseDAO;
import wx.com.entity.cms.auth.Authorities;
import wx.com.entity.cms.plat.PlatForm;

/**
 * 
   * @ClassName: SelectPlatFormDAO
   * @Description: TODO
   * @author Comsys-axin
   * @date 2013年12月29日 下午10:44:21
   *
 */
@Repository
@SuppressWarnings("all")
public class SelectPlatFormDAO extends BaseDAO implements ISelectPlatFormDAO  {
	
	private String allPlatFormListQuery;
	
	
	public String getAllPlatFormListQuery() {
		return allPlatFormListQuery;
	}

	public void setAllPlatFormListQuery(String allPlatFormListQuery) {
		this.allPlatFormListQuery = allPlatFormListQuery;
	}

	public void savePlatForm(PlatForm platForm ) throws Exception{
		System.out.println("PlatName"+platForm.getPlatName());
		
//		Authorities userObj = new Authorities();
//		userObj.setUserName("deng");
//		userObj.setPassword("123456");
//		userObj.setCreateTime(new Timestamp(System.currentTimeMillis()));//new java.util.Date().getTime())
//		userObj.setAccountNonExpired(true);
//		userObj.setAccountNonLocked(true);
//		userObj.setCredentialsNonExpired(true);
//		userObj.setEnabled(true);
//		userObj.setInfo("登录帐号");
		
		this.save(platForm);
	}
	
	public List getAllPlatFormList() throws Exception{
		System.out.println(allPlatFormListQuery);
		List list = this.query(allPlatFormListQuery, SQLType.SQL);
		return list;
	}

}
