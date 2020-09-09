package csa.stu.util.ap.web_helper.token;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public interface UserInfoUtil {

    public Object getUser(String token);

    public void putUser(String token,Object user);

    public void removeUser(String token);

}
