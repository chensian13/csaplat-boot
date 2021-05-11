package csa.stu.util.ap.mvc.plus;

import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.myutils.direct.EmptyUtil;
import javax.servlet.http.HttpServletRequest;

/**
 * 校验登录控制器
 * @param <T>
 */
public interface CheckLoginController {

    /**
     * 获取用户登录信息
     * @param request
     * @return
     */
    public abstract Object getLoginUser(HttpServletRequest request);

    /**
     * 获取白名单方法
     * @return
     */
    public abstract String[] getWhiteMethod();

    /**
     * 封装登录信息+检查是否登录
     * @param request
     * @param product
     * @return
     */
    default ResultPojo wrapUser(HttpServletRequest request, String whiteMethod , Product product){
        // 检查白名单
        if(!EmptyUtil.isEmpty(whiteMethod)
                && getWhiteMethod() != null){
            for(String path : getWhiteMethod()){
                if(path.equals(whiteMethod)){
                    product.exe(null);
                }
            } // end for
        }
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
