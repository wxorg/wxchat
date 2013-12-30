package wx.com.service.cms.auth;

import wx.com.entity.cms.auth.Authorities;

/**
 * 
   * @ClassName: ILoginManager
   * @Description: TODO
   * @author Comsys-axin
   * @date 2013年12月28日 下午3:08:22
   *
 */
public interface ILoginManager {
	
	/**
	 * 
	* @Title: getAuthUserDetail 
	* @Description: TODO
	* @param @param username
	* @param @return   
	* @return AuthUserDetail
	* @throws
	 */
	public Authorities getAuthUserDetail(String username) throws Exception;
	
	/**
	 * 
	* @Title: SaveAuthUserDetail 
	* @Description: TODO
	* @param @param user   
	* @return void
	* @throws
	 */
	public void SaveAuthUserDetail(Authorities user) throws Exception;
}
