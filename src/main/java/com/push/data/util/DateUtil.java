package com.push.data.util;

import java.text.SimpleDateFormat;

public class DateUtil {

	/**
	 * 检查传进来的时间是不是整 5 分钟
	 * @param time
	 * @return
	 */
	public static String checkMinutes(String time){
        String d =time.substring(time.length()-1);
        if(Integer.valueOf(d).intValue()<5){
        	return time.substring(0, time.length()-1)+"0";
        }else{
        	return time.substring(0, time.length()-1)+"5";
        }
	}

	/**
	 * 判断开始时间和结束时间是不是5分钟间隔。
	 * @param start_time
	 * @param end_time
	 * @param minute
	 * @return
	 * @throws Exception
	 */
	public static boolean checkMinutesInterval(String start_time,String end_time,String minute) throws Exception{

		SimpleDateFormat  sm = new SimpleDateFormat("yyyyMMddHHmm");
		long start_d = sm.parse(start_time).getTime();
		long end_d = sm.parse(end_time).getTime();
		if((end_d-start_d) == Integer.valueOf(minute)*60*1000)
			return true;

		return false;
	}

}
