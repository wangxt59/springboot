package com.antke.promotion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.antke.promotion.model.bean.PromotionGoodsDetail;

/**
 * 商品促销明细
 * 
 * @author 旭
 * 
 */
@Repository
public interface PromotionGoodsDetailDao {

	/**
	 * 插入
	 * 
	 * @param promotionGoodsDetail
	 * @return
	 */
	public int insert(PromotionGoodsDetail promotionGoodsDetail);

	/**
	 * 按null选择性插入
	 * 
	 * @param promotionGoodsDetail
	 * @return
	 */
	public int insertSelective(PromotionGoodsDetail promotionGoodsDetail);

	/**
	 * 根据ID获取
	 * 
	 * @param id
	 * @return
	 */
	public PromotionGoodsDetail get(String id);

	/**
	 * 按条件查询总条数
	 * 
	 * @param filter
	 * @return
	 */
	public int queryPromotionGoodsDetailListCount(Map<String, Object> filter);

	/**
	 * 按条件查询分页显示数据
	 * 
	 * @param rowBounds
	 * @param filter
	 * @return
	 */
	public List<PromotionGoodsDetail> queryPromotionGoodsDetailListByPage(
			RowBounds rowBounds, Map<String, Object> filter);

	/**
	 * 更新
	 * 
	 * @param promotionGoodsDetail
	 * @return
	 */
	public int update(PromotionGoodsDetail promotionGoodsDetail);

	public int updateByPrimaryKeySelective(
			PromotionGoodsDetail promotionGoodsDetail);
}