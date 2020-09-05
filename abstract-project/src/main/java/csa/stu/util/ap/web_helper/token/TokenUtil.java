package csa.stu.util.ap.web_helper.token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token操作+用户登录信息
 */
public interface TokenUtil {

    public Object getTokenCookie(HttpServletRequest request);

    public void setTokenCookie(HttpServletResponse response, String value);

    public void removeTokenCookie(HttpServletResponse response);

}
