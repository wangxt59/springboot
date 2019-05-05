package com.website.dao;

import com.website.bean.RankBrokerage;

public interface RankBrokerageMapper {
    int insert(RankBrokerage record);

    int insertSelective(RankBrokerage record);

    RankBrokerage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RankBrokerage record);

    int updateByPrimaryKey(RankBrokerage record);
    
    public RankBrokerage getBrokerageByRank(int rank);
}