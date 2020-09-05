package csa.stu.util.ap.mvc.helper;

import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.myutils.direct.EmptyUtil;
import csa.stu.util.myutils.fn.ConsumerDouble;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 业务层帮助类
 */
public class ServiceHelper {

    /**
     * 是否分页,如果分页进行分页拦截设置
     * @param paramPojo
     * @return
     */
    public static void page(ParamPojo paramPojo, ConsumerDouble<Integer,Integer> pageOper){
        if(EmptyUtil.isEmptys(paramPojo,paramPojo.getPage(),paramPojo.getPagesize())){
           return ;
        }
        if(pageOper!=null)
            pageOper.consume(paramPojo.getPage(),paramPojo.getPagesize());
    }

    public static String generateUUID32(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generateCode(String tag){
        StringBuffer sb=new StringBuffer(tag);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        sb.append(sdf.format(new Date()));
        Random ran=new Random();
        for(int i=0;i<4;i++){
            sb.append(ran.nextInt(10));
        }
        return sb.toString();
    }



}
