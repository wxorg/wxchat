package wx.com.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.MappedSuperclass;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import wx.com.common.SQLType;
import wx.com.common.util.StringFormatSQL;

@SuppressWarnings("all")
@MappedSuperclass
public class BaseDAO   {
	
	protected Session session;
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession() throws Exception{
		try {
			if(session==null || !session.isOpen())				
				session=sessionFactory.getCurrentSession();
			
			
			return session;
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}
	
	/**
	 * insert record by primary key
	 * 
	 * @param obj
	 * @return primary key
	 * @throws Exception
	 */
	
	public Serializable save(Object obj) throws Exception {
		try {
			//session=null;
			getSession();
			Serializable _serializable = session.save(obj);
			System.out.println("serializable="+_serializable);
			//session.flush();
			return _serializable;
			
		} catch (Exception e) {
			throw e;
		} finally {
			//closeSession(flag);
		}
	}
	
	public Serializable saveClob(Object obj) throws Exception {
		try {
			getSession();
			Serializable _serializable = session.save(obj);
			
			return _serializable;
		} catch (Exception e) {
			throw e;			
		} finally {
			//closeSession(flag);
		}
	}

	/**
	 * update record by primary key
	 * 
	 * @param obj
	 * @return true or false
	 * @throws Exception
	 */
	public boolean update(Object obj) throws Exception {
		try {
			getSession();
			session.update(obj);
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			//closeSession(flag);
		}
	}

	/**
	 * delete record by primary key
	 * 
	 * @param obj
	 * @return true or false
	 * @throws Exception
	 */
	public boolean delete(Object obj) throws Exception {
		try {
			getSession();
			session.delete(obj);
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			//closeSession(flag);
		}
	}

	/**
	 * get record by primary key
	 * 
	 * @param tableClass
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Object queryByID(Class tableClass, Serializable id) throws Exception {
		try {
			getSession();
			Object object = session.get(tableClass, id);
			return object;
		} catch (Exception e) {
			throw e;
		} finally {
			//closeSession(flag);
		}
	}
	
	
	/**
	 * query list by sql or hql
	 * 
	 * @param queryString
	 * @param sqlType
	 * @return
	 * @throws Exception
	 */
	public List query(String queryString, SQLType sqlType) throws Exception {
		try {
			getSession();
			Query query;
			if (sqlType == SQLType.SQL) {
				query = session.createSQLQuery(queryString)
						.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				//System.out.println("aa:"+queryString);
			} else {
				System.out.println(queryString);
				query = session.createQuery(queryString);
				
			}
			List list = query.list();
			return list;
		} catch (Exception e) {
			//flag = false;
			throw e;
		} finally {
			//closeSession(flag);
		}
	}
	
	/**
	 * 
	* @Title: queryPage 
	* @Description: TODO
	* @param @param queryString
	* @param @param sqlType
	* @param @param firstN
	* @param @param maxN
	* @param @return
	* @param @throws Exception   
	* @return List
	* @throws
	 */
	public List queryPage(String queryString, SQLType sqlType,int firstN,int maxN) throws Exception {
		try {
			getSession();
			Query query;
			if (sqlType == SQLType.SQL) {
				query = session.createSQLQuery(queryString)
						.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				//System.out.println("aa:"+queryString);
			} else {
				System.out.println(queryString);
				query = session.createQuery(queryString);
			}
			query.setFirstResult((firstN-1)*maxN);
            query.setMaxResults(maxN);
			List list = query.list();
			return list;
		} catch (Exception e) {
			//flag = false;
			throw e;
		} finally {
			//closeSession(flag);
		}
	}
	
	/**
	 * 
	* @Title: formatString 
	* @Description: TODO
	* @param @param string
	* @param @param args
	* @param @return   
	* @return String
	* @throws
	 */
	
	public String formatString(String string, Object... args) {
		return StringFormatSQL.format(string, args);
	}

}
