package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.RecommendGoods;

public interface RecommendGoodsMapper {
    int insert(RecommendGoods record);

    int insertSelective(RecommendGoods record);

    RecommendGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendGoods record);

    int updateByPrimaryKey(RecommendGoods record);
    
    public List getRecommendGoodsListById(Map map);
    
    public int deleteRecommendGoodsByGoodsId(int goods_id);
}