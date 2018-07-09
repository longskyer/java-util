package cn.longskyer.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
	
	/**
    public interface ResultCallback {

        void requestSuccess(String result) throws Exception;
        void requestFailure(Request request, IOException e);
    }
    */
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
    
    //*********************内部使用的函数由此 开始********************
    
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
        Call call = getInstance().okHttpClient.newCall(request);
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
    private Response _postSyn(String url, Map<String, String> params, Callback callback) throws IOException
    {
    	FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, (String) params.get(key));
        }
        //创建Request
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Call call = getInstance().okHttpClient.newCall(request);
        Response response= call.execute();
        return response;
    }
    
    /**   
     * @Title: _getAsyn   
     * @Description: TODO 异步的get请求
     * @param: @param url
     * @param: @param callback      
     * @return: void      
     * @throws   
     */
    private void _getAsyn(String url, final Callback callback)
    {
    	//创建Request
        Request request = new Request.Builder().url(url).build();
        //得到Call对象
        Call call = getInstance().okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);
    }
    
    /**   
     * @Title: _postAsyn   
     * @Description: TODO 异步的post请求
     * @param: @param url
     * @param: @param callback      
     * @return: void      
     * @throws   
     */
    private void _postAsyn(String url, Map<String, String> params,final Callback callback)
    {
    	FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));

        }
        //创建Request
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Call call = getInstance().okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);
    }
    
    /**   
     * @Title: _postUpload   
     * @Description: TODO 基于post的异步文件上传
     * @param: @param url
     * @param: @param file
     * @param: @param fileName      
     * @return: void      
     * @throws   
     */
    private void _postAsynUpload(String url, File file, String fileName) {
        //创建RequestBody 封装file参数
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        //创建RequestBody 设置类型等
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", fileName, fileBody).build();
        //创建Request
        Request request = new Request.Builder().url(url).post(requestBody).build();

        //得到Call
        Call call = getInstance().okHttpClient.newCall(request);
        //执行请求
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {

            }

            public void onResponse(Call call, Response response) throws IOException {
                
            }
        });

    }
    
    /**   
     * @Title: _postJson   
     * @Description: TODO 基于post异步请求发送json数据
     * @param: @param url
     * @param: @param jsonParams
     * @param: @param callback      
     * @return: void      
     * @throws   
     */
    private void _postAsynJson(String url, String jsonParams, Callback callback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = getInstance().okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    
    /**   
     * @Title: _downloadAsyn   
     * @Description: 异步方式下载文件
     * @param: @param url 请求url
     * @param: @param destFileDir 路径
     * @param: @param callback 回调函数 
     * @return: void      
     * @throws   
     */
    private void _downloadAsyn(final String url, final String destFileDir, final Callback callback) {
    	 Request request = new Request.Builder().url(url).build();
         Call call = getInstance().okHttpClient.newCall(request);
         call.enqueue(new Callback() {

			public void onFailure(Call call, IOException e) {
				// TODO Auto-generated method stub
				LogUtil.error("下载文件失败");;
				
			}
			public void onResponse(Call call, Response response) throws IOException {
				// TODO Auto-generated method stub
				//以下处理逻辑仅仅作为一个demo来参考
				InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                	is = response.body().byteStream();
                    File file = new File(destFileDir, url.substring(url.lastIndexOf("/") + 1));
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					if (is != null) is.close();
                    if (fos != null) fos.close();

				}
				
			}
        	 
         });
    }
  //*********************内部使用的函数由此 结束********************
    
  //*************对外公布的方法由此 开始************


    public static Response getSyn(String url) throws IOException
    {
        return getInstance()._getSyn(url);
    }

    public static Response postSyn(String url,Map<String, String> params,Callback callback ) throws IOException
    {
        return getInstance()._postSyn(url,params,callback);
    }

    public static String getSynString(String url) throws IOException
    {
        return getInstance()._getSynString(url);
    }

    public static void getAsyn(String url, Callback callback)
    {
        getInstance()._getAsyn(url, callback);
    }

    public static void postAsyn(String url,  Map<String, String> params,Callback callback)
    {
        getInstance()._postAsyn(url, params, callback);
    }
    
    public static void postAsynUpload(String url, File file, String fileName) {
    	getInstance()._postAsynUpload(url, file, fileName);
    }

    public static void postAsynJson(String url, String jsonParams, Callback callback) {
    	getInstance()._postAsynJson(url, jsonParams, callback);
    }
    public static void downloadAsyn(final String url, final String destFileDir, final Callback callback) {
    	getInstance()._downloadAsyn(url, destFileDir, callback);
    }
    //****************************对外公布的方法由此 结束（未完整，待补充）************

}
