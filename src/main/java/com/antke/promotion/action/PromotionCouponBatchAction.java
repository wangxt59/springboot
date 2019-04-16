package com.antke.promotion.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.antke.promotion.model.bean.PromotionConstants;
import com.antke.promotion.model.bean.PromotionCouponBatch;
import com.antke.promotion.service.IPromotionCouponBatchService;
import com.antke.website.action.BaseAction;
import com.antke.website.model.bean.PageInfo;

@Controller
@Scope("prototype")
public class PromotionCouponBatchAction extends BaseAction {

	private static final long serialVersionUID = -4482062977952297177L;
	/**
	 * 生成日志对象
	 */
	private static Logger log = Logger
			.getLogger(PromotionCouponBatchAction.class);

	@Autowired
	private IPromotionCouponBatchService promotionCouponBatchService;

	private PromotionCouponBatch promotionCouponBatch;

	private PageInfo<PromotionCouponBatch> pageInfo;// 显示分页列表
	private String promotion_id; // 促销ID
	private String coupon_batch_id;

	/**
	 * 优惠券批次表促销
	 * 
	 * @return
	 */
	public String selectPromotionCouponBatchList() {

		log.info("优惠券批次信息列表查询，start");
		// 如果是初次访问或新的查询时，重置分页
		if (pageInfo == null || pageInfo.getCurrentPage() == 0) {
			pageInfo = new PageInfo<PromotionCouponBatch>();
			pageInfo.setCurrentPage("1");
		}
		// 查询优惠券信息
		Map<String, Object> filter = new HashMap<String, Object>();
		if (promotionCouponBatch != null) {
			filter.put("id", promotionCouponBatch.getId().trim());
			filter.put("pc_id", promotion_id);
			filter.put("status", promotionCouponBatch.getStatus());
		} else {
			promotionCouponBatch = new PromotionCouponBatch();
			filter.put("pc_id", promotion_id);
		}
		pageInfo = promotionCouponBatchService
				.queryPromotionCouponBatchListByPage(pageInfo, filter);
		return "success";
	}

	/**
	 * 优惠券批次表促销
	 * 
	 * @return
	 */
	public String updatePromotionCouponBatch() {

		PromotionCouponBatch promotionCouponBatch = promotionCouponBatchService
				.getPromotionCouponBatch(coupon_batch_id);
		promotionCouponBatch
				.setStatus(PromotionConstants.PROMOTION_COUPON_BATCH_STATUS_03);
		int count = promotionCouponBatchService
				.updatePromotionCouponBatch(promotionCouponBatch);
		if (count > 0) {
			return "success";
		} else {
			return "failed";
		}
	}

	public PromotionCouponBatch getPromotionCouponBatch() {
		return promotionCouponBatch;
	}

	public void setPromotionCouponBatch(
			PromotionCouponBatch promotionCouponBatch) {
		this.promotionCouponBatch = promotionCouponBatch;
	}

	public PageInfo<PromotionCouponBatch> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<PromotionCouponBatch> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(String promotion_id) {
		this.promotion_id = promotion_id;
	}

	public String getCoupon_batch_id() {
		return coupon_batch_id;
	}

	public void setCoupon_batch_id(String coupon_batch_id) {
		this.coupon_batch_id = coupon_batch_id;
	}

}
