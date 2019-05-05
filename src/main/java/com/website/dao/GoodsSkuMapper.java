package com.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.website.bean.GoodsSku;

public interface GoodsSkuMapper {
    int insert(GoodsSku record);

    int insertSelective(GoodsSku record);

    GoodsSku selectByPrimaryKey(Integer skuId);

    int updateByPrimaryKeySelective(GoodsSku record);

    int updateByPrimaryKey(GoodsSku record);
    
//-------------------------------------------
	public List getGoodsAttrList(Map map);
	
	public int updateSkuGoodStock(GoodsSku goodsSku);
	
	public List<Map<String, Object>> qyById(RowBounds rowBounds,Integer goodsId);
	public List<Map<String, Object>> qyById(Integer goodsId);
	
	public int deleteGoodsSkuByGoodsId(int goods_id);

	int insertMap(GoodsSku record);
	
	public List<GoodsSku> selectByMap(Map map);
}