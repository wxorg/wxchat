package wx.com.dao;

import wx.com.entity.event.Msg_Event;

public interface IMsgDAO {
	
	public boolean save(Object obj);
	public String getIndex(int i);
	
	public boolean updateSub(Msg_Event event_sub);
	
	public boolean saveLocation(Msg_Event event_sub);
	
	

}
