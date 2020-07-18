package csa.stu.util.components;

import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获基类
 * @author csa
 *
 */
public class AdviceController {
	
	@ExceptionHandler
	@ResponseBody
	public ResultPojo exceptionHandler(Throwable e){
		String msg=e.getMessage();
		if(EmptyUtil.isEmpty(msg)){
			msg="服务器异常";
		}
		return ResultPojo.newInstance(ResultPojo.ERROR,msg);
	}

}
