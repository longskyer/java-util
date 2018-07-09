package cn.longskyer.common.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**   
 * @ClassName:  FastJsonUtil   
 * @Description:fastjson封装的json工具类 
 * @author: longskyer 2503802889@qq.com
 * @date:   2018年7月6日 下午4:26:48        
 */
public class FastJsonUtil {
	
	 /**   
	 * @Title: json2bean   
	 * @Description: 把JSON数据转换成指定的java对象
	 * @param: @param jsonString
	 * @param: @param clazz
	 * @param: @return      
	 * @return: T      
	 * @throws   
	 */
	public static <T> T json2bean(String jsonString, Class<T> clazz) {
	        return JSON.parseObject(jsonString, clazz);
	 }
	 
	 /**   
	 * @Title: bean2Json   
	 * @Description: 把java对象转换成JSON数据
	 * @param: @param object
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String bean2Json(Object object) {
	        return JSON.toJSONString(object);
	 }
	
	/**   
	 * @Title: json2List   
	 * @Description: 把JSON数据转换成指定的java对象列表
	 * @param: @param jsonString
	 * @param: @param clazz
	 * @param: @return      
	 * @return: List<T>      
	 * @throws   
	 */
	public static <T> List<T> json2List(String jsonString, Class<T> clazz) {
        return JSON.parseArray(jsonString, clazz);
    }
	
	/**   
	 * @Title: getJsonToListMap   
	 * @Description: TODO把JSON数据转换成较为复杂的List<Map<String, Object>>
	 * @param: @param jsonString
	 * @param: @return      
	 * @return: List<Map<String,Object>>      
	 * @throws   
	 */
	public static List<Map<String, Object>> getJsonToListMap(String jsonString) {
		return JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {});
    }

}
