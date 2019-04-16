package com.antke.promotion.model.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class PromotionGoods implements Serializable {

	private static final long serialVersionUID = -3433261697936262043L;

	private String id;
	private Date create_date; // 创建时间
	private Date update_date; // 更新时间
	private String upload_person; // 录入人
	private String promotion_name; // 促销名称
	private Integer promotion_type; // 促销类型
	private Date start_time; // 促销开始时间
	private Date end_time; // 促销结束时间
	private Integer status; // 促销状态
	private Integer single_min_buy; // 单次最小购买数
	private Integer single_max_buy; // 单次最大购买数
	private String message; // 促销广告词
	private String start_time_limit; // 限时抢购开始时间
	private String end_time_limit; // 限时抢购结束时间
	private Integer expense_account; // 费用承担方
	private Integer source; // 渠道分类
	private Integer receive_limit; // 领取限制
	private Integer buy_limit; // 购买限制
	private Integer preferential_term; // 优惠项 折扣 直降 返积分 送券 满多少减多少 每满减
	private String preferential_value; // 优惠值
	private Double full_cut_value; // 满减值
	private Integer total_stock; // 总库存
	private String remarks; // 促销备注

	// 查询条件冗余字段
	private String start_start_time; // 查询开始时间的开始时间
	private String end_start_time; // 查询开始时间的结束时间
	private String start_end_time;// 查询结束时间的开始时间
	private String end_end_time;// 查询结束时间的结束时间

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

	public String getPromotion_name() {
		return promotion_name;
	}

	public void setPromotion_name(String promotion_name) {
		this.promotion_name = promotion_name;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSingle_min_buy() {
		return single_min_buy;
	}

	public void setSingle_min_buy(Integer single_min_buy) {
		this.single_min_buy = single_min_buy;
	}

	public Integer getSingle_max_buy() {
		return single_max_buy;
	}

	public void setSingle_max_buy(Integer single_max_buy) {
		this.single_max_buy = single_max_buy;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStart_time_limit() {
		return start_time_limit;
	}

	public void setStart_time_limit(String start_time_limit) {
		this.start_time_limit = start_time_limit;
	}

	public String getEnd_time_limit() {
		return end_time_limit;
	}

	public void setEnd_time_limit(String end_time_limit) {
		this.end_time_limit = end_time_limit;
	}

	public Integer getExpense_account() {
		return expense_account;
	}

	public void setExpense_account(Integer expense_account) {
		this.expense_account = expense_account;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getReceive_limit() {
		return receive_limit;
	}

	public void setReceive_limit(Integer receive_limit) {
		this.receive_limit = receive_limit;
	}

	public Integer getBuy_limit() {
		return buy_limit;
	}

	public void setBuy_limit(Integer buy_limit) {
		this.buy_limit = buy_limit;
	}

	public Integer getPreferential_term() {
		return preferential_term;
	}

	public void setPreferential_term(Integer preferential_term) {
		this.preferential_term = preferential_term;
	}

	public String getPreferential_value() {
		return preferential_value;
	}

	public void setPreferential_value(String preferential_value) {
		this.preferential_value = preferential_value;
	}

	public Double getFull_cut_value() {
		return full_cut_value;
	}

	public void setFull_cut_value(Double full_cut_value) {
		this.full_cut_value = full_cut_value;
	}

	public Integer getTotal_stock() {
		return total_stock;
	}

	public void setTotal_stock(Integer total_stock) {
		this.total_stock = total_stock;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getPromotion_type() {
		return promotion_type;
	}

	public void setPromotion_type(Integer promotion_type) {
		this.promotion_type = promotion_type;
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

	public String getStart_end_time() {
		return start_end_time;
	}

	public void setStart_end_time(String start_end_time) {
		this.start_end_time = start_end_time;
	}

	public String getEnd_end_time() {
		return end_end_time;
	}

	public void setEnd_end_time(String end_end_time) {
		this.end_end_time = end_end_time;
	}

}
