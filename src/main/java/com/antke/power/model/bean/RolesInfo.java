package com.antke.power.model.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色信息实体类
 * 
 * @author bizf
 *
 */
public class RolesInfo implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	private String role_id;
	private String role_name;// 角色名称
	private Integer status_flg;// 状态：
	private Date create_date;// 注册时间
	private Date update_date;// 更新时间
	private String discribe;//描述
	private String poerator_id;// 操作人
	private String check;
	private String seller_id;
	private Integer rank;
	
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	// 扩展字段
	private String selectedPgroup;// 权限组串

	public String getSelectedPgroup() {
		return selectedPgroup;
	}

	public void setSelectedPgroup(String selectedPgroup) {
		this.selectedPgroup = selectedPgroup;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String roleId) {
		role_id = roleId;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public Integer getStatus_flg() {
		return status_flg;
	}

	public void setStatus_flg(Integer statusFlg) {
		status_flg = statusFlg;
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

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public String getPoerator_id() {
		return poerator_id;
	}

	public void setPoerator_id(String poeratorId) {
		poerator_id = poeratorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

}
