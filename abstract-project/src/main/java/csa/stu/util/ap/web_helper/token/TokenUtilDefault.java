package csa.stu.util.ap.web_helper.token;

import csa.stu.util.ap.mvc.helper.ControllerHelper;
import csa.stu.util.myutils.direct.EmptyUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认token帮助类
 */
public class TokenUtilDefault implements TokenUtil {
    private String TOKEN_NAME="token";
    private int TOKEN_TIME = 60*60*24*7;
    private String TOKEN_PATH = "/";

    @Override
    public String getTokenCookie(HttpServletRequest request) {
        String val=ControllerHelper.getCookieValue(request,TOKEN_NAME);
        if(EmptyUtil.isEmpty(val)) return null;
        return ControllerHelper.decodeUTF8(val);
    }

    @Override
    public void setTokenCookie(HttpServletResponse response, String value) {
        if(EmptyUtil.isEmpty(value))
            throw new RuntimeException("value is null");
        //存入token
        Cookie cookie=new Cookie(TOKEN_NAME,value);
        cookie.setMaxAge(TOKEN_TIME);
        cookie.setPath(TOKEN_PATH);
        response.addCookie(cookie);
    }

    @Override
    public void removeTokenCookie(HttpServletResponse response) {
        Cookie cookie=new Cookie(TOKEN_NAME,null);
        cookie.setMaxAge(0);
        // 必须要和登录设置cookie路径一致，否则无效
        cookie.setPath(TOKEN_PATH);
        response.addCookie(cookie);
    }


    public void setTOKEN_NAME(String TOKEN_NAME) {
        this.TOKEN_NAME = TOKEN_NAME;
    }

    public void setTOKEN_TIME(int TOKEN_TIME) {
        this.TOKEN_TIME = TOKEN_TIME;
    }

    public void setTOKEN_PATH(String TOKEN_PATH) {
        this.TOKEN_PATH = TOKEN_PATH;
    }
}
