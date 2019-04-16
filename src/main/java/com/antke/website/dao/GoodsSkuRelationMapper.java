package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.GoodsSkuRelation;

public interface GoodsSkuRelationMapper {
    int insert(GoodsSkuRelation record);

    int insertSelective(GoodsSkuRelation record);

    GoodsSkuRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsSkuRelation record);

    int updateByPrimaryKey(GoodsSkuRelation record);
    
    public List getGoodsAttrList(Map map);
    
    public List getAttrValueList(Map map);
    
    public List getSkuValueList(Map map);
    
    public int deleteGoodsSkuRelationByGoodsId(int goods_id);
    
    public List querySkuGoodsByAttrId(String attrId);
}