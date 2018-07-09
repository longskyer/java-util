package cn.longskyer.common.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cn.longskyer.common.util.Pager;

@Repository("baseDao")
public class BaseDao implements IDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**   
	 * @Title: selectOne   
	 * @Description: TODO 查询符合条件的第一条记录
	 * @param: @param statement 查询语句的唯一id
	 * @param: @return 映射对象    
	 * @return: Object      
	 * @throws   
	 */
	public Object selectOne(String statement) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(statement);
	}

	/**   
	 * @Title: selectOne   
	 * @Description: TODO 查询符合条件的第一条记录
	 * @param: @param statement 查询语句的唯一id
	 * @param: @param parameter 查询参数
	 * @param: @return  映射对象   
	 * @return: Object      
	 * @throws   
	 */
	public Object selectOne(String statement, Object parameter) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(statement, parameter);
	
	}

	/**   
	 * @Title: selectList   
	 * @Description: TODO 查询列表数据
	 * @param: @param statement 查询语句的唯一id
	 * @param: @return 列表数据   
	 * @return: List<Object>      
	 * @throws   
	 */
	public List<Object> selectList(String statement) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(statement);
	}

	/**   
	 * @Title: selectList   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @return      
	 * @return: List<Object>      
	 * @throws   
	 */
	public List<Object> selectList(String statement, Object parameter) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(statement, parameter);
	}

	/**   
	 * @Title: selectList   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @param rowBounds
	 * @param: @return      
	 * @return: List<Object>      
	 * @throws   
	 */
	public List<Object> selectList(String statement, Object parameter, RowBounds rowBounds) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(statement, parameter, rowBounds);
	}

	/**   
	 * @Title: selectMap   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param mapKey
	 * @param: @return      
	 * @return: Map<Object,Object>      
	 * @throws   
	 */
	public Map<Object, Object> selectMap(String statement, String mapKey) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectMap(statement, mapKey);
	}

	/**   
	 * @Title: selectMap   
	 * @Description: The selectMap is a special case in that it is designed to convert a list
     * of results into a Map based on one of the properties in the resulting objects.
     * Eg. Return a of Map[Integer,Author] for selectMap("selectAuthors","id")
	 * @param: @param statement 查询语句的唯一id
	 * @param: @param parameter 查询参数
	 * @param: @param mapKey The property to use as key for each value in the list
	 * @param: @return containing key pair data   
	 * @return: Map<Object,Object>      
	 * @throws   
	 */
	public Map<Object, Object> selectMap(String statement, Object parameter, String mapKey) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey);
	}

	/**   
	 * @Title: selectMap   
	 * @Description: The selectMap is a special case in that it is designed to convert a list
     * of results into a Map based on one of the properties in the resulting objects.
     * Eg. Return a of Map[Integer,Author] for selectMap("selectAuthors","id")
	 * @param: @param statement 查询语句的唯一id
	 * @param: @param parameter 查询参数
	 * @param: @param mapKey The property to use as key for each value in the list
	 * @param: @param rowBounds Bounds to limit
	 * @param: @return      
	 * @return: Map<Object,Object>      
	 * @throws   
	 */
	public Map<Object, Object> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey);
	}

	/**   
	 * @Title: select   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @param handler  ResultHandler that will handle each retrieved row    
	 * @return: void      
	 * @throws   
	 */
	public void select(String statement, Object parameter, ResultHandler handler) throws Exception{
		// TODO Auto-generated method stub
		sqlSessionTemplate.select(statement, parameter, handler);

	}

	/**   
	 * @Title: select   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param handler   ResultHandler that will handle each retrieved row   
	 * @return: void      
	 * @throws   
	 */
	public void select(String statement, ResultHandler handler) throws Exception{
		// TODO Auto-generated method stub
		sqlSessionTemplate.select(statement, handler);
	}

	/**   
	 * @Title: select   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @param rowBounds
	 * @param: @param handler  ResultHandler that will handle each retrieved row   
	 * @return: void      
	 * @throws   
	 */
	public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) throws Exception{
		// TODO Auto-generated method stub
		sqlSessionTemplate.select(statement, parameter, rowBounds, handler);
	}

	/**   
	 * @Title: insert   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	public int insert(String statement) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(statement);
	}

	/**   
	 * @Title: insert   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	public int insert(String statement, Object parameter) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(statement, parameter);
	}

	/**   
	 * @Title: update   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	public int update(String statement) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(statement);
	}

	/**   
	 * @Title: update   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	public int update(String statement, Object parameter) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(statement, parameter);
	}

	/**   
	 * @Title: delete   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	public int delete(String statement) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(statement);
	}

	/**   
	 * @Title: delete   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	public int delete(String statement, Object parameter) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(statement, parameter);
	}

	/**
	 * 根据ID获取对象
	 * @param statementName sql语句id
	 * @param id 对象主键
	 * @return 获取对象
	 */
	public Object selectById(String statement, Object id) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(statement, id);
	}

	/**   
	 * <p>Title: selectObject</p>   
	 * <p>Description: 根据参数获取对象</p>   
	 * @param statement
	 * @param parameter
	 * @return
	 * @throws Exception   
	 * @see cn.longskyer.common.dao.IDao#selectObject(java.lang.String, java.lang.Object)   
	 */
	public Object selectObject(String statement, Object parameter) throws Exception{
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(statement, parameter);
	}

	/**   
	 * <p>Title: exists</p>   
	 * <p>Description: </p>   
	 * @param statement
	 * @param id
	 * @return
	 * @throws Exception   
	 * @see cn.longskyer.common.dao.IDao#exists(java.lang.String, java.lang.Object)   
	 */
	public boolean exists(String statement, Object id) throws Exception{
		// TODO Auto-generated method stub
		List<Object> list=sqlSessionTemplate.selectList(statement, id);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}

	/**   
	 * <p>Title: pagerQuery</p>   
	 * <p>Description: </p>   
	 * @param statement
	 * @param pager
	 * @return
	 * @throws Exception   
	 * @see cn.longskyer.common.dao.IDao#pagerQuery(java.lang.String, cn.longskyer.common.util.Pager)   
	 */
	public Pager pagerQuery(String statement, Pager pager) throws Exception{
		// TODO Auto-generated method stub
		List<Object> list=sqlSessionTemplate.selectList(statement, pager,new RowBounds((int)pager.getStart(), (int)pager.getLimit()));
		if(list==null){
			list=new ArrayList();
		}
		pager.setRows(list);
		return pager;
	}

	/**   
	 * <p>Title: selectCount</p>   
	 * <p>Description: </p>   
	 * @param statementName
	 * @param parameter
	 * @return
	 * @throws Exception   
	 * @see cn.longskyer.common.dao.IDao#selectCount(java.lang.String, java.lang.Object)   
	 */
	public long selectCount(String statementName, Object parameter) throws Exception{
		// TODO Auto-generated method stub
		try {
			Long obj=sqlSessionTemplate.selectOne(statementName,parameter);
			return obj;
		} catch (NullPointerException e) {
			throw new RuntimeException("返回对象为空: " + statementName + "异常：" + e);
		} catch (ClassCastException e) {
			throw new RuntimeException("返回对象类型不为Long型: " + statementName + "异常：" + e);
		}
		
	}

	/**   
	 * <p>Title: executeProcedure</p>   
	 * <p>Description: </p>   
	 * @param procedureName
	 * @param map
	 * @throws Exception   
	 * @see cn.longskyer.common.dao.IDao#executeProcedure(java.lang.String, java.util.Map)   
	 */
	public void executeProcedure(String procedureName, Map map) throws Exception{
		// TODO Auto-generated method stub
		try {
			 sqlSessionTemplate.selectOne(procedureName, map);
		} catch (Exception e) {
			 throw new RuntimeException("执行存储过程异常: " + procedureName + "异常：" + e);
		}
		
	}

	/**   
	 * <p>Title: batchInsert</p>   
	 * <p>Description: </p>   
	 * @param statement
	 * @param objs
	 * @return
	 * @throws Exception   
	 * @see cn.longskyer.common.dao.IDao#batchInsert(java.lang.String, java.util.List)   
	 */
	public Object batchInsert(String statement, List<Object> objs) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(statement, objs); 
	}

	/**   
	 * <p>Title: batchUpdate</p>   
	 * <p>Description: </p>   
	 * @param str
	 * @param objs
	 * @throws Exception   
	 * @see cn.longskyer.common.dao.IDao#batchUpdate(java.lang.String, java.util.List)   
	 */
	public void batchUpdate(String str, List<Object> objs) throws Exception {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();  
        //批量执行器  
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);  
        try{  
            if(objs!=null){  
                for(int i=0,size=objs.size();i<size;i++){  
                    sqlSession.update(str, objs.get(i));  
                }  
                sqlSession.flushStatements();  
                sqlSession.commit();  
                sqlSession.clearCache();  
            }  
        }finally{  
            sqlSession.close();  
        }  
		
	}

	/**   
	 * <p>Title: batchDelete</p>   
	 * <p>Description: </p>   
	 * @param statement
	 * @param objs
	 * @return
	 * @throws Exception   
	 * @see cn.longskyer.common.dao.IDao#batchDelete(java.lang.String, java.util.List)   
	 */
	public Object batchDelete(String statement, List<Object> objs) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(statement, objs);  
	}

}
