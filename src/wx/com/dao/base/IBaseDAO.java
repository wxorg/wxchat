package wx.com.service.base;

import java.io.Serializable;

public interface IBaseDAO extends Serializable  {
	
	public Serializable save(Object obj) throws Exception;
	public Serializable saveClob(Object obj) throws Exception;
	/**
	 * update record by primary key
	 * 
	 * @param obj
	 * @return true or false
	 * @throws Exception
	 */
	public boolean update(Object obj) throws Exception;
	/**
	 * delete record by primary key
	 * 
	 * @param obj
	 * @return true or false
	 * @throws Exception
	 */
	public boolean delete(Object obj) throws Exception;
	/**
	 * get record by primary key
	 * 
	 * @param tableClass
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Object queryByID(Class<?> tableClass, Serializable id) throws Exception;

}
