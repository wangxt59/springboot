package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.RecommendGoods;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IRecommendGoodsService {

	public int insertGoodsRelation(RecommendGoods recommendGoods);
	
	public List<Map> getRecommendGoodsListById(Map map);
	
	public int deleteRecommendGoodsByGoodsId(int goods_id);
}
