package com.power.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限菜单关系实体类
 * @author bizf
 *
 */
public class GMMaping implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	private String m_id;
	private String pgroup_id;
	private String gm_id;
	private Date create_date;//注册时间
	private Date update_date;//更新时间
	private String operator;//操作人
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String mId) {
		m_id = mId;
	}
	public String getPgroup_id() {
		return pgroup_id;
	}
	public void setPgroup_id(String pgroupId) {
		pgroup_id = pgroupId;
	}
	public String getGm_id() {
		return gm_id;
	}
	public void setGm_id(String gmId) {
		gm_id = gmId;
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
