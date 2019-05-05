/**
 * 
 */
package com.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.GoodsSku;
import com.website.bean.PageInfo;
import com.website.dao.GoodsSkuMapper;
import com.website.service.IGoodsSkuService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class GoodsSkuServiceImpl implements IGoodsSkuService {
	private final static Log log = LogFactory.getLog(GoodsSkuServiceImpl.class);
	@Autowired
	public GoodsSkuMapper goodsSkuMapper;
	
	@Override
	public int updateByPrimaryKeySelective(GoodsSku goodsSku) {
		return  goodsSkuMapper.updateByPrimaryKeySelective(goodsSku);
	}
	
	@Override
	public int insertGoodsSkuInfo(GoodsSku goodsSku) {
		return  goodsSkuMapper.insertSelective(goodsSku);
	}

	@Override
	public List getGoodsAttrList(Map map) {
		return goodsSkuMapper.getGoodsAttrList(map);
	}
	
	@Override
	public int updateSkuGoodStock(GoodsSku goodsSku) {
		return goodsSkuMapper.updateSkuGoodStock(goodsSku);
	}
	
	@Override
	public PageInfo<Map> qyById(PageInfo<Map> pageInfo, Integer goodsId) {
		List<Map<String, Object>> goodsSkusize = goodsSkuMapper.qyById(goodsId);
		int count=goodsSkusize.size();
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(),pageInfo.getPageSize());
		List goodsSkuList = goodsSkuMapper.qyById(rowBounds,goodsId);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), count,goodsSkuList);
		return pageInfo;
		
		
//		return goodsSkuMapper.qyById(goodsId);
	}
	@Override
	public List<Map<String, Object>> qyById(Integer goodsId) {
		return goodsSkuMapper.qyById(goodsId);
	}
	public int deleteGoodsSkuByGoodsId(int goods_id) {
		return  goodsSkuMapper.deleteGoodsSkuByGoodsId(goods_id);
	}

	@Override
	public int insertMap(GoodsSku record) {
		// TODO Auto-generated method stub
		return goodsSkuMapper.insertSelective(record);
	}
	@Override
	public List<GoodsSku> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return goodsSkuMapper.selectByMap(map);
	}
}
