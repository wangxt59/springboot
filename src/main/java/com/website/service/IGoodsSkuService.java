package com.website.service;

import java.util.List;
import java.util.Map;

import com.website.bean.GoodsSku;
import com.website.bean.PageInfo;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
public interface IGoodsSkuService {

	public int insertGoodsSkuInfo(GoodsSku goodsSku);
	
	/**
	 *查询商品的属性
	 * @param map
	 * @return
	 */
	public List getGoodsAttrList(Map map);
	
	
	//修改库存
	public int updateSkuGoodStock(GoodsSku goodsSku);
	public PageInfo<Map> qyById(PageInfo<Map> pageInfo, Integer goodsId);
	public List<Map<String,Object>> qyById(Integer goodsId);
//	public List<Map<String, Object>> qyById(Integer goodsId);
	
	public int deleteGoodsSkuByGoodsId(int goods_id);
	public int insertMap(GoodsSku record);

	List<GoodsSku> selectByMap(Map map);

	int updateByPrimaryKeySelective(GoodsSku goodsSku);

}
