package com.website.bean;

import java.util.Date;

/*
 *属性值表 
 */
public class AttributeValue {

	private int value_id; // 属性值ID
	private String value_name; // 属性值
	private Date create_date; // 添加时间
	private Date update_date; // 更新时间
	private String upload_person; // 上传人
	
	private int  relation_id;

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

	public String getValue_name() {
		return value_name;
	}

	public void setValue_name(String value_name) {
		this.value_name = value_name;
	}

	public String getUpload_person() {
		return upload_person;
	}

	public void setUpload_person(String upload_person) {
		this.upload_person = upload_person;
	}

	public int getValue_id() {
		return value_id;
	}

	public void setValue_id(int value_id) {
		this.value_id = value_id;
	}

	public int getRelation_id() {
		return relation_id;
	}

	public void setRelation_id(int relation_id) {
		this.relation_id = relation_id;
	}

}
