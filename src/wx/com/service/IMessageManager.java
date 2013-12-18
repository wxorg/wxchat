package wx.com.service;

import wx.com.entity.InMessage;


/**
 * 
* @ClassName: IMessageManager 
* @Description: TODO 处理接收信息 
* @author jiang
* @date 2013-12-18 下午5:54:44 
*
 */
public interface IMessageManager {
	
	/**
	 * 
	* @Title: msg_Handler 
	* @Description: TODO msg 已经从xml转换过来，这个是统一处理入口
	* @param @param msg
	* @param @return     
	* @return String   
	* @throws
	 */
	public String msg_Handler(InMessage msg);


}
