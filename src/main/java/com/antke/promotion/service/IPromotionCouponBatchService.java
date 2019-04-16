package com.antke.promotion.service;

import java.util.Map;

import com.antke.promotion.model.bean.PromotionCouponBatch;
import com.antke.website.model.bean.PageInfo;

public interface IPromotionCouponBatchService {

	/**
	 * 分页查询优惠券
	 * 
	 * @param pageInfo
	 * @param filter
	 * @return
	 */
	public PageInfo<PromotionCouponBatch> queryPromotionCouponBatchListByPage(
			PageInfo<PromotionCouponBatch> pageInfo, Map<String, Object> filter);

	/**
	 * 插入优惠券
	 * 
	 * @param promotionCoupon
	 * @return
	 */
	public int insertPromotionCouponBatch(PromotionCouponBatch promotionCouponBatch);

	/**
	 * 根据ID获取
	 * @param coupon_batch_id
	 * @return
	 */
	public PromotionCouponBatch getPromotionCouponBatch(
			String coupon_batch_id);

	/**
	 * 修改
	 * @param promotionCouponBatch
	 * @return
	 */
	public int updatePromotionCouponBatch(
			PromotionCouponBatch promotionCouponBatch);

}
