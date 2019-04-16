package com.antke.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.promotion.dao.PromotionCouponBatchDao;
import com.antke.promotion.model.bean.PromotionCouponBatch;
import com.antke.promotion.service.IPromotionCouponBatchService;
import com.antke.website.model.bean.PageInfo;

@Service
public class PromotionCouponBatchServiceImpl implements
		IPromotionCouponBatchService {

	@Autowired
	private PromotionCouponBatchDao promotionCouponBatchDao;

	public PageInfo<PromotionCouponBatch> queryPromotionCouponBatchListByPage(
			PageInfo<PromotionCouponBatch> pageInfo, Map<String, Object> filter) {
		// 根据查询条件获取该查询条件下的总条数
		int totalRecord = promotionCouponBatchDao
				.queryPromotionCouponBatchListCount(filter);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),
				pageInfo.getPageSize());
		// 根据查询条件获取查询数据
		List<PromotionCouponBatch> datas = promotionCouponBatchDao
				.queryPromotionCouponBatchListByPage(rowBounds, filter);
		List<PromotionCouponBatch> _datas = new ArrayList<PromotionCouponBatch>();
		for (PromotionCouponBatch promotionCouponBatch : datas) {
			_datas.add(promotionCouponBatch);
		}
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord,
				_datas);
		return pageInfo;
	}

	public int insertPromotionCouponBatch(
			PromotionCouponBatch promotionCouponBatch) {
		return promotionCouponBatchDao.insert(promotionCouponBatch);
	}

	/**
	 * 根据ID获取
	 */
	public PromotionCouponBatch getPromotionCouponBatch(String coupon_batch_id) {
		return promotionCouponBatchDao.get(coupon_batch_id);
	}

	/**
	 * 修改
	 */
	public int updatePromotionCouponBatch(
			PromotionCouponBatch promotionCouponBatch) {
		return promotionCouponBatchDao.update(promotionCouponBatch);
	}

}
