package cn.longskyer.common.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import cn.longskyer.common.util.Pager;

/**   
 * @ClassName:  IDao   
 * @Description:TODO  此接口从mybatis的sqlsession接口里面摘取出来的部分函数并且有所修改和增加
 * @author: longskyer 2503802889@qq.com
 * @date:   2018年7月9日 下午3:32:54        
 */
public interface IDao {

	/**   
	 * @Title: selectOne   
	 * @Description: TODO 查询符合条件的第一条记录
	 * @param: @param statement 查询语句的唯一id
	 * @param: @return 映射对象    
	 * @return: Object      
	 * @throws   
	 */
	Object selectOne(String statement) throws Exception;

	/**   
	 * @Title: selectOne   
	 * @Description: TODO 查询符合条件的第一条记录
	 * @param: @param statement 查询语句的唯一id
	 * @param: @param parameter 查询参数
	 * @param: @return  映射对象   
	 * @return: Object      
	 * @throws   
	 */
	Object selectOne(String statement, Object parameter) throws Exception;

	/**   
	 * @Title: selectList   
	 * @Description: TODO 查询列表数据
	 * @param: @param statement 查询语句的唯一id
	 * @param: @return 列表数据   
	 * @return: List<Object>      
	 * @throws   
	 */
	List<Object> selectList(String statement) throws Exception;


	/**   
	 * @Title: selectList   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @return      
	 * @return: List<Object>      
	 * @throws   
	 */
	List<Object> selectList(String statement, Object parameter) throws Exception;

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
	List<Object> selectList(String statement, Object parameter, RowBounds rowBounds) throws Exception;
	 
	/**   
	 * @Title: selectMap   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param mapKey
	 * @param: @return      
	 * @return: Map<Object,Object>      
	 * @throws   
	 */
	Map<Object,Object> selectMap(String statement, String mapKey) throws Exception;

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
	Map<Object,Object> selectMap(String statement, Object parameter, String mapKey) throws Exception;

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
	Map<Object,Object> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) throws Exception;
	
	/**   
	 * @Title: select   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @param handler  ResultHandler that will handle each retrieved row    
	 * @return: void      
	 * @throws   
	 */
	void select(String statement, Object parameter, ResultHandler handler) throws Exception;	
	/**   
	 * @Title: select   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param handler   ResultHandler that will handle each retrieved row   
	 * @return: void      
	 * @throws   
	 */
	void select(String statement, ResultHandler handler) throws Exception;
	
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
	void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) throws Exception;

	/**   
	 * @Title: insert   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int insert(String statement) throws Exception;

	/**   
	 * @Title: insert   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int insert(String statement, Object parameter) throws Exception;

	  
	/**   
	 * @Title: update   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int update(String statement) throws Exception;
  
	/**   
	 * @Title: update   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int update(String statement, Object parameter) throws Exception;
	 
	/**   
	 * @Title: delete   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int delete(String statement) throws Exception;

	/**   
	 * @Title: delete   
	 * @Description: TODO
	 * @param: @param statement
	 * @param: @param parameter
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int delete(String statement, Object parameter) throws Exception;
	
	/**
	 * 根据ID获取对象
	 * @param statementName sql语句id
	 * @param id 对象主键
	 * @return 获取对象
	 */
	Object selectById(String statement,Object id) throws Exception;
	
	/**
     * 根据参数获取对象
     * @param statementName sql语句id
     * @param obj 参数对象
     * @return 获取对象
     */
	Object selectObject(String statement, Object obj) throws Exception;
	
	/**
	 * 根据ID判断对象是否存在
	 * @param statementName sql语句id
	 * @param id 对象主键
	 * @return true:对象存在 false:对象不存在
	 */
	boolean exists(String statement,Object id) throws Exception;
	

    /**   
     * @Title: pagerQuery   
     * @Description: TODO
     *                分页查询函数
     * @param: @param statement
     *                查询语句的id
     * @param: @param pager
     *                 分页对象
     * @param: @return      
     * @return: Pager      
     * @throws   
     */
    Pager pagerQuery(String statement, Pager pager) throws Exception;
    
    /**
	 * 查询数量
	 * @param statementName sql id
	 * @param parameter    查询条件对象
	 * @return             count
	 */
	long selectCount(String statement,Object parameter) throws Exception;
	
	/**
	 * 调用存储过程,通过jdbc的方式调用
	 * 
	 * @param procedureName
	 *   过程名称
	 * @param values
	 *   过程参数
	 */
	void executeProcedure(String procedure, Map map) throws Exception;
	
	/** 
	 *  批量插入
     * @param str 
     * @param objs 
     * @return 
     * @throws Exception 
     */  
    Object batchInsert(String statement, List<Object> objs )throws Exception;  
    /**   
     * @Title: batchUpdate   
     * @Description: TODO 批量更新
     * @param: @param str
     * @param: @param objs
     * @param: @throws Exception      
     * @return: void      
     * @throws   
     */
    void batchUpdate(String str, List<Object>objs )throws Exception;
    /**   
     * @Title: batchDelete   
     * @Description: TODO 批量删除
     * @param: @param str
     * @param: @param objs
     * @param: @return
     * @param: @throws Exception      
     * @return: Object      
     * @throws   
     */
    Object batchDelete(String str, List<Object> objs )throws Exception;

}
