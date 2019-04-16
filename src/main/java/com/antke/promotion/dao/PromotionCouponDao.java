package com.antke.promotion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.antke.promotion.model.bean.PromotionCoupon;

@Repository
public interface PromotionCouponDao {

	/**
	 * 新增优惠券信息
	 * 
	 * @param goods
	 * @return
	 */
	public int insert(PromotionCoupon promotionCoupon);

	/**
	 * 更新优惠券信息
	 * 
	 * @param goods
	 * @return
	 */
	public int update(PromotionCoupon promotionCoupon);

	/**
	 * 根据id获取优惠券信息
	 * 
	 * @param map
	 * @return
	 */
	public PromotionCoupon get(String id);

	public int queryPromotionCouponListCount(Map<String, Object> filter);

	public List<PromotionCoupon> queryPromotionCouponListByPage(
			RowBounds rowBounds, Map<String, Object> filter);
}
