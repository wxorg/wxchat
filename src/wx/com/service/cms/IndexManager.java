package wx.com.service.cms;

import wx.com.entity.cms.index.Index;

public class IndexManager implements IIndexManager {

	@Override
	public Index getIndex(String id) {
		// TODO Auto-generated method stub
		
		Index index = new Index();
		index.setId("123");
		index.setIndexType((byte) 2);
		index.setMsgType((byte)2);
		index.setCreatTime(3242344L);
		
		return index;
	}

}
