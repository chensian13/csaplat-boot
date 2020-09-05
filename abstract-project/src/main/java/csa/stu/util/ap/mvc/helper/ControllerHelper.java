package csa.stu.util.ap.mvc.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 控制层帮助类
 * @author  csa
 */
public class ControllerHelper {

    /**
     * 获取指定的cookie值
     * @param cookies
     * @param name
     * @return
     */
    public static String getCookieValue(Cookie[] cookies, String name){
        if(cookies==null
                || cookies.length==0) return null;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(name)){
                return cookie.getValue();
            }
        } //end for
        return null;
    }

    /**
     * 获得请求中所带的指定cookie
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name){
        if(request==null) return null;
        return getCookieValue(request.getCookies(),name);
    }



    public static String encodeUTF8(String val){
        try{
            val= URLEncoder.encode(val,"utf-8");
        }catch (Exception e){
            throw new RuntimeException("编码失败:"+e.getMessage());
        }
        return val;
    }

    public static String decodeUTF8(String val){
        try{
            val= URLDecoder.decode(val,"utf-8");
        }catch (Exception e){
            throw new RuntimeException("解码失败:"+e.getMessage());
        }
        return val;
    }


}
