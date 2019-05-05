package com.power.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色关系实体类
 * @author bizf
 *
 */
public class RUMaping implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	private String ru_id;
	private String r_id;
	private String user_id;
	private Date create_date;//注册时间
	private Date update_date;//更新时间
	private String operator;//操作人
	
	
	public String getRu_id() {
		return ru_id;
	}
	public void setRu_id(String ruId) {
		ru_id = ruId;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String rId) {
		r_id = rId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date updateDate) {
		update_date = updateDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
