package com.antke.website.dao;

import com.antke.website.model.bean.PlatTeamGoods;

public interface PlatTeamGoodsMapper {
    int insert(PlatTeamGoods record);

    int insertSelective(PlatTeamGoods record);
    int newPlatTeamDetails(PlatTeamGoods record);
}