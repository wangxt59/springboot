package com.antke.promotion.model.bean;

import java.io.Serializable;
import java.util.Date;

public class PromotionCouponBatch implements Serializable {

	private static final long serialVersionUID = -2772841234308894638L;

	private String id;
	private String pc_id; // 优惠券ID
	private Date collection_time; // 发券日期
	private Integer status; // 优惠券状态： 1 未使用 2 已使用  3、 已作废
	private Date create_date; // 創建時間
	private Date update_date; // 更新時間
	private String user_id; // 用户id
	private String coupon_code; // 激活码

	// 关联表查询冗余字段
	private String coupon_name; // 优惠券名称
	private Double amount; // 面值
	private Date start_time; // 开始时间
	private Date end_time; // 结束时间
	private Integer type; // 类型

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPc_id() {
		return pc_id;
	}

	public void setPc_id(String pc_id) {
		this.pc_id = pc_id;
	}

	public Date getCollection_time() {
		return collection_time;
	}

	public void setCollection_time(Date collection_time) {
		this.collection_time = collection_time;
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

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getCoupon_code() {
		return coupon_code;
	}

	public void setCoupon_code(String couponCode) {
		coupon_code = couponCode;
	}

}
