package cn.longskyer.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**   
 * @ClassName:  DateUtil   
 * @Description:日期工具类   
 * @author: 黄飞龙 2503802889@qq.com
 * @date:   2018年7月6日 下午4:26:36        
 */
public class DateUtil {
	
	    public final static String shortFormat           = "yyyyMMdd";
	    public final static String longFormat            = "yyyyMMddHHmmss";
	    public final static String concurrentFormat      = "yyyyMMddHHmmssSSS";
	    public final static String shortConcurrentFormat = "yyMMddHHmmssSSS";
	    public final static String webFormat             = "yyyy-MM-dd";
	    public final static String webMonthFormat        = "yyyy-MM";
	    public final static String timeFormat            = "HH:mm:ss";
	    public final static String monthFormat           = "yyyyMM";
	    public final static String chineseDtFormat       = "yyyy年MM月dd日";
	    public final static String chineseYMFormat       = "yyyy年MM月";
	    public final static String newFormat             = "yyyy-MM-dd HH:mm:ss";
	    public final static String noSecondFormat        = "yyyy-MM-dd HH:mm";
	    public final static String MdFormat = "MM-dd";
	    public final static long   ONE_DAY_SECONDS       = 86400;
	    public final static long   ONE_DAY_MILL_SECONDS  = 86400000;
	    private static final int dateLength = noSecondFormat.length();
	    
	    /**   
	     * @Title: formatDateToString   
	     * @Description: 日期转换为制定格式字符串
	     * @param: @param time
	     * @param: @param format
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String formatDateToString(Date time, String format) { 
	        SimpleDateFormat sdf = new SimpleDateFormat(format); 
	        return sdf.format(time); 
	    }
	    
	    /**   
	     * @Title: getCurrentDateToString   
	     * @Description: 根据指定的格式将当前日期转化成字符串
	     * @param: @param format
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public String getCurrentDateToString(String format) {
	    	
			return formatDateToString(getCurrentDate(), format);
	    }
	    
	    /**   
	     * @Title: formatStringToDate   
	     * @Description: 字符串转换为制定格式日期
	     * @param: @param date
	     * @param: @param format
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static Date formatStringToDate(String date, String format) { 
	        SimpleDateFormat sdf = new SimpleDateFormat(format); 
	        try { 
	          return sdf.parse(date); 
	        } catch (ParseException ex) {
	          ex.printStackTrace(); 
	          throw new RuntimeException(ex.toString()); 
	        } 
	     } 
	    
	    /**   
	     * @Title: isTimeInRange   
	     * @Description: 判断一个日期是否属于两个时段内
	     * @param: @param time
	     * @param: @param timeRange
	     * @param: @return      
	     * @return: boolean      
	     * @throws   
	     */
	    public static boolean isTimeInRange(Date time, Date[] timeRange) { 
	        return (!time.before(timeRange[0]) && !time.after(timeRange[1])); 
	    } 
	    
