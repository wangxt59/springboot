package com.website.service;

import com.website.bean.GoodsRelation;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IGoodsRelationService {

	public int insertGoodsRelation(GoodsRelation goodsRelation);
	
	public int deleteGoodsRelationByGoodsId(int goods_id);
}
