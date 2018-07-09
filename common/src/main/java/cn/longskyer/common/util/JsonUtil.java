package cn.longskyer.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**   
 * @ClassName:  JsonUtil   
 * @Description:gson封装的json工具类  
 * @author: longskyer 2503802889@qq.com
 * @date:   2018年7月6日 下午4:27:36        
 */
public class JsonUtil {

	private static Gson gson = null;
    static {
        if (gson == null) {
            gson = new Gson();
        }
    }
    
    /**   
     * @Title: oject2json   
     * @Description: object类型转换成json
     * @param: @param object
     * @param: @return      
     * @return: String      
     * @throws   
     */
    public static String oject2Json(Object object) {
        String jsonString = null;
        if (gson != null) {
            jsonString = gson.toJson(object);
        }
        return jsonString;
    }
    
    /**   
     * @Title: jsonToOject   
     * @Description: 此方法未测试
     * @param: @param jsonString
     * @param: @return      
     * @return: Object      
     * @throws   
     */
    public static  Object json2Oject(String jsonString) {
        Object object = null;
        if (gson != null) {
            object = gson.fromJson(jsonString, Object.class);
        }
        return object;
    }
    
    public static <T> T json2Bean(String jsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(jsonString, cls);
        }
        return t;
    }
    
    public static String list2Json(List<?> list) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        return jsonString;
    }
    
    public static <T> List<T> json2List(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }
    
    /**   
     * @Title: json2ListMaps   
     * @Description: TODO转成list中有map的
     * @param: @param jsonString
     * @param: @return      
     * @return: List<Map<String,T>>      
     * @throws   
     */
    public static <T> List<Map<String, T>> json2ListMap(String jsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(jsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }
    
    public static <T> Map<String, T> json2Map(String jsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(jsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }








}
