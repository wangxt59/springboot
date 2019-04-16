package com.antke.website.service;

import java.util.List;
import java.util.Map;

import com.antke.website.model.bean.GoodsLabel;

public interface IGoodsLabelServise {
	int insertSelective(GoodsLabel goodsLabel);
	GoodsLabel selectByPrimaryKey(Integer goodsLabel);
	int updateByPrimaryKeySelective(GoodsLabel goodsLabel);
	List<GoodsLabel> selectByMap(Map map);
}
