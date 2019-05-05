package com.website.bean;

import java.util.Date;
import java.util.List;

/**
 * 属性表
 * 
 * @author casystar
 * 
 */
public class Attribute {
	private int attr_id; // 属性ID
	private String attr_name; // 属性名称
	private Integer status; // 状态
	private Date create_date; // 添加时间
	private Date update_date; // 更新时间
	private String upload_person; // 上传人
	private Integer sort; // 排序值

	private String str;

	private List list;// 属性list

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}


	public String getAttr_name() {
		return attr_name;
	}

	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUpload_person() {
		return upload_person;
	}

	public void setUpload_person(String upload_person) {
		this.upload_person = upload_person;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public int getAttr_id() {
		return attr_id;
	}

	public void setAttr_id(int attr_id) {
		this.attr_id = attr_id;
	}

}