	    /**   
	     * @Title: getDateToMinute   
	     * @Description: 从完整的时间截取精确到分的时间
	     * @param: @param fullDateStr
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String getDateToMinute(String fullDateStr) { 
	        return fullDateStr == null ? null: (fullDateStr.length() >= dateLength ? fullDateStr.substring(0, dateLength) : fullDateStr); 
	    }
	    
	    public static int getDaysBetween(Date startDate, Date endDate) { 
	        return (int) ((endDate.getTime() - startDate.getTime()) / ONE_DAY_MILL_SECONDS); 
	    } 
	    
	    public static int getDaysBetween(String startDate, String endDate)throws ParseException { 
	    int dayGap = 0; 
	    if (startDate != null && startDate.length() > 0 && endDate != null
	        && endDate.length() > 0) { 
	      Date end = formatStringToDate(endDate, webFormat); 
	      Date start = formatStringToDate(startDate, webFormat); 
	      dayGap = getDaysBetween(start, end); 
	    } 
	    return dayGap; 
	  } 
	    
	    public static int getYearsBetween(Date firstDate, Date secondDate) { 
	        if (firstDate == null || secondDate == null) { 
	          return 0; 
	        } 
	        Calendar helpCalendar = Calendar.getInstance(); 
	        helpCalendar.setTime(firstDate); 
	        int firstYear = helpCalendar.get(Calendar.YEAR); 
	        helpCalendar.setTime(secondDate); 
	        int secondYear = helpCalendar.get(Calendar.YEAR); 
	        return secondYear - firstYear; 
	     } 
	    
	    public static int getMonthsBetween(Date firstDate, Date secondDate) { 
	        if (firstDate == null || secondDate == null) { 
	          return 0; 
	        } 
	      
	        return (int) ((secondDate.getTime() - firstDate.getTime()) 
	            / ONE_DAY_MILL_SECONDS / 30); 
	      
	     }
	    /**   
	     * @Title: getCurDateWithMaxTime   
	     * @Description: 获取当前日期的最大日期时间
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static Date getCurDateWithMaxTime() { 
	        Calendar c = Calendar.getInstance(); 
	        c.set(Calendar.HOUR_OF_DAY, 23); 
	        c.set(Calendar.MINUTE, 59); 
	        c.set(Calendar.SECOND, 59); 
	        return c.getTime(); 
	     }
	     
	    /**   
	     * @Title: getCurDateWithMinTime   
	     * @Description: 获取当前日期的最小日期时间
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static Date getCurDateWithMinTime() { 
	        Calendar c = Calendar.getInstance(); 
	        c.set(Calendar.HOUR_OF_DAY, 0); 
	        c.set(Calendar.MINUTE, 0); 
	        c.set(Calendar.SECOND, 0); 
	        c.set(Calendar.MILLISECOND, 0); 
	        return c.getTime(); 
	     }
	    
	    /**   
	     * @Title: getCurrentDate   
	     * @Description: 获取当前日期
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static Date getCurrentDate() {
			Calendar calendar = Calendar.getInstance();
			return calendar.getTime();
		}
	    public static Date getNow() {
	    	return getCurrentDate();
	    }
	    /**   
	     * @Title: add   
	     * @Description: 根据指定的日期，类型，增加或减少数量
	     * @param: @param date
	     * @param: @param calendarField
	     * @param: @param amount
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static Date add(Date date, int calendarField, int amount) { 
	        if (date == null) { 
	          throw new IllegalArgumentException("The date must not be null"); 
	        } 
	        Calendar c = Calendar.getInstance(); 
	        c.setTime(date); 
	        c.add(calendarField, amount); 
	        return c.getTime(); 
	     } 
	    
	    /**   
	     * @Title: addDays   
	     * @Description: 根据指定的日期增加或减少天数
	     * @param: @param date
	     * @param: @param amount
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static Date addDays(Date date, int amount) { 
	        return add(date, Calendar.DAY_OF_MONTH, amount); 
	    }
	    /**   
	     * @Title: getCurrentHour   
	     * @Description: 获取当前小时数
	     * @param: @return      
	     * @return: int      
	     * @throws   
	     */
	    public static int getCurrentHour() {
			Calendar calendar = new GregorianCalendar();
			return calendar.get(Calendar.HOUR_OF_DAY);
		}
	    
	    /**   
	     * @Title: getCurrentMinute   
	     * @Description: 获取当前时间分钟
	     * @param: @return      
	     * @return: int      
	     * @throws   
	     */
	    public static int getCurrentMinute() {
			Calendar calendar = new GregorianCalendar();
			return calendar.get(Calendar.MINUTE);
		}
	    
	    /**   
	     * @Title: getDateAMPM   
	     * @Description: 获取上午还是下午
	     * @param: @return      
	     * @return: String      
	     * @throws   
	     */
	    public static String getDateAMPM() {
	        GregorianCalendar ca = new GregorianCalendar();
	        //结果为“0”是上午     结果为“1”是下午
	        int i = ca.get(GregorianCalendar.AM_PM);
	        return i == 0 ? "AM" : "PM";
	    }

	    /**   
	     * @Title: isLeapYear   
	     * @Description: 判断是否闰年
	     * @param: @param ddate
	     * @param: @return      
	     * @return: boolean      
	     * @throws   
	     */
	    public static boolean isLeapYear(String ddate) {

	    	 /**
	         *  详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
	         * 3.能被4整除同时能被100整除则不是闰年
	         */
	        Date d = formatStringToDate(ddate, monthFormat);
	        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
	        gc.setTime(d);
	        int year = gc.get(Calendar.YEAR);
	        if ((year % 400) == 0)
	            return true;
	        else if ((year % 4) == 0) {
	            if ((year % 100) == 0)
	                return false;
	            else
	                return true;
	        } else
	            return false;
	    }
	    
	    /**   
	     * @Title: getEndDate   
	     * @Description: 得到某个时间当天的最后时间 （时分秒为 23:59:59形式)
	     * @param: @param date
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static  Date getEndDate(Date date){
			if(date!=null){
				//将截止时间设为指定日期的23:59:59
				date.setHours(23);
				date.setMinutes(59);
				date.setSeconds(59);
			}
			return date;
		}

	    /**   
	     * @Title: getFirstDayOfMonth   
	     * @Description: 本月第一天
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static Date getFirstDayOfMonth() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			return calendar.getTime();
	 
		}
	    
	    /**   
	     * @Title: getLastDayOfMonth   
	     * @Description: 本月最后一天的日期
	     * @param: @return      
	     * @return: Date      
	     * @throws   
	     */
	    public static Date getLastDayOfMonth() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			return calendar.getTime();
	 
		}



	    
}
