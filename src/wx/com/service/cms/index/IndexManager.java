package wx.com.service.cms.index;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import wx.com.dao.index.IIndexDAO;
import wx.com.entity.cms.index.Index;

public class IndexManager implements IIndexManager {
	
	@Resource
	private IIndexDAO indexDAO;

	@Override
	public Index getIndex(String id,int origId) {
		// TODO Auto-generated method stub
		
		/*Index index = new Index();
		index.setId("123");
		index.setIndexType((byte) 2);
		index.setMsgType((byte)2);
		index.setCreatTime(3242344L);*/
		
		return null;
	}

	@Override
	public List<Index> getIndexByKeyword(String word, int origId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Index> getIndexByMsgType(byte msgType, int origId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Index> getIndexByIndexType(byte indexType, int origId) {
		// TODO Auto-generated method stub
		return new ArrayList();
	}

	@Override
	public List<Index> getAllIndex(int origId) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public List<Index> getAllIndex() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isExistIndex(Index index){
		try {
			return indexDAO.isExistIndex(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}

	@Override
	public boolean addIndex(Index index) {
		// TODO Auto-generated method stub
		try {
			return indexDAO.addIndex(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editIndex(String indexId, Index index, int origId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delIndex(String indexId, int origId) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("all")
	@Override
	public Map getIndexBySelect(String whereQuery,int numPerpage,int curPage,int platId) {
		// TODO Auto-generated method stub
		
		Map map = new HashMap();
		try{
			int totlepage= indexDAO.queryIndexCountByArgs(whereQuery,platId)/numPerpage +1;
			//System.out.println("totlepage="+totlepage);
			List list = indexDAO.getIndexBySelect(whereQuery, numPerpage, curPage, platId);
			//System.out.println("list size="+list.size());
			/*for(int i=0;i<list.size();i++){
				Index index = (Index)list.get(i);
				System.out.println(index.getKeyWord()+"=="+index.getText());
				
			}*/
			map.put("indexlist", list);
			map.put("totlepage",totlepage);
			map.put("currpage",curPage);
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		return map;

	}

	public IIndexDAO getIndexDAO() {
		return indexDAO;
	}

	public void setIndexDAO(IIndexDAO indexDAO) {
		this.indexDAO = indexDAO;
	}
	
	



	
}
