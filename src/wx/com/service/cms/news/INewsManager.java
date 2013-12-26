package wx.com.service.cms.news;

import java.util.List;

import wx.com.entity.send.Msg_News_Out;

public interface INewsManager {
	
	/**
	 * 
	* @Title: getMsgNewsAll 
	* @Description: TODO 获得该账号下的所有图文
	* @param @param origId
	* @param @return     
	* @return List<Msg_News_Out>   
	* @throws
	 */
	public List<Msg_News_Out> getMsgNewsAll(String origId);
	
	
	/**
	 * 
	* @Title: getMsgNewsById 
	* @Description: TODO 通过ID获得图文
	* @param @param id
	* @param @return     
	* @return Msg_News_Out   
	* @throws
	 */
	public Msg_News_Out getMsgNewsById(String id);
	
	/**
	 * 
	* @Title: AddMsgNews 
	* @Description: TODO 添加图文到素材库
	* @param @param msg
	* @param @param origId
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean AddMsgNews(Msg_News_Out msg ,String origId);
	
	/**
	 * 
	* @Title: EditMsgNews 
	* @Description: TODO 修改图文
	* @param @param id
	* @param @param msg
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean EditMsgNews(String id ,Msg_News_Out msg);
	
	/**
	 * 
	* @Title: DelMsgNews 
	* @Description: TODO 删除图文
	* @param @param id
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean DelMsgNews(String id);

}
