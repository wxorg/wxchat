package wx.com.service.cms.wxuser;

import java.util.List;

import wx.com.entity.CustomDialog;

public interface IWxUserCustomManager {
	
	
	/**
	 * 
	* @Title: getDialogByOpenId 
	* @Description: TODO 通过 微信号的openid查找 客服记录
	* @param @param openId
	* @param @param platId
	* @param @return     
	* @return List<CustomDialog>   
	* @throws
	 */
	public List<CustomDialog> getDialogByOpenId(String openId,int platId);
	
	
	/**
	 * 
	* @Title: replyDalog 
	* @Description: TODO 回复客户信息
	* @param @param openId
	* @param @param platId
	* @param @param content 暂时表示文本内容，后面添加 加图文id
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean replyDalog(String openId,int platId,String content);
	
	
	
	
	

}
