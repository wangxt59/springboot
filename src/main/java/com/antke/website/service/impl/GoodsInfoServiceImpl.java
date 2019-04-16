/**
 * 
 */
package com.antke.website.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antke.website.dao.GoodsInfoMapper;
import com.antke.website.model.bean.BannerInfo;
import com.antke.website.model.bean.GoodsInfo;
import com.antke.website.model.bean.GoodsInfoWithBLOBs;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.service.IGoodsInfoService;

/**
 * 描述:
 * 
 * @Company: 博众援创
 * @author shengtaihua
 * @date 2018-10-11
 */
@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService {
	private final static Log log = LogFactory.getLog(GoodsInfoServiceImpl.class);
	@Autowired
	public GoodsInfoMapper goodsInfoMapper;
	
	//查询商品列表
	@Override
	public PageInfo<Map> queryGoodsListByPage(PageInfo<Map> pageInfo, Map map) {
		int totalRecord = goodsInfoMapper.queryGoodsListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<Map> datas = goodsInfoMapper.queryGoodsListByPage(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, datas);
		return pageInfo;
	}
	
	public List<Map> queryAllGoodsList(Map map) {
		List<Map> datas = goodsInfoMapper.queryAllGoodsList(map);
		return datas;
	}
	
	public int insertGoodsInfo(GoodsInfo goodsInfo) {
		return  goodsInfoMapper.insertSelective(goodsInfo);
	}
	
	@Override
	public Map qyById(Integer goodsId) {
		return goodsInfoMapper.qyById(goodsId);
	}
	
	@Override
	public int updateGoodsInfo(GoodsInfo goodsInfo) {
		return goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
	}
	
	public int deleteGoods(int goodsId) {
		return  goodsInfoMapper.deleteGoods(goodsId);
	}

	@Override
	public List<Map> queryByCode(String goodsCode) {
		return goodsInfoMapper.queryByCode(goodsCode);
	}

	@Override
	public PageInfo<Map> getGoodsInfoList(PageInfo<Map> pageInfo, Map map) {
		int totalRecord = goodsInfoMapper.getGoodsInfoListCount(map);
		RowBounds rowBounds = new RowBounds(pageInfo.getStartRow(), pageInfo.getPageSize());
		List<Map> datas = goodsInfoMapper.getGoodsInfoList(rowBounds, map);
		pageInfo.init(String.valueOf(pageInfo.getCurrentPage()), totalRecord, datas);
		return pageInfo;
	}

	@Override
	public List<GoodsInfoWithBLOBs> selectGoodsListByMap(Map map) {
		return goodsInfoMapper.selectGoodsListByMap(map);
	}

	@Override
	public GoodsInfoWithBLOBs selectGoodsInfoByMap(Map map) {
		return goodsInfoMapper.selectGoodsInfoByMap(map);
	}
	
	@Override
	public GoodsInfoWithBLOBs selectByPrimaryKey(Integer id) {
		return goodsInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map selectGoodsByCode(Integer valueOf) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
