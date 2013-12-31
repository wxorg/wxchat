package wx.com.service.cms.plat;

import java.util.List;

import wx.com.entity.cms.plat.PlatForm;

public interface ISelectPlatFormManager {
	
	/**
	 * 
	* @Title: getPlatFormList 
	* @Description: TODO 获取所有的公众账号
	* @param @param origId
	* @param @return     
	* @return List<PlatForm>   
	* @throws
	 */
	public List<wx.com.entity.cms.plat.PlatForm> getPlatFormList();
	
	
	/**
	 * 
	* @Title: getPlatFormById 
	* @Description: TODO 通过 原始ID 获取公众平台
	* @param @param origId
	* @param @return     
	* @return PlatForm   
	* @throws
	 */
	public PlatForm getPlatFormById(String origId);
	
	
	/**
	 * 
	* @Title: addPlatForm 
	* @Description: TODO 新接入一个公众平台
	* @param @param platForm
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean addPlatForm(PlatForm platForm);
	
	/**
	 * 
	* @Title: editPlatForm 
	* @Description: TODO 编辑公众平台信息
	* @param @param origId
	* @param @param platForm
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean editPlatForm(int platId,PlatForm platForm);
	
	/**
	 * 
	* @Title: delPlatForm 
	* @Description: TODO 删除公众平台
	* @param @param origId
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean delPlatForm(String origId, PlatForm platForm);
	
	/**
	 * 
	* @Title: searchPlatForm 
	* @Description: TODO
	* @param @param platname
	* @param @param wxCode
	* @param @param origId
	* @param @return   
	* @return boolean
	* @throws
	 */
	public boolean searchPlatForm(String platname,String wxCode,String origId,int platId);
	
	/**
	 * 
	* @Title: getPlatFormById 
	* @Description: TODO
	* @param @param platid
	* @param @return
	* @param @throws Exception   
	* @return PlatForm
	* @throws
	 */
	public PlatForm getPlatFormById(int platid) throws Exception ;

}
