/**
 * 
 */
package com.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.RecommendGoods;
import com.website.dao.RecommendGoodsMapper;
import com.website.service.IRecommendGoodsService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class RecommendGoodsServiceImpl implements IRecommendGoodsService {

	private final static Log log = LogFactory.getLog(RecommendGoods.class);
	@Autowired
	public RecommendGoodsMapper recommendGoodsMapper;
	
	public int insertGoodsRelation(RecommendGoods recommendGoods) {
		return  recommendGoodsMapper.insertSelective(recommendGoods);
	}
	
	@Override
	public List<Map> getRecommendGoodsListById(Map map) {
		return recommendGoodsMapper.getRecommendGoodsListById(map);
	}
	
	public int deleteRecommendGoodsByGoodsId(int goods_id) {
		return  recommendGoodsMapper.deleteRecommendGoodsByGoodsId(goods_id);
	}
}
