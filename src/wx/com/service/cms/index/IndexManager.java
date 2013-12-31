package wx.com.service.cms.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wx.com.entity.cms.index.Index;

public class IndexManager implements IIndexManager {

	@Override
	public Index getIndex(String id,int origId) {
		// TODO Auto-generated method stub
		
		Index index = new Index();
		index.setId("123");
		index.setIndexType((byte) 2);
		index.setMsgType((byte)2);
		index.setCreatTime(3242344L);
		
		return index;
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
		return null;
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
	public boolean addIndex(Index index, int origId) {
		// TODO Auto-generated method stub
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

	@Override

	public Map getIndexBySelect(String word, byte indexType,
			byte msgType,int numPerpage,int page, int origId) {
		// TODO Auto-generated method stub
		
		Map map = new HashMap();
		map.put("indexlist", new ArrayList());
		map.put("totle",11);
		map.get("totle");
		return map;

	}



	
}
