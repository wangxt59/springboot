package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.antke.website.model.bean.CardInfo;

public interface CardInfoMapper {
    int insert(CardInfo record);

    int insertSelective(CardInfo record);

    CardInfo selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(CardInfo record);

    int updateByPrimaryKey(CardInfo record);
    
    public int queryCardListCount(Map map);
	
  	public List queryCardListByPages(RowBounds rowBounds, Map map);
  	
  	 int deleteCard(int card_id);
}