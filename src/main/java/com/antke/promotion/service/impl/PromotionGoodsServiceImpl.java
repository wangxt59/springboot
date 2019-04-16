package com.antke.promotion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.promotion.dao.PromotionGoodsDao;
import com.antke.promotion.model.bean.PromotionGoods;
import com.antke.promotion.service.IPromotionGoodsService;
import com.antke.website.model.bean.PageInfo;

@Service
public class PromotionGoodsServiceImpl implements IPromotionGoodsService {

	@Autowired
	private PromotionGoodsDao promotionGoodsDao;

	public PageInfo<PromotionGoods> queryPromotionGoodsListByPage(
			PageInfo<PromotionGoods> pageInfo, Map<String, Object> filter) {
		// 根据查询条件获取该查询条件下的总条数
		int totalRecord = promotionGoodsDao
				.queryPromotionGoodsListCount(filter);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),
				pageInfo.getPageSize());
		// 根据查询条件获取查询数据
		List<PromotionGoods> datas = promotionGoodsDao
				.queryPromotionGoodsListByPage(rowBounds, filter);
		List<PromotionGoods> _datas = new ArrayList<PromotionGoods>();

		for (PromotionGoods promotionGoods : datas) {
			_datas.add(promotionGoods);
		}
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord,
				_datas);
		return pageInfo;
	}

	public int insertPromotionGoods(PromotionGoods promotionGoods) {
		return promotionGoodsDao.insertSelective(promotionGoods);
	}

	public int updatePromotionGoods(PromotionGoods promotionGoods) {
		return promotionGoodsDao.update(promotionGoods);
	}
	
	/**
	 * 选择性更新数据
	 * @param promotionGoods
	 * @return
	 */
	public int updateByPrimaryKeySelective(PromotionGoods promotionGoods) {
		return promotionGoodsDao.updateByPrimaryKeySelective(promotionGoods);
	}

	public PromotionGoods getPromotionGoods(String id) {

		return promotionGoodsDao.get(id);
	}
}
