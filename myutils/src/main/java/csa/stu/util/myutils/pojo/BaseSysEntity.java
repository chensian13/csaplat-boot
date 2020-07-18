package csa.stu.util.myutils.pojo;

import java.io.Serializable;

/**
 * 实体类父类-推荐
 * @author csa
 *
 */
public class BaseSysEntity implements Serializable{
	private String info;
	private Long createtime;
	private Long modtime;
	private String isdel;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
	public Long getModtime() {
		return modtime;
	}
	public void setModtime(Long modtime) {
		this.modtime = modtime;
	}
	public String getIsdel() {
		return isdel;
	}
	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}
	
	
	

	
}
