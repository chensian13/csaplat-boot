package csa.stu.util.ap.web_helper.cors;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器，继承方案
 */
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        configCors(request,response);
        filterChain.doFilter(req, res);
    }

    /**
     * 配置cors
     */
    protected void configCors(HttpServletRequest request,HttpServletResponse response){
        String origin=request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin",origin);
        response.setHeader("Access-Control-Allow-Methods", "*");
        // 表示XHR是否接收cookies和发送cookies
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //第一次的预检请求获知服务器是否允许该跨域请求：如果允许，才发起第二次真实的请求；如果不允许，则拦截第二次请求
        // 用来指定本次预检请求的有效期，单位为秒，，在此期间不用发出另一条预检请求
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild");
    }

    @Override
    public void destroy() { }
}
