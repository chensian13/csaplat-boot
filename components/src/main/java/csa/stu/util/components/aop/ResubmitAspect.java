package csa.stu.util.components.aop;

import csa.stu.util.components.ResubmitLockUtil;
import csa.stu.util.components.annotation.Resubmit;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 防止重复提交切面定义
 * 取消重复提交
 */
@Component
@Aspect
public class ResubmitAspect {
    @Autowired
    private ResubmitLockUtil resubmitLockUtil;

    @Around("@annotation(resubmit)")
    public ResultPojo handleResubmit(ProceedingJoinPoint joinPoint, Resubmit resubmit){
        Object[] args=joinPoint.getArgs();
        StringBuffer sb=new StringBuffer();
        for(Object arg:args){
            sb.append(JSONUtil.formatJSON(arg));
        }
        if(resubmitLockUtil.look(sb.toString(),this)){
            try {
                return (ResultPojo) joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            //针对重复提交
            resubmitLockUtil.unlook(sb.toString(),resubmit.delayTime());
        }
        return ResultPojo.newInstance(ResultPojo.NO,"重复提交");
    }



}