package wx.com.dao.auth;

import java.util.List;

import wx.com.entity.cms.auth.Authorities;


/**
 * 
   * @ClassName: ILoginDAO
   * @Description: TODO
   * @author Comsys-axin
   * @date 2013年12月28日 下午3:37:36
   *
 */
public interface  ILoginDAO {
	
	/**
	 * 
	* @Title: SaveAuthUserDetail 
	* @Description: TODO
	* @param @throws Exception   
	* @return void
	* @throws
	 */
	public void SaveAuthUserDetail(Authorities authuser ) throws Exception;
	
	/**
	 * 
	* @Title: getAuthUserDetail 
	* @Description: TODO
	* @param @param username
	* @param @return
	* @param @throws Exception   
	* @return AuthUserDetail
	* @throws
	 */
	public List getAuthUserDetail(String username) throws Exception;
}
