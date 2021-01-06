package csa.stu.util.ap.pojo;

import csa.stu.util.myutils.direct.EmptyUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 返回对象封装
 * @author csa
 *
 */
public class ResultPojo<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8030563023285427198L;
	public static final int OK=1;
	public static final int ERROR=-1;
	public static final int NO=2;
	public static final int NO_TOKEN=3;
	
	private T model;
	private List<T> list;
	private long count;
	private String message;
	private String token;
	private String error;
	private int code;

	public T getModel() {
		return model;
	}
	public void setModel(T model) {
		this.model = model;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	//********************************************************
	public static ResultPojo newInstance(){
		return new ResultPojo();
	}
	public static ResultPojo newInstance(Object model){
		ResultPojo rs=new ResultPojo();
		if(EmptyUtil.isEmpty(model)){
			rs.setCode(ERROR);
		}else{
			rs.setCode(OK);
			rs.setModel(model);
		}
		return rs;
	}

	public static ResultPojo newInstance(int code, String message) {
		ResultPojo vo = new ResultPojo();
		vo.setCode(code);
		vo.setMessage(message);
		return vo;
	}

	public static ResultPojo newInstance(List data, long count) {
		ResultPojo vo = new ResultPojo();
		if(!EmptyUtil.isEmpty(data)){
			vo.setCode(OK);
			vo.setCount(count);
			vo.setList(data);
		}
		return vo;
	}


	@Override
	public String toString() {
		return "ResultPojo{" +
				"model=" + model +
				", list=" + list +
				", count=" + count +
				", message='" + message + '\'' +
				", token='" + token + '\'' +
				", error='" + error + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}
