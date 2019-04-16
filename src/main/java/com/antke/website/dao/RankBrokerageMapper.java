package com.antke.website.dao;

import com.antke.website.model.bean.RankBrokerage;

public interface RankBrokerageMapper {
    int insert(RankBrokerage record);

    int insertSelective(RankBrokerage record);

    RankBrokerage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RankBrokerage record);

    int updateByPrimaryKey(RankBrokerage record);
    
    public RankBrokerage getBrokerageByRank(int rank);
}