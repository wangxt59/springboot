package com.antke.promotion.service;

import java.util.Map;

import com.antke.promotion.model.bean.PromotionGoods;
import com.antke.website.model.bean.PageInfo;

public interface IPromotionGoodsService {

	/**
	 * 分页查询优惠券
	 * 
	 * @param pageInfo
	 * @param filter
	 * @return
	 */
	public PageInfo<PromotionGoods> queryPromotionGoodsListByPage(
			PageInfo<PromotionGoods> pageInfo, Map<String, Object> filter);

	/**
	 * 插入商品促销信息
	 * 
	 * @param PromotionGoods
	 * @return
	 */
	public int insertPromotionGoods(PromotionGoods promotionGoods);

	/**
	 * 修改商品促销信息
	 * 
	 * @param PromotionGoods
	 * @return
	 */
	public int updatePromotionGoods(PromotionGoods promotionGoods);
	
	/**
	 * 修改商品促销信息
	 * 
	 * @param PromotionGoods
	 * @return
	 */
	public int updateByPrimaryKeySelective(PromotionGoods promotionGoods);

	/**
	 * 根据ID获取商品促销信息
	 * 
	 * @param promotion_id
	 * @return
	 */
	public PromotionGoods getPromotionGoods(String id);

}
