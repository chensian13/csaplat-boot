package csa.stu.util.ap.mvc.plus;

import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.myutils.direct.EmptyUtil;
import javax.servlet.http.HttpServletRequest;

/**
 * 校验登录控制器
 * @param <T>
 */
public interface CheckLoginController {
    public static final String CHECK_LOGIN="checkLogin";

    public abstract Object getLoginUser(HttpServletRequest request);


    /**
     * 封装登录信息+检查是否登录
     * @param request
     * @param product
     * @return
     */
    default ResultPojo wrapUser(HttpServletRequest request, Product product){
        String cl=request.getHeader(CHECK_LOGIN);
        if(EmptyUtil.isEmpty(cl)){
            //不必登录就可以访问
            return product.exe(null);
        }
        return mustWrapUser(request,product);
    }

    /**
     * 必须有登录信息
     * @param request
     * @param product
     * @return
     */
    default ResultPojo mustWrapUser(HttpServletRequest request,Product product){
        Object user=getLoginUser(request);
        if(user==null){
            return rsNoLogin();
        }
        return product.exe(user);
    }



    default ResultPojo rsNoLogin(){
        return ResultPojo.newInstance(ResultPojo.NO,"请先登录");
    }

    public interface Product{
        public ResultPojo exe(Object user);
    }

}
