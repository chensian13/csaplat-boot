package csa.stu.util.myutils.utils;

import com.alibaba.fastjson.JSON;

/**
 *
 * @author csa
 */
public abstract class JSONUtil {
	
	public static <T> String formatJSON(T obj){
		if(obj==null) return null;
		return JSON.toJSONString(obj);
	}
	
	public static <T> T parseObj(String json,Class<T> clazz){
		if(json==null) return null;
		return JSON.parseObject(json, clazz);
	}

	public static Object parseObj(String json){
		return parseObj(json,Object.class);
	}


}
