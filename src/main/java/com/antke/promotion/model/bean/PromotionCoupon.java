package com.antke.promotion.model.bean;

import java.io.Serializable;
import java.util.Date;

public class PromotionCoupon implements Serializable {
	private static final long serialVersionUID = -1407351169222357388L;

	private String id;
	private Date create_date; // 创建时间
	private Date update_date; // 更新时间
	private String upload_person; // 录入人
	private String coupon_name; // 优惠券名称
	private Integer use_quantity; // 使用数量
	private Double amount; // 面值
	private Double use_restrictions; // 使用限制
	private Integer status; // 状态
	private Date start_time; // 开始时间
	private Date end_time; // 结束时间
	private Integer type; // 类型
	private Integer expense_account; // 费用承担方
	private Integer coupon_method; // 发放优惠券方式
	private Integer quantity; // 发券数量
	private Integer receive_limit; // 领取限制
	private String remarks; // 备注
	private Integer send_quantity; // 已发数量
	private Integer used_quantity; // 使用数量
	private Integer unused_quantity; // 未使用数量

	// 查询条件冗余字段
	private String start_start_time; // 开始时间的开始时间
	private String end_start_time; // 开始时间的结束时间
	
	//新增字段
	private String full_count;
	
	public String getFull_count() {
		return full_count;
	}

	public void setFull_count(String fullCount) {
		full_count = fullCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public Integer getUse_quantity() {
		return use_quantity;
	}

	public void setUse_quantity(Integer use_quantity) {
		this.use_quantity = use_quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getUse_restrictions() {
		return use_restrictions;
	}

	public void setUse_restrictions(Double use_restrictions) {
		this.use_restrictions = use_restrictions;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getExpense_account() {
		return expense_account;
	}

	public void setExpense_account(Integer expense_account) {
		this.expense_account = expense_account;
	}

	public Integer getCoupon_method() {
		return coupon_method;
	}

	public void setCoupon_method(Integer coupon_method) {
		this.coupon_method = coupon_method;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getReceive_limit() {
		return receive_limit;
	}

	public void setReceive_limit(Integer receive_limit) {
		this.receive_limit = receive_limit;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStart_start_time() {
		return start_start_time;
	}

	public void setStart_start_time(String start_start_time) {
		this.start_start_time = start_start_time;
	}

	public String getEnd_start_time() {
		return end_start_time;
	}

	public void setEnd_start_time(String end_start_time) {
		this.end_start_time = end_start_time;
	}

	public Integer getSend_quantity() {
		return send_quantity;
	}

	public void setSend_quantity(Integer send_quantity) {
		this.send_quantity = send_quantity;
	}

	public Integer getUnused_quantity() {
		return unused_quantity;
	}

	public void setUnused_quantity(Integer unused_quantity) {
		this.unused_quantity = unused_quantity;
	}

	public Integer getUsed_quantity() {
		return used_quantity;
	}

	public void setUsed_quantity(Integer used_quantity) {
		this.used_quantity = used_quantity;
	}

}
