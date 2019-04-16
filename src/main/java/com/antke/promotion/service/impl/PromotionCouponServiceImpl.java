package com.antke.promotion.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.promotion.dao.PromotionCouponBatchDao;
import com.antke.promotion.dao.PromotionCouponDao;
import com.antke.promotion.model.bean.PromotionConstants;
import com.antke.promotion.model.bean.PromotionCoupon;
import com.antke.promotion.model.bean.PromotionCouponBatch;
import com.antke.promotion.service.IPromotionCouponService;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.utils.CommonsUtil;

@Service
public class PromotionCouponServiceImpl implements IPromotionCouponService {

	@Autowired
	private PromotionCouponDao promotionCouponDao;
	@Autowired
	private PromotionCouponBatchDao promotionCouponBatchDao;

	/**
	 * 分页查询当前页优惠券的数据
	 */
	public PageInfo<PromotionCoupon> queryPromotionCouponListByPage(
			PageInfo<PromotionCoupon> pageInfo, Map<String, Object> filter) {
		// 根据查询条件获取该查询条件下的总条数
		int totalRecord = promotionCouponDao
				.queryPromotionCouponListCount(filter);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),
				pageInfo.getPageSize());
		// 根据查询条件获取查询数据
		List<PromotionCoupon> datas = promotionCouponDao
				.queryPromotionCouponListByPage(rowBounds, filter);
		List<PromotionCoupon> _datas = new ArrayList<PromotionCoupon>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (PromotionCoupon promotionCoupon : datas) {
			// 查询优惠券的已发、使用、未使用数量
			// 已发
			paramMap.put("user_id", "111");
			paramMap.put("pc_id", promotionCoupon.getId());
			int count = promotionCouponBatchDao.queryPromotionCouponBatchCountByStatus(paramMap);
			promotionCoupon.setSend_quantity(count);
			// 已发已使用
			paramMap.put("status", PromotionConstants.PROMOTION_COUPON_BATCH_STATUS_02);
			int count1 = promotionCouponBatchDao.queryPromotionCouponBatchCountByStatus(paramMap);
			promotionCoupon.setUsed_quantity(count1);
			// 未使用
			paramMap.clear();
			paramMap.put("pc_id", promotionCoupon.getId());
			paramMap.put("status", PromotionConstants.PROMOTION_COUPON_BATCH_STATUS_01);
			int count2 = promotionCouponBatchDao.queryPromotionCouponBatchCountByStatus(paramMap);
			promotionCoupon.setUnused_quantity(count2);
			_datas.add(promotionCoupon);
		}
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord,
				_datas);
		return pageInfo;
	}

	/**
	 * 增加优惠券
	 */
	public int insertPromotionCoupon(PromotionCoupon promotionCoupon) {

		// 判断数量，在优惠券批次表中插入数据
		Integer quantity = promotionCoupon.getQuantity();
		long pc_id = Long.parseLong(promotionCoupon.getId());
		pc_id = pc_id * 1000000;
		for (int i = 0; i < quantity; i++) {
			PromotionCouponBatch promotionCouponBatch = new PromotionCouponBatch();
			promotionCouponBatch.setId(CommonsUtil.getPrimaryKey());
			promotionCouponBatch.setCoupon_code(pc_id + i + "");
			promotionCouponBatch.setPc_id(promotionCoupon.getId());
			promotionCouponBatch
					.setStatus(PromotionConstants.PROMOTION_COUPON_BATCH_STATUS_01);
			promotionCouponBatchDao.insert(promotionCouponBatch);
		}
		return promotionCouponDao.insert(promotionCoupon);
	}

	/**
	 * 修改优惠券信息
	 */
	public int updatePromotionCoupon(PromotionCoupon promotionCoupon) {
		return promotionCouponDao.update(promotionCoupon);
	}

	/**
	 * 根据ID获取促销信息
	 */
	public PromotionCoupon getPromotionCoupon(String promotion_id) {
		return promotionCouponDao.get(promotion_id);
	}
}
