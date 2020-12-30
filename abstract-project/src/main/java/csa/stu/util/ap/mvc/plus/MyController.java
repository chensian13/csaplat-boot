package csa.stu.util.ap.mvc.plus;

import csa.stu.util.ap.mvc.IController;
import csa.stu.util.ap.mvc.IService;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.ap.pojo.constant.OperConstant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 系统控制器
 * swagger路径:http://127.0.0.1:port/swagger-ui.html
* @Author:         陈思安
* @Version:     2019/6/29 16:01
*/
public abstract class MyController<T>  implements IController<T> {

    public abstract IService<T> getService();


    /**
     * 方法描述:操作数据
     * 五个操作：增，删，改，有效无效，提交
     * @param: 实体类+操作符变量
     * @return:
     * @exception:
     * @date: 2019/6/29 16:10
     */
    @PostMapping("/data/{oper}")
    @ResponseBody
    @Override
    public ResultPojo<T> operData(@RequestBody T entity, @PathVariable String oper, HttpServletRequest request, HttpServletResponse response) {
        if(OperConstant.OPER_ADD.equals(oper)){
            //新增操作
            return getService().addOne(entity);
        }else if(OperConstant.OPER_DEL.equals(oper)){
            //删除操作
            return getService().delOne(entity);
        }else if(OperConstant.OPER_UPD.equals(oper)){
            //修改操作
            return getService().updOne(entity);
        }else if(OperConstant.OPER_STOP.equals(oper)){
            //置位无效操作
            return getService().stopOne(entity);
        }else if(OperConstant.OPER_SUBMIT.equals(oper)){
            //置位无效操作
            return getService().submitOne(entity);
        }
        return ResultPojo.newInstance();
    }

    @Override
    @PostMapping("/queryById/{id}")
    @ResponseBody
    public ResultPojo<T> queryById(@PathVariable String id,HttpServletRequest request, HttpServletResponse response) {
        return getService().selectById(id);
    }

    @Override
    @PostMapping("/queryData")
    @ResponseBody
    public ResultPojo<T> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
        return getService().selectData(paramPojo);
    }

    @PostMapping("/querySimpleData")
    @ResponseBody
    @Override
    public ResultPojo<T> querySimpleData(ParamPojo paramPojo, HttpServletRequest request, HttpServletResponse response) {
        return getService().selectSimpleData(paramPojo);
    }

}
