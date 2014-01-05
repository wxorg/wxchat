package wx.com.dao.index;

import java.util.List;

import wx.com.entity.cms.index.Index;
import wx.com.entity.cms.menu.WXDBMenu;

/**
 * 
   * @ClassName: IIndexDAO
   * @Description: TODO
   * @author Comsys-axin
   * @date 2014年1月3日 上午12:11:36
   *
 */
@SuppressWarnings("rawtypes")
public interface IIndexDAO {
	
	/**
	 * 
	* @Title: isExistIndex 
	* @Description: TODO
	* @param @param index
	* @param @return
	* @param @throws Exception   
	* @return boolean
	* @throws
	 */
	public boolean isExistIndex(Index index) throws Exception;
	
	/**
	 * 
	* @Title: addIndex 
	* @Description: TODO
	* @param @param index
	* @param @return
	* @param @throws Exception   
	* @return boolean
	* @throws
	 */
	public  boolean addIndex(Index index) throws Exception;
	
	/**
	 * 
	* @Title: getIndexBySelect 
	* @Description: TODO
	* @param @param word
	* @param @param indexType
	* @param @param msgType
	* @param @param numPerpage
	* @param @param page
	* @param @param origId
	* @param @return
	* @param @throws Exception   
	* @return List
	* @throws
	 */
	
	public List getIndexBySelect(String whereQuery,int numPerpage,int curPage, int platId) throws Exception ;

	/**
	 * 
	* @Title: queryIndexCountByArgs 
	* @Description: TODO
	* @param @param whereQuery
	* @param @param platId
	* @param @return
	* @param @throws Exception   
	* @return int
	* @throws
	 */
	public int queryIndexCountByArgs(String whereQuery, int platId) throws Exception;
	
	/**
	 * 
	* @Title: queryMenuByPlatID 
	* @Description: TODO
	* @param @param platId
	* @param @return
	* @param @throws Exception   
	* @return List
	* @throws
	 */
	public List queryMenuByPlatID(int platId) throws Exception;
	
	/**
	 * 
	* @Title: saveOrUpdateMenu 
	* @Description: TODO
	* @param @param menu
	* @param @return
	* @param @throws Exception   
	* @return boolean
	* @throws
	 */
	public boolean saveOrUpdateMenu(WXDBMenu menu,int dealFlag) throws Exception;
	

}
