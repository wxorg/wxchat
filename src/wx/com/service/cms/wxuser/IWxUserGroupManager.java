package wx.com.service.cms.wxuser;

import java.util.List;

import wx.com.entity.cms.wxuser.WxUser;
import wx.com.entity.cms.wxuser.WxUserGroup;

public interface IWxUserGroupManager {
	
	/**
	 * 
	* @Title: getAllUserGroup 
	* @Description: TODO 获取当前平台的 所有分组
	* @param @param GroupName
	* @param @return     
	* @return List<WxUserGroup>   
	* @throws
	 */
	public List<WxUserGroup> getAllUserGroup(String origId);
	
	/**
	 * 
	* @Title: addUserGroup 
	* @Description: TODO 添加分组  这里需要平台原始ID
	* @param @param wxUsrGrouop
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean addUserGroup(WxUserGroup wxUsrGrouop,String origId);
	
	/**
	 * 
	* @Title: editUserGroup 
	* @Description: TODO 编辑分组
	* @param @param groupId
	* @param @param wxUsrGroup
	* @param @param origId
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean editUserGroup(String groupId,WxUserGroup wxUsrGroup );
	
	/**
	 * 
	* @Title: delUserGroup 
	* @Description: TODO 删除分组
	* @param @param groupId
	* @param @param origId
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean delUserGroup(String groupId);
	
	

}
