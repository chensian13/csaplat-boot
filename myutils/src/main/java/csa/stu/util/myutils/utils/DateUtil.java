package csa.stu.util.myutils.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author csa
 *
 */
public abstract class DateUtil {

	/**
	 * 默认东八区
	 * @param million
	 * @param pattern
	 * @return
	 */
	public static String format(Long million,String pattern){
		if(million==null){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone("Etc/GMT-8"));
		return sdf.format(new Date(million));
	}


	public static long nowTime(){
		return new Date().getTime();
	}


}
