package cn.longskyer.common.util;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
	
    /**   
     * @ClassName:  DataCallBack   
     * @Description:TODO 数据回调接口 
     * @author: 黄飞龙 2503802889@qq.com 借鉴https://blog.csdn.net/lmj623565791/article/details/47911083
     * @date:   2018年7月8日 下午9:19:32        
     */
    public interface ResultCallback {

        void requestSuccess(String result) throws Exception;
        void requestFailure(Request request, IOException e);
    }

	private static OkHttpClient okHttpClient;
	private static HttpUtil httpUtil;
	
    private HttpUtil() {
    	//私有构造函数实现单例模式
    	okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
    }

    public static HttpUtil getInstance() {
        if (httpUtil == null) {
            httpUtil=new HttpUtil();
        }
        return httpUtil;
    }
    
    /**
     * *********************内部使用的函数由此 开始********************
     */
    /**   
     * @Title: _getSyn   
     * @Description: TODO 同步的Get请求
     * @param: @param url
     * @param: @return
     * @param: @throws IOException      
     * @return: Response      
     * @throws   
     */
    private Response _getSyn(String url) throws IOException
    {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response= call.execute();
        return response;
    }
    /**   
     * @Title: _getSynString   
     * @Description: TODO 同步的get请求
     * @param: @param url
     * @param: @return
     * @param: @throws IOException      
     * @return: String      
     * @throws   
     */
    private String _getSynString(String url) throws IOException
    {
        Response response = _getSyn(url);
        return response.body().string();
    }
    
    /**   
     * @Title: _postSyn   
     * @Description: TODO 同步的post请求
     * @param: @return
     * @param: @throws IOException      
     * @return: Response      
     * @throws   
     */
    private Response _postSyn() throws IOException
    {
		return null;
        
    }
    
    /**   
     * @Title: _getAsyn   
     * @Description: TODO 异步的get请求
     * @param: @param url
     * @param: @param callback      
     * @return: void      
     * @throws   
     */
    private void _getAsyn(String url, final ResultCallback callback)
    {
        
    }
    
    /**   
     * @Title: _postAsyn   
     * @Description: TODO 异步的post请求
     * @param: @param url
     * @param: @param callback      
     * @return: void      
     * @throws   
     */
    private void _postAsyn(String url, final ResultCallback callback,Map<String, Object> params)
    {
        
    }
    
 

}
