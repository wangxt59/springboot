package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.GoodsLabel;

public interface GoodsLabelMapper {
    int insert(GoodsLabel record);

    int insertSelective(GoodsLabel record);

    GoodsLabel selectByPrimaryKey(Integer labelId);
    List<GoodsLabel> selectByMap(Map map);
    

    int updateByPrimaryKeySelective(GoodsLabel record);

    int updateByPrimaryKey(GoodsLabel record);
}