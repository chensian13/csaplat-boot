package csa.stu.util.ap.web_helper.token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token操作+用户登录信息
 */
public interface TokenUtil {

    public Object getToken(HttpServletRequest request);

    public void setToken(HttpServletResponse response, String value);

    public void removeToken(HttpServletResponse response);

}
