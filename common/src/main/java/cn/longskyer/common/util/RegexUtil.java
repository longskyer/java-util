/**   
 *
 * @Title: RegexUtil.java 
 * @Prject: common
 * @Package: cn.longskyer.common.util 
 * @Description: TODO
 * @author: root   
 * @date: 2018年7月13日 下午4:06:51 
 * @version: V1.0   
 * Copyright © 2018 cn.longskyer. All rights reserved.
 */
package cn.longskyer.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @ClassName: RegexUtil 
 * @Description: TODO 正则表达式验证
 * @author: longskyer
 * @date: 2018年7月13日 下午4:06:51
 */
public class RegexUtil {
	
	/** 
	 * @Title: check 
	 * @Description: TODO 正则匹配
	 * @param str 要匹配的字符串
	 * @param pattern 正则表达式字符串
	 * @return
	 * @return: boolean
	 */
	public static boolean check(String str,String pattern){  
        if(null == str || str.trim().length()<=0)  
            return false;           
        Pattern p = Pattern.compile(pattern);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    } 
	
	 /** 
	 * @Title: checkEmail 
	 * @Description: TODO 验证邮箱
	 * @param email
	 * @return
	 * @return: boolean
	 */
	public static boolean checkEmail(String email) { 
	        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?"; 
	        return check(email, regex);
	}
	
	/** 
	 * @Title: checkMobile 
	 * @Description: TODO 验证手机号码
	 * @param mobile
	 * @return
	 * @return: boolean
	 */
	public static boolean checkMobilePhone(String mobile) { 
        String regex = "(\\+\\d+)?1[34578]\\d{9}$"; 
        return check(mobile, regex);
    } 
	
	/** 
	 * @Title: checkIdCard 
	 * @Description: TODO 验证身份证号码
	 * @param idCard
	 * @return
	 * @return: boolean
	 */
	public static boolean checkIdCard(String idCard) { 
        String regex = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})" +  
                "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}" +  
                "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))";
        return check(idCard,regex); 
    } 
	
	 /** 
	 * @Title: checkPhone 
	 * @Description: TODO 验证固定电话
	 * @param phone
	 * @return
	 * @return: boolean
	 */
	public static boolean checkPhone(String phone) { 
	        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$"; 
	        return check(phone,regex); 
    }
	
	/** 
	 * @Title: checkChinese 
	 * @Description: TODO  验证中文字符
	 * @param chinese
	 * @return
	 * @return: boolean
	 */
	public static boolean checkChinese(String chinese) { 
        String regex = "^[\u4E00-\u9FA5]+$"; 
        return check(chinese,regex); 
    }
	
	/** 
	 * @Title: checkPostcode 
	 * @Description: TODO 验证邮政编码
	 * @param postcode
	 * @return
	 * @return: boolean
	 */
	public static boolean checkPostcode(String postcode) { 
        String regex = "[1-9]\\d{5}"; 
        return check(postcode,regex); 
	}
	
	/** 
	 * @Title: checkBirthday 
	 * @Description: TODO 验证出生日期
	 * @param birthday
	 * @return
	 * @return: boolean
	 */
	public static boolean checkBirthday(String birthday) { 
        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}"; 
        return check(birthday,regex); 
    }
	/** 
	 * @Title: checkDigit 
	 * @Description: TODO 验证整数，包括正整数和负整数
	 * @param digit
	 * @return
	 * @return: boolean
	 */
	public static boolean checkDigit(String digit) { 
        String regex = "\\-?[1-9]\\d+"; 
        return check(digit,regex); 
    }
	
	/** 
	 * @Title: checkUserName 
	 * @Description: TODO 匹配由数字、26个英文字母或者下划线组成的用户名
	 * @param userName
	 * @return
	 * @return: boolean
	 */
	public static boolean checkUserName(String userName) { 
        String regex = "^\\w+$"; 
        return check(userName,regex); 
    }
	
}
