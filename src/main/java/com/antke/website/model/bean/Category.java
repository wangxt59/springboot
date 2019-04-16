package com.antke.website.model.bean;

import java.util.Date;
import java.util.List;

/**
 * 分类信息实体类
 * @author bizf	
 * 
 */
public class Category {

	private String category_id;		//  分类ID   主键
	private String category_name;	//  分类名称
	private String category_pic;	//  分类图片
	private String parent_id;		//  父ID
	private Integer rank;			//  基别
	private Integer status;			//  分类状态
	private Date create_date;		//  创建时间
	private Date update_date;		//  更新时间
	private Integer sort_order;		//  排序序号
	private Integer is_show;			//  是否显示
	private String operator;
	
	
	
	
	private String parent_name;//上级分类ID
	private String child_id;//子ID
	private String check;
	private List categoryList;
	private List thridList;//三级节点集合
	private String thrid_id;//三级节点
	public String getChild_id() {
		return child_id;
	}

	public void setChild_id(String childId) {
		child_id = childId;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parentName) {
		parent_name = parentName;
	}

	public String getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}
	
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public String getParent_id() {
		return parent_id;
	}
	
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	
	public Integer getRank() {
		return rank;
	}
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getSort_order() {
		return sort_order;
	}

	public void setSort_order(Integer sort_order) {
		this.sort_order = sort_order;
	}

	public Integer getIs_show() {
		return is_show;
	}

	public void setIs_show(Integer is_show) {
		this.is_show = is_show;
	}

	public String getCategory_pic() {
		return category_pic;
	}

	public void setCategory_pic(String categoryPic) {
		category_pic = categoryPic;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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

	public List getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List categoryList) {
		this.categoryList = categoryList;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public List getThridList() {
		return thridList;
	}

	public void setThridList(List thridList) {
		this.thridList = thridList;
	}

	public String getThrid_id() {
		return thrid_id;
	}

	public void setThrid_id(String thridId) {
		thrid_id = thridId;
	}
	
	
}
