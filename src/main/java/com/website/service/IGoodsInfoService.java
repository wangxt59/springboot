package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.GoodsInfo;
import com.website.bean.GoodsInfoWithBLOBs;
import com.website.bean.PageInfo;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IGoodsInfoService {

	/**
	 * 查询商品列表
	 * @param map
	 * @return
	 */
	public PageInfo<Map> queryGoodsListByPage(PageInfo<Map> pageInfo,Map map);
	
	public List<Map> queryAllGoodsList(Map map) ;

	public int insertGoodsInfo(GoodsInfo goodsInfo) ;
	
	public Map qyById(Integer goodsId);
	
	public int updateGoodsInfo(GoodsInfo goodsInfo);
	
	public int deleteGoods(int goods_id);

	public List<Map> queryByCode(String goodsCode);

	public Map selectGoodsByCode(Integer valueOf);

	public PageInfo<Map> getGoodsInfoList(PageInfo<Map> pageInfo, Map map);

	public List<GoodsInfoWithBLOBs> selectGoodsListByMap(Map map);
	
	public GoodsInfoWithBLOBs selectGoodsInfoByMap(Map map);
	
	public GoodsInfoWithBLOBs selectByPrimaryKey(Integer id);
}

