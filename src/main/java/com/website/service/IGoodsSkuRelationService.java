package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.GoodsSkuRelation;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IGoodsSkuRelationService {

	public int insertGoodsRelationSkuInfo(GoodsSkuRelation goodsSkuRelation);
	
	public List<Map> getGoodsAttrList(Map map);
	
	public List<Map> getAttrValueList(Map map);
	
	public List<Map> getSkuValueList(Map map);
	
	public int deleteGoodsSkuRelationByGoodsId(int goods_id);
	 
	public List<Map> querySkuGoodsByAttrId(String attrId);
}
