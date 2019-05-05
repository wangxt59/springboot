/**
 * 
 */
package com.website.service.impl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.GoodsRelation;
import com.website.dao.GoodsRelationMapper;
import com.website.service.IGoodsRelationService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class GoodsRelationServiceImpl implements IGoodsRelationService {

	private final static Log log = LogFactory.getLog(GoodsRelationServiceImpl.class);
	@Autowired
	public GoodsRelationMapper goodsRelationMapper;
	
	public int insertGoodsRelation(GoodsRelation goodsRelation) {
		return  goodsRelationMapper.insertSelective(goodsRelation);
	}
	
	public int deleteGoodsRelationByGoodsId(int goodsId) {
		return  goodsRelationMapper.deleteGoodsRelationByGoodsId(goodsId);
	}
}
