package csa.stu.util.ap.mvc;

import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;

/**
* 业务层针对一个数据库实体类，所以规定为泛型
 * 方法包含基本单表操作：增删改查
 * 多条件查询
* @Author:         陈思安
* @Version:     2019/6/29 14:19
*/
public interface IService<T> {
    /**
     * 方法描述:添加一条记录
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:34
     */
    ResultPojo<T> addOne(T t);

    /**
     * 方法描述:依据id修改一条记录
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:34
     */
    ResultPojo<T> updOne(T t);
    /**
     * 方法描述:依据id删除一条记录
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:34
     */
    ResultPojo<T> delOne(T t);
    /**
     * 方法描述:依据id置为无效
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:34
     */
    ResultPojo<T> stopOne(T t);
    /**
     * 方法描述:依据id提交
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:34
     */
    ResultPojo<T> submitOne(T t);
    /**
     * 方法描述:依据id查询一条记录
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:34
     */
    ResultPojo<T> selectById(String id);
    /**
     * 方法描述:多条件查询数据，复杂查询
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:36
     */
    ResultPojo<T> selectData(ParamPojo wrap);

    /**
     * 方法描述:多条件查询数据，简单单表查询
     *
     * @param:
     * @return:
     * @exception:
     * @date: 2019/6/29 14:36
     */
    ResultPojo<T> selectSimpleData(ParamPojo wrap);

    //*****************************校验逻辑*****************************
    /**
     * 校验唯一值属性
     * 1）不允许重复
     * 2）不允许为空
     * 校验信息封装到rs对象
     * @param data
     * @param rs
     * @return 校验失败返回false
     */
    boolean checkUniqueField(T data, ResultPojo<T> rs, String oper);


}
