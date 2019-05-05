package com.website.dao;

import com.website.bean.GoodsRelation;

public interface GoodsRelationMapper {
    int insert(GoodsRelation record);

    int insertSelective(GoodsRelation record);

    GoodsRelation selectByPrimaryKey(Integer relationId);

    int updateByPrimaryKeySelective(GoodsRelation record);

    int updateByPrimaryKey(GoodsRelation record);
 
    int deleteGoodsRelationByGoodsId(int goodsId);
}