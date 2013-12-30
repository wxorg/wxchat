package wx.com.service.cms.index;

import java.util.List;

import wx.com.entity.cms.index.Index;

public class IndexManager implements IIndexManager {

	@Override
	public Index getIndex(String id,String origId) {
		// TODO Auto-generated method stub
		
		Index index = new Index();
		index.setId("123");
		index.setIndexType((byte) 2);
		index.setMsgType((byte)2);
		index.setCreatTime(3242344L);
		
		return index;
	}

	@Override
	public List<Index> getIndexByKeyword(String word, String origId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Index> getIndexByMsgType(byte msgType, String origId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Index> getIndexByIndexType(byte indexType, String origId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Index> getAllIndex(String origId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Index> getAllIndex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addIndex(Index index, String origId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editIndex(String indexId, Index index, String origId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delIndex(String indexId, String origId) {
		// TODO Auto-generated method stub
		return false;
	}



	
}
