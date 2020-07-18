package csa.stu.util.components;

import csa.stu.util.myutils.utils.EmptyUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserinfoUtil {

    /**
     * 盐值加密
     * @param password
     * @return
     */
    public String saltPassword(String password,String salt){
        if(EmptyUtil.isEmptys(password,salt)) return null;
        SimpleHash sh=new SimpleHash("MD5", password, salt, 13);
        //转换16进制
        return sh.toHex();
    }

    public void setUserCookie(HttpServletResponse response,String token){
        //存入token
        Cookie cookie=new Cookie("token",token);
        cookie.setMaxAge(60*60*24*7);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 登出
     * @param response
     */
    public void logout(HttpServletResponse response){
        Cookie cookie=new Cookie("token",null);
        cookie.setMaxAge(0);
        cookie.setPath("/"); //必须要和登录设置cookie路径一致，否则无效
        response.addCookie(cookie);
    }


    /**
     * 获取token cookie信息
     * @param request
     */
    public String getTokenCookie(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(cookies==null) return null;
        for(Cookie cookie:cookies){
            if("token".equals(cookie.getName())
                    && !EmptyUtil.isEmpty(cookie.getValue())){
                return cookie.getValue();
            }
        } //end for
       return null;
    }

}