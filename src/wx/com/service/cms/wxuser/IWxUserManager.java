package wx.com.service.cms.wxuser;

import java.util.List;

import wx.com.entity.cms.wxuser.WxUser;

/**
 * 
* @ClassName: IWxUserManager 
* @Description: TODO 管理公众平台关注用户
* @author jiang
* @date 2013-12-18 下午5:29:43 
*
 */
public interface IWxUserManager {
	
	/**
	 * 
	* @Title: getWxUserById 
	* @Description: TODO 通过id查看 wxuser
	* @param @param id
	* @param @return     
	* @return List<WxUser>   
	* @throws
	 */
	public List<WxUser> getWxUserById(String id,String origId);
	
	/**
	 * 
	* @Title: getWxUserByNickName 
	* @Description: TODO 通过 微信号
	* @param @param nickName
	* @param @param origId
	* @param @return     
	* @return List<WxUser>   
	* @throws
	 */
	public List<WxUser> getWxUserByNickName(String nickName,int i);
	
	/**
	 * 
	* @Title: getWxUserByOPenId 
	* @Description: TODO 通过OpenId
	* @param @param openId
	* @param @param origId
	* @param @return     
	* @return List<WxUser>   
	* @throws
	 */
	public List<WxUser> getWxUserByOPenId(String openId,String origId);
	
	/**
	 * 
	* @Title: getAllWxUser 
	* @Description: TODO 获得所有的用户
	* @param @param origId
	* @param @return     
	* @return List<WxUser>   
	* @throws
	 */
	public List<WxUser> getAllWxUser(int i);

}
