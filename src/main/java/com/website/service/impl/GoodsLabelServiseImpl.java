package com.website.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.GoodsLabel;
import com.website.dao.GoodsLabelMapper;
import com.website.service.IGoodsLabelServise;
@Service
public class GoodsLabelServiseImpl implements IGoodsLabelServise{
	@Autowired
	private GoodsLabelMapper goodsLabelMapper;
	@Override
	public int insertSelective(GoodsLabel goodsLabel) {
		return goodsLabelMapper.insertSelective(goodsLabel);
	}
	@Override
	public GoodsLabel selectByPrimaryKey(Integer goodsLabel) {
		// TODO Auto-generated method stub
		return goodsLabelMapper.selectByPrimaryKey(goodsLabel);
	}
	@Override
	public List<GoodsLabel> selectByMap(Map map) {
		// TODO Auto-generated method stub
		return goodsLabelMapper.selectByMap(map);
	}
	@Override
	public int updateByPrimaryKeySelective(GoodsLabel goodsLabel) {
		// TODO Auto-generated method stub
		return goodsLabelMapper.updateByPrimaryKeySelective(goodsLabel);
	}
}
