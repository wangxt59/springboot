package com.antke.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.promotion.dao.PromotionGoodsDao;
import com.antke.promotion.dao.PromotionGoodsDetailDao;
import com.antke.promotion.model.bean.PromotionGoods;
import com.antke.promotion.model.bean.PromotionGoodsDetail;
import com.antke.promotion.service.IPromotionGoodsDetailService;
import com.antke.promotion.service.IPromotionGoodsService;
import com.antke.website.model.bean.PageInfo;

@Service
public class PromotionGoodsDetailServiceImpl implements
		IPromotionGoodsDetailService {

	@Autowired
	private PromotionGoodsDetailDao promotionGoodsDetailDao;

	public PageInfo<PromotionGoodsDetail> queryPromotionGoodsDetailListByPage(
			PageInfo<PromotionGoodsDetail> pageInfo, Map<String, Object> filter) {
		// 根据查询条件获取该查询条件下的总条数
		int totalRecord = promotionGoodsDetailDao
				.queryPromotionGoodsDetailListCount(filter);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),
				pageInfo.getPageSize());
		// 根据查询条件获取查询数据
		List<PromotionGoodsDetail> datas = promotionGoodsDetailDao
				.queryPromotionGoodsDetailListByPage(rowBounds, filter);
		List<PromotionGoodsDetail> _datas = new ArrayList<PromotionGoodsDetail>();

		for (PromotionGoodsDetail promotionGoodsDetail : datas) {
			_datas.add(promotionGoodsDetail);
		}
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord,
				_datas);
		return pageInfo;
	}

	public int insertPromotionGoodsDetail(
			PromotionGoodsDetail PromotionGoodsDetail) {
		return promotionGoodsDetailDao.insertSelective(PromotionGoodsDetail);
	}

	public int updatePromotionGoodsDetail(
			PromotionGoodsDetail PromotionGoodsDetail) {
		return promotionGoodsDetailDao.update(PromotionGoodsDetail);
	}

	/**
	 * 选择性更新数据
	 * 
	 * @param PromotionGoodsDetail
	 * @return
	 */
	public int updateByPrimaryKeySelective(
			PromotionGoodsDetail PromotionGoodsDetail) {
		return promotionGoodsDetailDao
				.updateByPrimaryKeySelective(PromotionGoodsDetail);
	}

	public PromotionGoodsDetail getPromotionGoodsDetail(String id) {

		return promotionGoodsDetailDao.get(id);
	}

}
