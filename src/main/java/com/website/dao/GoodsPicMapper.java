package com.website.dao;

import java.util.List;
import java.util.Map;

import com.website.bean.GoodsPic;

public interface GoodsPicMapper {
    int insert(GoodsPic record);

    int insertSelective(GoodsPic record);

    GoodsPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsPic record);

    int updateByPrimaryKey(GoodsPic record);
    
	List queryPics(Map map);
		
	Map queryPicsByGoodId(Integer goods_id);
	
	public int deleteGoodsPicByGoodsId(int goods_id);
}