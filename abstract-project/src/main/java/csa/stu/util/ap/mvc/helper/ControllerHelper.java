package csa.stu.util.ap.mvc.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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



}
