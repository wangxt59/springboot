package com.antke.promotion.service;

import java.util.Map;

import com.antke.promotion.model.bean.PromotionGoodsDetail;
import com.antke.website.model.bean.PageInfo;

public interface IPromotionGoodsDetailService {

	/**
	 * 分页查询促销商品明细
	 * 
	 * @param pageInfo
	 * @param filter
	 * @return
	 */
	public PageInfo<PromotionGoodsDetail> queryPromotionGoodsDetailListByPage(
			PageInfo<PromotionGoodsDetail> pageInfo, Map<String, Object> filter);

	/**
	 * 插入促销商品
	 * 
	 * @param PromotionGoods
	 * @return
	 */
	public int insertPromotionGoodsDetail(
			PromotionGoodsDetail promotionGoodsDetail);

	/**
	 * 修改促销商品信息
	 * 
	 * @param PromotionGoods
	 * @return
	 */
	public int updatePromotionGoodsDetail(
			PromotionGoodsDetail promotionGoodsDetail);

	/**
	 * 修改促销商品信息
	 * 
	 * @param PromotionGoods
	 * @return
	 */
	public int updateByPrimaryKeySelective(
			PromotionGoodsDetail promotionGoodsDetail);

	/**
	 * 根据ID获取商品明细信息
	 * 
	 * @param promotion_id
	 * @return
	 */
	public PromotionGoodsDetail getPromotionGoodsDetail(String id);

}
