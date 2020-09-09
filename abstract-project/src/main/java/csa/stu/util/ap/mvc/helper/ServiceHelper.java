package csa.stu.util.ap.mvc.helper;

import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.myutils.direct.EmptyUtil;
import csa.stu.util.myutils.exception.CsaplatException;
import csa.stu.util.myutils.fn.ConsumerDouble;
import org.springframework.util.DigestUtils;

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

    /**
     * 32为uuid
     * @return
     */
    public static String generateUUID32(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成时间戳id
     * @return
     */
    public static String generateTimestampID(){
        StringBuffer sb=new StringBuffer(String.valueOf(System.currentTimeMillis()));
        sb.append(generateRandomNumberString(5));
        return sb.toString();
    }

    public static String generateRandomNumberString(int len){
        if(len <= 0){
            throw new RuntimeException("length must > 0");
        }
        StringBuffer sb=new StringBuffer();
        Random ran=new Random();
        for(int i=0;i<len;i++){
            sb.append(ran.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateCode(String tag){
        StringBuffer sb=new StringBuffer(tag);
        sb.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        sb.append(generateRandomNumberString(4));
        return sb.toString();
    }

    /**
     * spring自带的md5加密
     * @param password
     * @param salt
     * @return
     */
    public static String md5Password(String password,String salt){
        if(password==null){
            throw new RuntimeException("password is null");
        }
        if(salt==null){
            throw new RuntimeException("salt is null");
        }
        StringBuffer sb=new StringBuffer(password);
        sb.append(salt);
        return DigestUtils.md5DigestAsHex(sb.toString().getBytes());
    }


}
