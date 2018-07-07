package cn.longskyer.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

/**   
 * @ClassName:  SystemInfoUtil   
 * @Description:TODO  获取系统信息工具类
 * @author: 黄飞龙 2503802889@qq.com
 * @date:   2018年7月6日 下午4:51:18        
 */
public class SystemInfoUtil {
	

	/**   
	 * @Title: getIpAddress   
	 * @Description: TODO获取本机ip地址
	 * @param: @return
	 * @param: @throws UnknownHostException      
	 * @return: String      
	 * @throws   
	 */
	public static String getIpAddress() throws UnknownHostException {  
        InetAddress address = InetAddress.getLocalHost();  
        return address.getHostAddress();  
    } 
	
	public static String getOsUser(){
		return System.getProperty("user.name");
	}
	
	/**   
	 * @Title: getUserHome   
	 * @Description: TODO
	 * @param: @return 获取用户主目录     
	 * @return: String      
	 * @throws   
	 */
	public static String getUserHome(){
		return System.getProperty("user.home");
	}
	
	/**   
	 * @Title: getCurrentPath   
	 * @Description: TO获取当前工作的路径
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String getCurrentPath(){
		return System.getProperty("user.dir");
	}
	
	/**   
	 * @Title: tmpdir   
	 * @Description: TODO 获取默认的临时文件路径
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String tmpdir() {
		return System.getProperty("java.io.tmpdir");	
	}
	
	public static String getOsName(){
		return System.getProperty("os.name");
	}
	
	public static String getOsArch(){
		return System.getProperty("os.arch");
	}
	
	public static String getOsVersion(){
		return System.getProperty("os.version");
	}
	
	/**   
	 * @Title: getJavaVersion   
	 * @Description: TODO 获取java的版本信息
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String getJavaVersion(){
		return System.getProperty("java.class.version");
	}
	
	/**   
	 * @Title: getJavaClassPath   
	 * @Description: 获取java的类路径  
	 * @param: @return  
	 * @return: String      
	 * @throws   
	 */
	public static String getJavaClassPath(){
		return System.getProperty("java.class.path");
	}
	
	/**   
	 * @Title: getJavaHome   
	 * @Description: TODO 获取java安装路径
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	public static String getJavaHome(){
		return System.getProperty("java.hom");
	}
	
}
