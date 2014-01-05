package wx.com.dao.index;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import wx.com.common.SQLType;
import wx.com.common.util.StringFormatSQL;
import wx.com.dao.base.BaseDAO;
import wx.com.entity.cms.index.Index;
import wx.com.entity.cms.menu.WXDBMenu;

@SuppressWarnings("all")
public class IndexDAO extends BaseDAO implements IIndexDAO {
	
	private String isExistIndex;
	
	public String getIsExistIndex() {
		return isExistIndex;
	}

	public void setIsExistIndex(String isExistIndex) {
		this.isExistIndex = isExistIndex;
	}

	public boolean isExistIndex(Index index) throws Exception{
		String stringSQL=StringFormatSQL.format(isExistIndex,index.getIndexType(),index.getKeyWord(), index.getPlatId());
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
	}
	
	public  boolean addIndex(Index index) throws Exception{
		if((Integer)this.save(index)>0)
			return true;
		else 
			return false;
	}
	
	private String queryIndexByArgs;
	
	public String getQueryIndexByArgs() {
		return queryIndexByArgs;
	}

	public void setQueryIndexByArgs(String queryIndexByArgs) {
		this.queryIndexByArgs = queryIndexByArgs;
	}

	@SuppressWarnings("rawtypes")
	public List getIndexBySelect(String whereQuery,int numPerpage,int page, int platId) throws Exception {
             // TODO Auto-generated method stub
		String stringSQL=StringFormatSQL.format(queryIndexByArgs,platId,whereQuery);
		System.out.println(stringSQL);
        return this.queryPage(stringSQL, SQLType.HQL, page, numPerpage);
	}
	
	private String queryIndexCountByArgs;

	public String getQueryIndexCountByArgs() {
		return queryIndexCountByArgs;
	}

	public void setQueryIndexCountByArgs(String queryIndexCountByArgs) {
		this.queryIndexCountByArgs = queryIndexCountByArgs;
	}
	
	
	public int queryIndexCountByArgs(String whereQuery,int platId) throws Exception {
		String stringSQL=StringFormatSQL.format(queryIndexCountByArgs,platId,whereQuery);
		System.out.println(stringSQL);
		List list = this.query(stringSQL, SQLType.SQL);
		boolean flag=false;
		if(list.size()>0){
			Map _map=(Map)list.get(0);
			//System.out.println("map size="+_map.size()+"==="+_map.get("NUMS").toString());
			return Integer.valueOf(_map.get("NUMS").toString());
		}
		
		return -1;		
	}
	
	private String queryMenuByPlatID;

	public String getQueryMenuByPlatID() {
		return queryMenuByPlatID;
	}

	public void setQueryMenuByPlatID(String queryMenuByPlatID) {
		this.queryMenuByPlatID = queryMenuByPlatID;
	}
	
	public List queryMenuByPlatID(int platId) throws Exception {
		String stringSQL=StringFormatSQL.format(queryMenuByPlatID,platId);
		System.out.println(stringSQL);
        return this.query(stringSQL,SQLType.HQL); 
	}
	
	public boolean saveOrUpdateMenu(WXDBMenu menu,int dealFlag) throws Exception{
		
		if(dealFlag==0){
			Serializable _seria = this.save(menu);
		    if((Integer)_seria>0)
		    	return true;
		    else
		    	return false;
		}else{
		  return this.update(menu);
		}
	}
	

}
