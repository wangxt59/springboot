package com.antke.promotion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.antke.promotion.model.bean.PromotionCouponBatch;

@Repository
public interface PromotionCouponBatchDao {

	/**
	 * 新增优惠券批次信息
	 * 
	 * @param goods
	 * @return
	 */
	public int insert(PromotionCouponBatch promotionCouponBatch);

	/**
	 * 更新优惠券批次信息
	 * 
	 * @param goods
	 * @return
	 */
	public int update(PromotionCouponBatch promotionCouponBatch);

	/**
	 * 查询优惠券批次信息
	 * 
	 * @param map
	 * @return
	 */
	public PromotionCouponBatch get(String coupon_batch_id);

	/**
	 * 分页按条件查询总条数
	 * 
	 * @param filter
	 * @return
	 */
	public int queryPromotionCouponBatchListCount(Map<String, Object> filter);

	/**
	 * 分页按条件查询数据
	 * 
	 * @param rowBounds
	 * @param filter
	 * @return
	 */
	public List<PromotionCouponBatch> queryPromotionCouponBatchListByPage(
			RowBounds rowBounds, Map<String, Object> filter);

	public int queryPromotionCouponBatchCountByStatus(Map<String, Object> filter);

}
