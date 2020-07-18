package csa.stu.util.myutils.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author csa
 *
 */
public abstract class EmptyUtil {
	
	public static boolean isEmpty(String str){
		if(str==null || str.trim().equals("")) return true;
		return false;
	}
	
	public static boolean isEmpty(Object obj){
		if(obj==null) return true;
		if(obj instanceof String){
			if(obj.toString().trim().equals("")){
				return true;
			}
		}
		if(obj instanceof Number){
			if(((Number) obj).intValue()==0){
				return true;
			}
		}
		if(obj instanceof Collection){
			if(((Collection) obj).isEmpty()){
				return true;
			}
		}
		if(obj instanceof Map){
			if(((Map) obj).isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isEmptys(Object...objs){
		for (Object object : objs) {
			if(isEmpty(object)) return true;
		}
		return false;
	}

}
