package csa.stu.util.ap.mvc.helper;

import com.github.pagehelper.PageHelper;
import csa.stu.util.myutils.pojo.ParamPojo;

/**
 * 业务层帮助类
 */
public class ServiceHelper {

    /**
     * 是否分页,如果分页进行分页拦截设置
     * @param paramPojo
     * @return
     */
    public static boolean canPage(ParamPojo paramPojo){
        if(paramPojo!=null
                && paramPojo.getPage()!=null
                && paramPojo.getPagesize()!=null){
            PageHelper.startPage(paramPojo.getPage(), paramPojo.getPagesize());
            return true;
        }
        return false;
    }
}
