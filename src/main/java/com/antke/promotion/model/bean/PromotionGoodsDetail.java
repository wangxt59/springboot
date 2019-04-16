package com.antke.promotion.model.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品促销明细
 * @author 旭
 *
 */
public class PromotionGoodsDetail implements Serializable {

	private static final long serialVersionUID = -3433261697936262043L;

	private String id;
	private String promotion_id; // 促销ID
	private Date create_date; // 创建时间
	private Date update_date; // 更新时间

	private String goods_id; // 商品ID
	private String goods_name; // 商品名称
	private Double market_value; // 商品市场价
	private Double selling_price; // 销售价

	private Double rate; // 扣率
	private Double settle_price; // 结算价

	private Integer status; // 商品促销状态

	// 单品促销用
	private Integer stock_quantity; // 库存
	private Integer activity_quantity; // 活动数量

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(String promotion_id) {
		this.promotion_id = promotion_id;
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

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public Double getMarket_value() {
		return market_value;
	}

	public void setMarket_value(Double market_value) {
		this.market_value = market_value;
	}

	public Double getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(Double selling_price) {
		this.selling_price = selling_price;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getSettle_price() {
		return settle_price;
	}

	public void setSettle_price(Double settle_price) {
		this.settle_price = settle_price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(Integer stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public Integer getActivity_quantity() {
		return activity_quantity;
	}

	public void setActivity_quantity(Integer activity_quantity) {
		this.activity_quantity = activity_quantity;
	}

}
