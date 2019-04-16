package com.antke.promotion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.antke.promotion.model.bean.PromotionGoods;

/**
 * 商品促销模块
 * 
 * @author 旭
 * 
 */
@Repository
public interface PromotionGoodsDao {

	public int insert(PromotionGoods promotionGoods);

	public int insertSelective(PromotionGoods promotionGoods);

	public PromotionGoods selectByPrimaryKey(String id);

	public int updateByPrimaryKeySelective(PromotionGoods promotionGoods);

	public int update(PromotionGoods promotionGoods);

	public PromotionGoods get(String id);

	public int queryPromotionGoodsListCount(Map<String, Object> filter);

	public List<PromotionGoods> queryPromotionGoodsListByPage(
			RowBounds rowBounds, Map<String, Object> filter);
}