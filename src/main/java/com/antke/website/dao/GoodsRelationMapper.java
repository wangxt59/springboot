package com.antke.website.dao;

import com.antke.website.model.bean.GoodsRelation;

public interface GoodsRelationMapper {
    int insert(GoodsRelation record);

    int insertSelective(GoodsRelation record);

    GoodsRelation selectByPrimaryKey(Integer relationId);

    int updateByPrimaryKeySelective(GoodsRelation record);

    int updateByPrimaryKey(GoodsRelation record);
 
    int deleteGoodsRelationByGoodsId(int goodsId);
}