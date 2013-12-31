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
	
	@SuppressWarnings("rawtypes")
	public List getAllPlatFormList() throws Exception; 

}
