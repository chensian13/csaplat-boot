package csa.stu.util.myutils.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 字符串工具类
 * @author  csa
 */
public abstract class StrUtil {
	
	public static String generateUUID32(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String generateCode(String tag){
		StringBuffer sb=new StringBuffer(tag);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		sb.append(sdf.format(new Date()));
		Random ran=new Random();
		for(int i=0;i<4;i++){
			sb.append(ran.nextInt(10));
		}
		return sb.toString();
	}
	



	public static String encode(String val){
		if(val==null) return null;
		try{
			val= URLEncoder.encode(val,"utf-8");
		}catch (Exception e){
			throw new RuntimeException("编码失败:"+e.getMessage());
		}
		return val;
	}

	public static String decode(String val){
		if(val==null) return null;
		try{
			val= URLDecoder.decode(val,"utf-8");
		}catch (Exception e){
			throw new RuntimeException("编码失败:"+e.getMessage());
		}
		return val;
	}

}
