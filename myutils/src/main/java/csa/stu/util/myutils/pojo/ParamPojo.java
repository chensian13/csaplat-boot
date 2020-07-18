package csa.stu.util.myutils.pojo;

import csa.stu.util.myutils.utils.EmptyUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 请求参数封装
 * @author csa
 *
 */
public class ParamPojo implements Serializable{
	private Map<String,Object> map;
	private Integer page;
	private Integer pagesize;
	
	
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	
	public void put(String key,Object value) {
		if(map==null) map=new HashMap<String,Object>();
		map.put(key, value);
	}

	/**
	 * 封装条件
	 * @param param
	 * @param consumer
	 */
	public static void wrapParams(ParamPojo param, Consumer<Map.Entry<String, Object>> consumer){
		if(param!=null && param.getMap()!=null){
			for(Map.Entry<String,Object> entry:param.getMap().entrySet()){
				//key or value为空直接下一个
				if(EmptyUtil.isEmptys(entry.getValue(),entry.getKey())) continue;
				consumer.accept(entry);
			} //end for
		}
	}

}
