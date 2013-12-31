package wx.com.dao.plat;

import java.util.List;

import wx.com.entity.cms.plat.PlatForm;

/**
 * 
   * @ClassName: ISelectPlatFormDAO
   * @Description: TODO
   * @author Comsys-axin
   * @date 2013年12月29日 下午10:45:11
   *
 */

public interface ISelectPlatFormDAO {
	
	/**
	 * 
	* @Title: savePlatForm 
	* @Description: TODO
	* @param @param platForm
	* @param @throws Exception   
	* @return void
	* @throws
	 */
	public void savePlatForm(PlatForm platForm ) throws Exception;
	
	/**
	 * 
	* @Title: updatePlatForm 
	* @Description: TODO
	* @param @param platForm
	* @param @throws Exception   
	* @return void
	* @throws
	 */
	public void updatePlatForm(PlatForm platForm) throws Exception;
	
	public PlatForm getPlatFormById(int platid) throws Exception;
	
	
	/**
	 * 
	* @Title: getAllPlatFormList 
	* @Description: TODO
	* @param @return
	* @param @throws Exception   
	* @return List
	* @throws
	 */
	@SuppressWarnings("rawtypes")
	public List getAllPlatFormList() throws Exception; 
	
	/**
	 * 
	* @Title: searchIsExistPlatForm 
	* @Description: TODO
	* @param @param platname
	* @param @param wxCode
	* @param @param origId
	* @param @return
	* @param @throws Exception   
	* @return boolean
	* @throws
	 */
	public boolean searchIsExistPlatForm(String platname,String wxCode,String origId,int platId) throws Exception;

}
