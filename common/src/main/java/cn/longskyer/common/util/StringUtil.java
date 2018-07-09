package cn.longskyer.common.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**   
 * @ClassName:  StringUtil   
 * @Description:字符串工具类 
 * @author: longskyer 2503802889@qq.com
 * @date:   2018年7月6日 下午4:28:09        
 */
public class StringUtil {

	
	public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }
	

	 /**   
	 * @Title: isNotEmpty   
	 * @Description: 判断是否不为空
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	public static boolean isNotEmpty(final String str) {
	        return !isEmpty(str);
	 }
	/**   
	 * @Title: isBlank   
	 * @Description: 判断是否空白
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	public static boolean isBlank(final String str) {
        int strLen;
        if ((str == null) || ((strLen = str.length()) == 0))
            return true;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
	
	/**   
	 * @Title: isNotBlank   
	 * @Description: 判断是否不是空白
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	public static boolean isNotBlank(final String str) {
        return !isBlank(str);
    }
	
	public static boolean isAllEmpty(String... strings) {
        if (strings == null) {
            return true;
        }
        for (String str : strings) {
            if (isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }
	
	public static boolean equals(String str1, String str2) {
         if (str1 == null) {
             return str2 == null;
         }
         return str1.equals(str2);
     }
	
	public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equalsIgnoreCase(str2);
    }
	
	 /**   
	 * @Title: isNumeric   
	 * @Description: 是否只包含数字
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	public static boolean isNumeric(String str) {
         if (str == null) {
             return false;
         }
 
         int length = str.length();
 
         for (int i = 0; i < length; i++) {
             if (!Character.isDigit(str.charAt(i))) {
                 return false;
             }
         }
 
         return true;
     }
	 
	 /**   
	 * @Title: isNumber   
	 * @Description: 是否只包含数字和小数点
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	public static boolean isNumber(String str) {
         if (isEmpty(str)) {
             return false;
         }
         int index = str.indexOf(".");
         if (index < 0) {
             return isNumeric(str);
         } else {
             String num1 = str.substring(0, index);
             String num2 = str.substring(index + 1);
             return isNumeric(num1) && isNumeric(num2);
         }
     }
	 
	 public static String toUpperCase(String str) {
         if (str == null) {
             return null;
         }
 
         return str.toUpperCase();
     }
	 
	 public static String toLowerCase(String str) {
         if (str == null) {
             return null;
         }
 
         return str.toLowerCase();
     }
	 
	 public static String reverse(String str) {  
	      if (str == null) {  
	           return null;  
	       }  
	        return new StringBuilder(str).reverse().toString();  
	    }  

	 
	    public static String dateToString(java.sql.Date date, String formatType) {
	        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(formatType);
	        String s = "";
	        if (date != null) {
	            s = format.format(date);
	        }
	        return s;
	    }
	    
	    public static int length(String str){
	        if(str == null){
	            return 0;
	        }else {
	            return str.length();
	        }
	    }

	    public static int indexOf(String str, char searchChar) {
	    	return str.indexOf(searchChar);
	    }
	    
	    /**   
	     * @Title: isAllLowerCase   
	     * @Description: 判断是否全部为小写字母
	     * @param: @param cs
	     * @param: @return      
	     * @return: boolean      
	     * @throws   
	     */
	    public static boolean isAllLowerCase(String cs) {  
	        if (cs == null || isEmpty(cs)) {  
	            return false;  
	        }  
	        int sz = cs.length();  
	        for (int i = 0; i < sz; i++) {  
	            if (Character.isLowerCase(cs.charAt(i)) == false) {  
	                return false;  
	            }  
	        }  
	        return true;  
	    }  

	   
	    /**   
	     * @Title: isAllUpperCase   
	     * @Description: 判断是否全部为大写字母
	     * @param: @param cs
	     * @param: @return      
	     * @return: boolean      
	     * @throws   
	     */
	    public static boolean isAllUpperCase(String cs) {  
	        if (cs == null || isEmpty(cs)) {  
	            return false;  
	        }  
	        int sz = cs.length();  
	        for (int i = 0; i < sz; i++) {  
	            if (Character.isUpperCase(cs.charAt(i)) == false) {  
	                return false;  
	            }  
	        }  
	        return true;  
	    }  
	    
	    /**   
	     * @Title: left   
	     * @Description: 截取左边n个字符
	     * @param: @param str
	     * @param: @param len
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String left(String str, int len) {  
	        if (str == null) {  
	            return null;  
	        }  
	        if (len < 0) {  
	            return null; 
	        }  
	        if (str.length() <= len) {  
	            return str;  
	        }  
	        return str.substring(0, len);  
	    }  

	    public static String substringBefore(String s,String separator) {
	        if (isEmpty(s) || separator == null) {
	            return s;
	        }
	        if (separator.isEmpty()) {
	            return "";
	        }
	        int pos = s.indexOf(separator);
	        if (pos < 0) {
	            return s;
	        }
	        return s.substring(0, pos);
	    }
	    
	    public static String substringAfter(String str, String separator) {
	        if (isEmpty(str)) {
	            return str;
	        }
	        if (separator == null) {
	            return "";
	        }
	        int pos = str.indexOf(separator);
	        if (pos == -1) {
	            return "";
	        }
	        return str.substring(pos + separator.length());
	    }
	    
	    public static String substring(String str, int start) {
	         if (str == null) {
	             return null;
	         }
	 
	         if (start < 0) {
	             start = str.length() + start;
	         }
	 
	         if (start < 0) {
	             start = 0;
	         }
	 
	         if (start > str.length()) {
	             return "";
	         }
	 
	         return str.substring(start);
	     }

	    public static String substring(String str, int start, int end) {
	         if (str == null) {
	             return null;
	         }
	 
	         if (end < 0) {
	             end = str.length() + end;
	         }
	 
	         if (start < 0) {
	             start = str.length() + start;
	         }
	 
	         if (end > str.length()) {
	             end = str.length();
	         }
	 
	         if (start > end) {
	             return "";
	         }
	 
	         if (start < 0) {
	             start = 0;
	         }
	 
	         if (end < 0) {
	             end = 0;
	         }
	 
	         return str.substring(start, end);
	     }
	    
	    /**   
	     * @Title: toString   
	     * @Description: 字节数组转换成字符串
	     * @param: @param bytes
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String toString(byte[] bytes){
	        try {
	            return new String(bytes, "utf-8");
	          } catch (UnsupportedEncodingException e) {
	            return null;
	          }
	     }
	    
	    /**   
	     * @Title: getBytes   
	     * @Description: 字符串转换成字节数组
	     * @param: @param str
	     * @param: @return      
	     * @return: byte[]      
	     * @throws   
	     */
	    public static byte[] getBytes(String str){
	        if (str != null){
	          try {
	              return str.getBytes("utf-8");
	            } catch (UnsupportedEncodingException e) {
	              return null;
	            }
	        }else{
	          return null;
	        }
	      }
	    
	    /**   
	     * @Title: trim   
	     * @Description: 除去指定模式下指定的字符
	     * @param: @param str
	     * @param: @param stripChars
	     * @param: @param mode -1仅处理头部 1仅处理尾部 0头部尾部都处理
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    private static String trim(String str, String stripChars, int mode) {
	         if (str == null) {
	             return null;
	         }
	 
	         int length = str.length();
	         int start = 0;
	         int end = length;
	 
	         // 扫描字符串头部
	         if (mode <= 0) {
	             if (stripChars == null) {
	                 while ((start < end) && (Character.isWhitespace(str.charAt(start)))) {
	                     start++;
	                 }
	             } else if (stripChars.length() == 0) {
	                 return str;
	             } else {
	                 while ((start < end) && (stripChars.indexOf(str.charAt(start)) != -1)) {
	                     start++;
	                 }
	             }
	         }
	 
	         // 扫描字符串尾部
	         if (mode >= 0) {
	             if (stripChars == null) {
	                 while ((start < end) && (Character.isWhitespace(str.charAt(end - 1)))) {
	                     end--;
	                 }
	             } else if (stripChars.length() == 0) {
	                 return str;
	             } else {
	                 while ((start < end) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
	                     end--;
	                 }
	             }
	         }
	 
	         if ((start > 0) || (end < length)) {
	             return str.substring(start, end);
	         }
	 
	         return str;
	     }
	    
	    /**   
	     * @Title: trim   
	     * @Description: 除去字符串头尾部空白
	     * @param: @param str
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String trim(String str) {
	         return trim(str, null, 0);
	     }
	    
	    /**   
	     * @Title: trim   
	     * @Description: 除去字符串头尾部指定的字符
	     * @param: @param str
	     * @param: @param stripChars
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String trim(String str, String stripChars) {
	         return trim(str, stripChars, 0);
	     }
	    
	    /**   
	     * @Title: trimStart   
	     * @Description: 除去字符串头部的空白
	     * @param: @param str
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String trimStart(String str) {
	         return trim(str, null, -1);
	     }
	    
	    /**   
	     * @Title: trimStart   
	     * @Description: 除去字符串头部指定的字符
	     * @param: @param str
	     * @param: @param stripChars
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String trimStart(String str, String stripChars) {
	         return trim(str, stripChars, -1);
	     }
	    
	    /**   
	     * @Title: trimEnd   
	     * @Description: 除去尾部空白的字符串
	     * @param: @param str
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String trimEnd(String str) {
	         return trim(str, null, 1);
	     }
	    
	    /**   
	     * @Title: trimEnd   
	     * @Description: 除去尾部指定的字符串
	     * @param: @param str
	     * @param: @param stripChars
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String trimEnd(String str, String stripChars) {
	         return trim(str, stripChars, 1);
	     }
	    
	    /**   
	     * @Title: isAlpha   
	     * @Description: 是否只包含英文字母
	     * @param: @param str
	     * @param: @return      
	     * @return: boolean      
	     * @throws   
	     */
	    public static boolean isAlpha(String str) {
	         if (str == null) {
	             return false;
	         }
	 
	         int length = str.length();
	 
	         for (int i = 0; i < length; i++) {
	             if (!Character.isLetter(str.charAt(i))) {
	                 return false;
	             }
	         }
	 
	         return true;
	     }

	    /**   
	     * @Title: isAlphaSpace   
	     * @Description: 是否只包含英文字母和空白
	     * @param: @param str
	     * @param: @return      
	     * @return: boolean      
	     * @throws   
	     */
	    public static boolean isAlphaSpace(String str) {
	         if (str == null) {
	             return false;
	         }
	 
	         int length = str.length();
	 
	         for (int i = 0; i < length; i++) {
	             if (!Character.isLetter(str.charAt(i)) && (str.charAt(i) != ' ')) {
	                 return false;
	             }
	         }
	 
	         return true;
	     }
	    
	    /**   
	     * @Title: isAlphaNumeric   
	     * @Description: 是否只包含英文字母和数字
	     * @param: @param str
	     * @param: @return      
	     * @return: boolean      
	     * @throws   
	     */
	    public static boolean isAlphaNumeric(String str) {
	         if (str == null) {
	             return false;
	         }
	 
	         int length = str.length();
	 
	         for (int i = 0; i < length; i++) {
	             if (!Character.isLetterOrDigit(str.charAt(i))) {
	                 return false;
	             }
	         }
	 
	         return true;
	     }
	    /**   
	     * @Title: split   
	     * @Description: 根据分割字符串把字符串分割成字符串数组。可以指定字符串数组的最大元素个数，如果指定为0或者负数表示无限制
	     * @param: @param str
	     * @param: @param separatorChars
	     * @param: @param max
	     * @param: @return      
	     * @return: String[]      
	     * @throws   
	     */
	    public static String[] split(String str, String separatorChars, int max) {
	         if (str == null) {
	             return null;
	         }
	 
	         int length = str.length();
	 
	         if (length == 0) {
	             return new String[] {""};
	         }
	 
	         List list = new ArrayList();
	         int sizePlus1 = 1;
	         int i = 0;
	         int start = 0;
	         boolean match = false;
	 
	         if (separatorChars == null) {
	             // null表示使用空白作为分隔符
	             while (i < length) {
	                 if (Character.isWhitespace(str.charAt(i))) {
	                     if (match) {
	                         if (sizePlus1++ == max) {
	                             i = length;
	                         }
	 
	                         list.add(str.substring(start, i));
	                         match = false;
	                     }
	 
	                     start = ++i;
	                     continue;
	                 }
	 
	                 match = true;
	                 i++;
	             }
	         } else if (separatorChars.length() == 1) {
	             // 优化分隔符长度为1的情形
	             char sep = separatorChars.charAt(0);
	 
	             while (i < length) {
	                 if (str.charAt(i) == sep) {
	                     if (match) {
	                         if (sizePlus1++ == max) {
	                             i = length;
	                         }
	 
	                         list.add(str.substring(start, i));
	                         match = false;
	                     }
	 
	                     start = ++i;
	                     continue;
	                 }
	 
	                 match = true;
	                 i++;
	             }
	         } else {
	             // 一般情形
	             while (i < length) {
	                 if (separatorChars.indexOf(str.charAt(i)) >= 0) {
	                     if (match) {
	                         if (sizePlus1++ == max) {
	                             i = length;
	                         }
	 
	                         list.add(str.substring(start, i));
	                         match = false;
	                     }
	 
	                     start = ++i;
	                     continue;
	                 }
	 
	                 match = true;
	                 i++;
	             }
	         }
	 
	         if (match) {
	             list.add(str.substring(start, i));
	         }
	 
	         return (String[]) list.toArray(new String[list.size()]);
	     }
	    
	    /**   
	     * @Title: split   
	     * @Description: 指定分割字符串，把字符串分割成字符串数组
	     * @param: @param str
	     * @param: @param separatorChars
	     * @param: @return      
	     * @return: String[]      
	     * @throws   
	     */
	    public static String[] split(String str, String separatorChars) {
	         return split(str, separatorChars, -1);
	     }
	    
	    /**   
	     * @Title: split   
	     * @Description: 根据字符把字符串分割成字符串数组
	     * @param: @param str
	     * @param: @param separatorChar
	     * @param: @return      
	     * @return: String[]      
	     * @throws   
	     */
	    public static String[] split(String str, char separatorChar) {
	         if (str == null) {
	             return null;
	         }
	 
	         int length = str.length();
	 
	         if (length == 0) {
	             return new String[] {""};
	         }
	 
	         List list = new ArrayList();
	         int i = 0;
	         int start = 0;
	         boolean match = false;
	 
	         while (i < length) {
	             if (str.charAt(i) == separatorChar) {
	                 if (match) {
	                     list.add(str.substring(start, i));
	                     match = false;
	                 }
	 
	                 start = ++i;
	                 continue;
	             }
	 
	             match = true;
	             i++;
	         }
	 
	         if (match) {
	             list.add(str.substring(start, i));
	         }
	 
	         return (String[]) list.toArray(new String[list.size()]);
	     }
	    
	    /**   
	     * @Title: split   
	     * @Description: 根据空白符把字符串分割成字符串数组
	     * @param: @param str
	     * @param: @return      
	     * @return: String[]      
	     * @throws   
	     */
	    public static String[] split(String str) {
	         return split(str, null, -1);
	     }
	    
	    /**   
	     * @Title: join   
	     * @Description: 将数组所有元素连接成一个字符串，元素后面加分隔字符
	     * @param: @param array
	     * @param: @param separator
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String join(Object[] array, char separator) {
	         if (array == null) {
	             return null;
	         }
	 
	         int arraySize = array.length;
	         int bufSize = (arraySize == 0) ? 0 : ((((array[0] == null) ? 16 : array[0].toString()
	             .length()) + 1) * arraySize);
	         StringBuffer buf = new StringBuffer(bufSize);
	 
	         for (int i = 0; i < arraySize; i++) {
	             if (i > 0) {
	                 buf.append(separator);
	             }
	 
	             if (array[i] != null) {
	                 buf.append(array[i]);
	             }
	         }
	 
	         return buf.toString();
	     }
	    
	    /**   
	     * @Title: join   
	     * @Description: 将数组所有元素连接成一个字符串
	     * @param: @param array
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String join(Object[] array) {
	         return join(array, (Character) null);
	     }
	    
	    /**   
	     * @Title: join   
	     * @Description: 把数组元素拼接成字符串，元素后面加分隔字符串
	     * @param: @param array
	     * @param: @param separator
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String join(Object[] array, String separator) {
	         if (array == null) {
	             return null;
	         }
	 
	         if (separator == null) {
	             separator = "";
	         }
	 
	         int arraySize = array.length;
	         int bufSize = (arraySize == 0) ? 0 : (arraySize * (((array[0] == null) ? 16 : array[0]
	             .toString().length()) + ((separator != null) ? separator.length() : 0)));
	 
	         StringBuffer buf = new StringBuffer(bufSize);
	 
	         for (int i = 0; i < arraySize; i++) {
	             if ((separator != null) && (i > 0)) {
	                 buf.append(separator);
	             }
	 
	             if (array[i] != null) {
	                 buf.append(array[i]);
	             }
	         }
	 
	         return buf.toString();
	     }
	    
	    /**   
	     * @Title: join   
	     * @Description: 提供容器头迭代器可以将容器元素拼成字符串，元素候加分隔符
	     * @param: @param iterator
	     * @param: @param separator
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String join(Iterator iterator, char separator) {
	         if (iterator == null) {
	             return null;
	         }
	 
	         StringBuffer buf = new StringBuffer(256); // Java默认值是16, 可能偏小
	 
	         while (iterator.hasNext()) {
	             Object obj = iterator.next();
	 
	             if (obj != null) {
	                 buf.append(obj);
	             }
	 
	             if (iterator.hasNext()) {
	                 buf.append(separator);
	             }
	         }
			return buf.toString();
	         
	    }
	    
	    /**   
	     * @Title: join   
	     * @Description: 提供容器头迭代器可以将容器元素拼成字符串，元素候加分隔符
	     * @param: @param iterator
	     * @param: @param separator
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String join(Iterator iterator, String separator) {
	         if (iterator == null) {
	             return null;
	         }
	 
	         StringBuffer buf = new StringBuffer(256); // Java默认值是16, 可能偏小
	 
	         while (iterator.hasNext()) {
	             Object obj = iterator.next();
	 
	             if (obj != null) {
	                 buf.append(obj);
	             }
	 
	             if ((separator != null) && iterator.hasNext()) {
	                 buf.append(separator);
	             }
	         }
	 
	         return buf.toString();
	     }
	         
	    public static int indexOf(String str, char searchChar, int startPos) {
	         if ((str == null) || (str.length() == 0)) {
	             return -1;
	         }
	 
	         return str.indexOf(searchChar, startPos);
	     }
	    
	    public static int indexOf(String str, String searchStr) {
	         if ((str == null) || (searchStr == null)) {
	             return -1;
	         }
	 
	         return str.indexOf(searchStr);
	     }
	    
	    public static int indexOf(String str, String searchStr, int startPos) {
	         if ((str == null) || (searchStr == null)) {
	             return -1;
	         }
	         if ((searchStr.length() == 0) && (startPos >= str.length())) {
	             return str.length();
	         }
	 
	         return str.indexOf(searchStr, startPos);
	     }
	    
	    public static int indexOfAny(String str, char[] searchChars) {
	         if ((str == null) || (str.length() == 0) || (searchChars == null)
	             || (searchChars.length == 0)) {
	             return -1;
	         }
	 
	         for (int i = 0; i < str.length(); i++) {
	             char ch = str.charAt(i);
	 
	             for (int j = 0; j < searchChars.length; j++) {
	                 if (searchChars[j] == ch) {
	                     return i;
	                 }
	             }
	         }
	 
	         return -1;
	     }
	    
	    public static int indexOfAny(String str, String searchChars) {
	         if ((str == null) || (str.length() == 0) || (searchChars == null)
	             || (searchChars.length() == 0)) {
	             return -1;
	         }
	 
	         for (int i = 0; i < str.length(); i++) {
	             char ch = str.charAt(i);
	 
	             for (int j = 0; j < searchChars.length(); j++) {
	                 if (searchChars.charAt(j) == ch) {
	                     return i;
	                 }
	             }
	         }
	 
	         return -1;
	     }
	    
	    public static boolean contains(String str, char searchChar) {
	         if ((str == null) || (str.length() == 0)) {
	             return false;
	         }
	 
	         return str.indexOf(searchChar) >= 0;
	     }
	    
	    public static boolean contains(String str, String searchStr) {
	         if ((str == null) || (searchStr == null)) {
	             return false;
	         }
	 
	         return str.indexOf(searchStr) >= 0;
	     }
	    
	    public static boolean containsOnly(String str, char[] valid) {
	         if ((valid == null) || (str == null)) {
	             return false;
	         }
	 
	         if (str.length() == 0) {
	             return true;
	         }
	 
	         if (valid.length == 0) {
	             return false;
	         }
	 
	         return indexOfAnyBut(str, valid) == -1;
	     }
	    public static boolean containsOnly(String str, String valid) {
	         if ((str == null) || (valid == null)) {
	             return false;
	         }
	 
	         return containsOnly(str, valid.toCharArray());
	     }
	    
	    public static boolean containsNone(String str, char[] invalid) {
	         if ((str == null) || (invalid == null)) {
	             return true;
	         }
	 
	         int strSize = str.length();
	         int validSize = invalid.length;
	 
	         for (int i = 0; i < strSize; i++) {
	             char ch = str.charAt(i);
	 
	             for (int j = 0; j < validSize; j++) {
	                 if (invalid[j] == ch) {
	                     return false;
	                 }
	             }
	         }
	 
	         return true;
	     }
	    
	    public static boolean containsNone(String str, String invalidChars) {
	         if ((str == null) || (invalidChars == null)) {
	             return true;
	         }
	 
	         return containsNone(str, invalidChars.toCharArray());
	     }
	    /**   
	     * @Title: indexOfAnyBut   
	     * @Description: 在字符串中查找不在指定字符集合中的字符，并返回第一个匹配的起始索引
	     * @param: @param str
	     * @param: @param searchChars
	     * @param: @return      
	     * @return: int      
	     * @throws   
	     */
	    public static int indexOfAnyBut(String str, char[] searchChars) {
	         if ((str == null) || (str.length() == 0) || (searchChars == null)
	             || (searchChars.length == 0)) {
	             return -1;
	         }
	 
	         outer: for (int i = 0; i < str.length(); i++) {
	             char ch = str.charAt(i);
	 
	             for (int j = 0; j < searchChars.length; j++) {
	                 if (searchChars[j] == ch) {
	                     continue outer;
	                 }
	             }
	 
	             return i;
	         }
	 
	         return -1;
	     }	
	    
	    /**   
	     * @Title: indexOfAnyBut   
	     * @Description:  在字符串中查找不在指定字符集合中的字符，并返回第一个匹配的起始索引。
	     * @param: @param str
	     * @param: @param searchChars
	     * @param: @return      
	     * @return: int      
	     * @throws   
	     */
	    public static int indexOfAnyBut(String str, String searchChars) {
	         if ((str == null) || (str.length() == 0) || (searchChars == null)
	             || (searchChars.length() == 0)) {
	             return -1;
	         }
	 
	         for (int i = 0; i < str.length(); i++) {
	             if (searchChars.indexOf(str.charAt(i)) < 0) {
	                 return i;
	             }
	         }
	 
	         return -1;
	     }
	    public static int lastIndexOf(String str, char searchChar) {
	         if ((str == null) || (str.length() == 0)) {
	             return -1;
	         }
	 
	         return str.lastIndexOf(searchChar);
	     }
	    public static int lastIndexOf(String str, char searchChar, int startPos) {
	         if ((str == null) || (str.length() == 0)) {
	             return -1;
	         }
	 
	         return str.lastIndexOf(searchChar, startPos);
	     }
	    public static int lastIndexOf(String str, String searchStr) {
	         if ((str == null) || (searchStr == null)) {
	             return -1;
	         }
	 
	         return str.lastIndexOf(searchStr);
	     }
	    
	    public static int lastIndexOf(String str, String searchStr, int startPos) {
	         if ((str == null) || (searchStr == null)) {
	             return -1;
	         }
	 
	         return str.lastIndexOf(searchStr, startPos);
	     }
	    
	    public static String substringBetween(String str, String open, String close, int fromIndex) {
	         if ((str == null) || (open == null) || (close == null)) {
	             return null;
	         }
	 
	         int start = str.indexOf(open, fromIndex);
	 
	         if (start != -1) {
	             int end = str.indexOf(close, start + open.length());
	 
	             if (end != -1) {
	                 return str.substring(start + open.length(), end);
	             }
	         }
	 
	         return null;
	     }
	    
	    public static String substringBetween(String str, String open, String close) {
	         return substringBetween(str, open, close, 0);
	     }
	    public static String substringBetween(String str, String tag) {
	         return substringBetween(str, tag, tag, 0);
	     }
	    
	    public static String deleteWhitespace(String str) {
	         if (str == null) {
	             return null;
	         }
	 
	         int sz = str.length();
	         StringBuffer buffer = new StringBuffer(sz);
	 
	         for (int i = 0; i < sz; i++) {
	             if (!Character.isWhitespace(str.charAt(i))) {
	                 buffer.append(str.charAt(i));
	             }
	         }
	 
	         return buffer.toString();
	     }
	    /**   
	     * @Title: replace   
	     * @Description: TODO
	     * @param: @param text扫描
	     * @param: @param repl搜索
	     * @param: @param with替换
	     * @param: @param max替换指定的次数
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String replace(String text, String repl, String with, int max) {
	         if ((text == null) || (repl == null) || (with == null) || (repl.length() == 0)
	             || (max == 0)) {
	             return text;
	         }
	 
	         StringBuffer buf = new StringBuffer(text.length());
	         int start = 0;
	         int end = 0;
	 
	         while ((end = text.indexOf(repl, start)) != -1) {
	             buf.append(text.substring(start, end)).append(with);
	             start = end + repl.length();
	 
	             if (--max == 0) {
	                 break;
	             }
	         }
	 
	         buf.append(text.substring(start));
	         return buf.toString();
	     }
	    public static String replace(String text, String repl, String with) {
	         return replace(text, repl, with, -1);
	     }
	       
}
