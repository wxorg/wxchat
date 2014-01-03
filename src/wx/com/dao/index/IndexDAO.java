package wx.com.dao.index;

import java.util.List;
import java.util.Map;

import wx.com.common.SQLType;
import wx.com.common.util.StringFormatSQL;
import wx.com.dao.base.BaseDAO;
import wx.com.entity.cms.index.Index;

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
	

}
