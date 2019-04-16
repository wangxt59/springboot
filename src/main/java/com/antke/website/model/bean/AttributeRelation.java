package com.antke.website.model.bean;

import java.util.Date;

/*
 * 属性关系表
 */
public class AttributeRelation {

	private int relation_id; // 属性关系ID
	private String attr_id; // 属性ID
	private String value_id; // 属性值ID
	private String category_id; // 属性值ID

	private String attr_name;
	private String value_name;
	private String status;
	private Date create_date;
	private Date update_date;
	private String upload_person;
	private Integer checked; // 页面展示时候加复选框
	
	//关联数据
	private String parent_id;//父类ID
	private String category_name;//分类名称
	
	
	
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String categoryName) {
		category_name = categoryName;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parentId) {
		parent_id = parentId;
	}

	public String getAttr_name() {
		return attr_name;
	}

	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}

	public String getValue_name() {
		return value_name;
	}

	public void setValue_name(String value_name) {
		this.value_name = value_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getUpload_person() {
		return upload_person;
	}

	public void setUpload_person(String upload_person) {
		this.upload_person = upload_person;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}


	public String getAttr_id() {
		return attr_id;
	}

	public void setAttr_id(String attr_id) {
		this.attr_id = attr_id;
	}

	public String getValue_id() {
		return value_id;
	}

	public void setValue_id(String value_id) {
		this.value_id = value_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String categoryId) {
		category_id = categoryId;
	}

	public int getRelation_id() {
		return relation_id;
	}

	public void setRelation_id(int relation_id) {
		this.relation_id = relation_id;
	}

}
