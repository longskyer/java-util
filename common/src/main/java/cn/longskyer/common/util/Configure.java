package cn.longskyer.common.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**   
 * @ClassName:  Configure   
 * @Description:TODO 读取配置文件
 * 可读取properties配置文件、json配置文件、conf配置文件
 * ConfigFactory.load()会加载配置文件，默认加载classpath下的
 * application.conf,application.json和application.properties文件。
 * 也可以调用ConfigFactory.load(confFileName)加载指定的配置文件。
 * @author: longskyer 2503802889@qq.com
 * @date:   2018年7月6日 下午8:32:08        
 */
public class Configure {
	 
	    private final Config config; 
	    public Configure(String confFileName) {
	        config = ConfigFactory.load(confFileName);
	    }
	 
	    public Configure() {
	        config = ConfigFactory.load();
	    }
	 
	    public String getString(String name) {
	        return config.getString(name);
	    }

}
