package com.antke.promotion.service;

import java.util.Map;

import com.antke.promotion.model.bean.PromotionCoupon;
import com.antke.website.model.bean.PageInfo;

public interface IPromotionCouponService {

	/**
	 * 分页查询优惠券
	 * 
	 * @param pageInfo
	 * @param filter
	 * @return
	 */
	public PageInfo<PromotionCoupon> queryPromotionCouponListByPage(
			PageInfo<PromotionCoupon> pageInfo, Map<String, Object> filter);

	/**
	 * 插入优惠券
	 * 
	 * @param promotionCoupon
	 * @return
	 */
	public int insertPromotionCoupon(PromotionCoupon promotionCoupon);

	/**
	 * 修改优惠券
	 * 
	 * @param promotionCoupon
	 * @return
	 */
	public int updatePromotionCoupon(PromotionCoupon promotionCoupon);

	/**
	 * 根据ID获取促销信息
	 * 
	 * @param promotion_id
	 * @return
	 */
	public PromotionCoupon getPromotionCoupon(String promotion_id);

}
