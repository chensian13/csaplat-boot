package csa.stu.util.ap.mvc;

import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 控制层接口，定义公共方法
* @Author:         陈思安
* @Version:     2019/6/29 14:49
*/
public interface IController<T> {
    /**
     * 单表操作
     * @param t
     * @param oper
     * @return
     */
    ResultPojo<T> operData(T t, String oper, HttpServletRequest request, HttpServletResponse response);

    /**
     * 方法描述:依据id查询记录
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:53
     */
    ResultPojo<T> queryById(String id, HttpServletRequest request, HttpServletResponse response);

    /**
     * 方法描述:分页查询，复杂关联查询
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:53
     */
    ResultPojo<T> queryData(ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 方法描述:分页查询，简单单表查询
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:53
     */
    ResultPojo<T> querySimpleData(ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response);
}
