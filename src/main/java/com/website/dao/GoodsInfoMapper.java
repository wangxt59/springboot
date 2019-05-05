package com.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.website.bean.GoodsInfo;
import com.website.bean.GoodsInfoWithBLOBs;

public interface GoodsInfoMapper {
    int insert(GoodsInfoWithBLOBs record);

    int insertSelective(GoodsInfoWithBLOBs record);

    GoodsInfoWithBLOBs selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(GoodsInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsInfoWithBLOBs record);

    int updateByPrimaryKey(GoodsInfo record);
    
    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);


    int updateByPrimaryKeySelective(GoodsInfo record);

	public int queryGoodsListCount(Map map);
	
	public List queryGoodsListByPage(RowBounds rowBounds, Map map);
	
	public List queryAllGoodsList(Map map);
	
	public Map qyById(Integer goodsId);
	
	int deleteGoods(int goodsId);

	List queryByCode(String goodsCode);

	int getGoodsInfoListCount(Map map);

	List<Map> getGoodsInfoList(RowBounds rowBounds, Map map);
	
	public List<GoodsInfoWithBLOBs> selectGoodsListByMap(Map map);
	
	public GoodsInfoWithBLOBs selectGoodsInfoByMap(Map map);
	public GoodsInfoWithBLOBs selectByPrimaryKey(Map map);
	
}