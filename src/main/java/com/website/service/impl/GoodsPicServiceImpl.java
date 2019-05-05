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

import com.website.bean.GoodsPic;
import com.website.dao.GoodsPicMapper;
import com.website.service.IGoodsPicService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class GoodsPicServiceImpl implements IGoodsPicService {
	private final static Log log = LogFactory.getLog(GoodsPicServiceImpl.class);
	@Autowired
	public GoodsPicMapper goodsPicMapper;
 
	@Override
	public int insertGoodsPic(GoodsPic goodsPic) {
		return  goodsPicMapper.insertSelective(goodsPic);
	}

	@Override
	public List queryPics(Map map) {
		return goodsPicMapper.queryPics(map);
	}
	
	public int deleteGoodsPicByGoodsId(int goods_id) {
		return  goodsPicMapper.deleteGoodsPicByGoodsId(goods_id);
	}

	@Override
	public Map queryPicsByGoodId(Integer goods_id) {
		return goodsPicMapper.queryPicsByGoodId(goods_id);
	}
}
