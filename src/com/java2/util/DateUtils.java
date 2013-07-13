package com.java2.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 文件名：DateUtils.java 日期处理相关工具类
 * 版本信息:v1.0
 * @date:2013-7-13 下午02:12:49
 * @author 陈志延
 * 
 */
public class DateUtils {
	
	/**定义常量**/
	public static final String DATE_JFP_STR = "yyyyMM";
	public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_KEY_STR = "yyMMddHHmmss";
	
	/**
	 * 使用预设格式提取字符串日期
	 * @param strDate 日期字符串
	 * @return 
	 * @throws Exception
	 */
	public static Date parse(String strDate) throws Exception{
		return parse(strDate,DATE_FULL_STR);
	}
	
	/**
	 * 使用用户格式提取字符串信息
	 * @param strDate 日期字符串
	 * @param pattern 日期格式
	 * @return
	 * @throws Exception
	 */
	public static Date parse(String strDate,String pattern) throws Exception{
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try{
			return df.parse(strDate);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 两个时间的比较
	 * @param date1
	 * @return
	 */
	public static int compareDateWithNow(Date date1){
		Date date2 = new Date();
		int rnum = date1.compareTo(date2);
		return rnum;
	}
	
	/**
	 * 两个时间比较(时间戳比较)
	 * @param date1
	 * @return
	 */
	public static int compareDateWithNow(long date1){
		long date2 = dateToUnixTimestamp();
		if(date1 > date2){
			return 1;
		}else if(date1 < date2){
			return -1;
		}else{
			return 0;
		}
	}
    
	/**
	 * 获取系统当前时间
	 * @return
	 */
	public static String getNowTime(){
		SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_STR);
		return df.format(new Date());
	}
	
	/**
	 * 获取系统当前计费期
	 * @return
	 */
	public static String getJFPTime(){
		SimpleDateFormat df = new SimpleDateFormat(DATE_JFP_STR);
		return df.format(new Date());
	}
	
	/**
	 * 将制定的日期转换成Unix时间戳
	 * @param date 需要转换的日期 yyyy-MM-dd HH:mm:ss
	 * @param dateFormat 
	 * @return long 时间戳
	 */
	public static long dateToUnixTimestamp(String date, String dateFormat){
		long timestamp = 0;
		try {
				timestamp = new SimpleDateFormat(dateFormat).parse(date).getTime();
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		return timestamp;
	}
	
	/**
	 * 将当前日期转换成Unix时间戳
	 * @return long 时间戳
	 */
	private static long dateToUnixTimestamp() {
		long timestamp = new Date().getTime();
		return timestamp;
	}
	
	
	/**
	 * 讲Unix时间戳转换成日期
	 * @param timestamp 时间戳
	 * @return String 日期字符串
	 */
	public static String unixTimestampToDate(long timestamp){
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FULL_STR);
		sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sd.format(new Date(timestamp));
	}
}
