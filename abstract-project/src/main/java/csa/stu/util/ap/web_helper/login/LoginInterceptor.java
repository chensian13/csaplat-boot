package csa.stu.util.ap.web_helper.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author  csa
 */
public abstract class LoginInterceptor implements HandlerInterceptor {
    protected Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);

    public abstract Object getLoginUser(HttpServletRequest request);

    public abstract void getLoginPath(HttpServletRequest request, HttpServletResponse response, Object handler);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            Object user=getLoginUser(request);
            logger.info("已拦截："+request.getRequestURI());
            if(user!=null){
                logger.info("请求放行："+user);
                return true;
            }
            getLoginPath(request, response, handler);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
