package com.antke.power.model.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限组实体类
 * 
 * @author bizf
 *
 */
public class PowerGroup implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	private String pgroup_id;
	private String groups_name;// 权限组名称
	private String groups_desc;// 权限组描述
	private Integer status;// 状态：1，启动；2，删除
	private Date create_date;// 注册时间
	private Date update_date;// 更新时间
	private String operator;// 操作人
	private String seller_id; // 商家ID

	private Date start_create_date;
	private Date start_update_date;
	private Date end_create_date;
	private Date end_update_date;

	public String getPgroup_id() {
		return pgroup_id;
	}

	public void setPgroup_id(String pgroupId) {
		pgroup_id = pgroupId;
	}

	public String getGroups_name() {
		return groups_name;
	}

	public void setGroups_name(String groupsName) {
		groups_name = groupsName;
	}

	public String getGroups_desc() {
		return groups_desc;
	}

	public void setGroups_desc(String groupsDesc) {
		groups_desc = groupsDesc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Date getStart_create_date() {
		return start_create_date;
	}

	public void setStart_create_date(Date startCreateDate) {
		start_create_date = startCreateDate;
	}

	public Date getStart_update_date() {
		return start_update_date;
	}

	public void setStart_update_date(Date startUpdateDate) {
		start_update_date = startUpdateDate;
	}

	public Date getEnd_create_date() {
		return end_create_date;
	}

	public void setEnd_create_date(Date endCreateDate) {
		end_create_date = endCreateDate;
	}

	public Date getEnd_update_date() {
		return end_update_date;
	}

	public void setEnd_update_date(Date endUpdateDate) {
		end_update_date = endUpdateDate;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

}
