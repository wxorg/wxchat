package wx.com.dao.plat;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import wx.com.common.SQLType;
import wx.com.common.util.StringFormatSQL;
import wx.com.dao.base.BaseDAO;
import wx.com.entity.cms.auth.Authorities;
import wx.com.entity.cms.plat.PlatForm;

import org.acegisecurity.AuthenticationException;

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

	public void savePlatForm(PlatForm platForm ) throws Exception{
		//System.out.println("PlatName"+platForm.getPlatName());
		this.save(platForm);
	}
	
	//@Override
	public void updatePlatForm(PlatForm platForm) throws Exception{
		this.update(platForm);
	}
	
	public PlatForm getPlatFormById(int platid) throws Exception {
		return (PlatForm) this.queryByID(PlatForm.class, platid);
	}
	
	
	private String allPlatFormListQuery;
	
	public String getAllPlatFormListQuery() {
		return allPlatFormListQuery;
	}

	public void setAllPlatFormListQuery(String allPlatFormListQuery) {
		this.allPlatFormListQuery = allPlatFormListQuery;
	}
	
	public List getAllPlatFormList() throws Exception{
		System.out.println(allPlatFormListQuery);
		List list = this.query(allPlatFormListQuery, SQLType.SQL);
		return list;
	}
	
	private String isExistPlatFormQuery;


	public String getIsExistPlatFormQuery() {
		return isExistPlatFormQuery;
	}

	public void setIsExistPlatFormQuery(String isExistPlatFormQuery) {
		this.isExistPlatFormQuery = isExistPlatFormQuery;
	}
	
	public boolean searchIsExistPlatForm(String platname,String wxCode,String origId,int platId) throws Exception{
		String stringSQL=StringFormatSQL.format(isExistPlatFormQuery,platname, wxCode,origId,platId);
		System.out.println(stringSQL);
		List list = this.query(stringSQL, SQLType.SQL);
		boolean flag=false;
		if(list.size()>0){
			Map _map=(Map)list.get(0);
			System.out.println("NUMS="+_map.get("NUMS").toString());
			if(!_map.get("NUMS").toString().equals("0")){
				flag=true;
			}
		}
		
		return flag;
	}//searchIsExistPlatForm -- end

}
