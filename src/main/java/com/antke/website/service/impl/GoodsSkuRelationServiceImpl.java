/**
 * 
 */
package com.antke.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.GoodsSkuRelationMapper;
import com.antke.website.model.bean.GoodsSkuRelation;
import com.antke.website.service.IGoodsSkuRelationService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class GoodsSkuRelationServiceImpl implements IGoodsSkuRelationService {
	private final static Log log = LogFactory.getLog(GoodsSkuRelationServiceImpl.class);
	@Autowired
	public GoodsSkuRelationMapper goodsSkuRelationMapper;
	
	public int insertGoodsRelationSkuInfo(GoodsSkuRelation goodsSkuRelation) {
		return  goodsSkuRelationMapper.insertSelective(goodsSkuRelation);
	}
	
	@Override
	public List<Map> getGoodsAttrList(Map map) {
		return goodsSkuRelationMapper.getGoodsAttrList(map);
	}
	
	@Override
	public List<Map> getAttrValueList(Map map) {
		return goodsSkuRelationMapper.getAttrValueList(map);
	}
	
	@Override
	public List<Map> getSkuValueList(Map map) {
		return goodsSkuRelationMapper.getSkuValueList(map);
	}
	
	public int deleteGoodsSkuRelationByGoodsId(int goods_id) {
		return  goodsSkuRelationMapper.deleteGoodsSkuRelationByGoodsId(goods_id);
	}
	
	
	@Override
	public List<Map> querySkuGoodsByAttrId(String attrId) {
		return goodsSkuRelationMapper.querySkuGoodsByAttrId(attrId);
	}
}
