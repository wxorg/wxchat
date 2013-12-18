package wx.com.service.cms;

import java.util.List;

import wx.com.entity.cms.index.Index;

/**
 * 
* @ClassName: IIndexManager 
* @Description: TODO 管理索引的接口方法
* @author jiang
* @date 2013-12-18 下午3:40:29 
*
 */
public interface IIndexManager {
	
	/**
	 * 
	* @Title: getIndex 
	* @Description: TODO 根据索引ID,以及微信公众平台的原始ID，来查询索引信息
	* @param @param id
	* @param @param origId
	* @param @return     
	* @return Index   
	* @throws
	 */
	public Index getIndex(String id,String origId);
	
	/**
	 * 
	* @Title: getIndexByKeyword 
	* @Description: TODO 通过关键词查询索引，模糊
	* @param @param word
	* @param @return     
	* @return List<Index>   
	* @throws
	 */
	public List<Index> getIndexByKeyword(String word,String origId);
	
	/**
	 * 
	* @Title: getIndexByMsgType 
	* @Description: TODO 通过 消息类型 后去索引  
	* @param @param msgType -1 消息类型  ；0 文本；1图片；2声音；3视频；4图文
	* @param @param origId
	* @param @return     
	* @return List<index>   
	* @throws
	 */
	public List<Index> getIndexByMsgType(byte msgType,String origId);
	
	/**
	 * 
	* @Title: getIndexByIndexType 
	* @Description: TODO 通过索引类型 获取索引
	* @param @param indexType -1索引类型   0关注索引  1关键词索引  2搜索索引   3 默认索引
	* @param @param origId
	* @param @return     
	* @return List<Index>   
	* @throws
	 */
	public List<Index> getIndexByIndexType(byte indexType,String origId);
	
	/**
	 * 
	* @Title: getAllIndex 
	* @Description: TODO 得到当前账号的所有索引
	* @param @param origId
	* @param @return     
	* @return List<Index>   
	* @throws
	 */
	public List<Index> getAllIndex(String origId);
	
	/**
	 * 
	* @Title: getAllIndex 
	* @Description: TODO 得到所有平台的索引
	* @param @param origId
	* @param @return     
	* @return List<Index>   
	* @throws
	 */
	public List<Index> getAllIndex();
	
	/**
	 * 
	* @Title: addIndex 
	* @Description: TODO 增加索引
	* @param @param index
	* @param @param origId
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean addIndex(Index index,String origId);
	
	/**
	 * 
	* @Title: editIndex 
	* @Description: TODO 编辑索引
	* @param @param indexId 索引唯一标示
	* @param @param index
	* @param @param origId
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean editIndex(String indexId,Index index ,String origId);
	
	/**
	 * 
	* @Title: delIndex 
	* @Description: TODO 删除索引
	* @param @param indexId
	* @param @param origId
	* @param @return     
	* @return boolean   
	* @throws
	 */
	public boolean delIndex(String indexId,String origId);

}
