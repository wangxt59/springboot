package com.website.dao;

import com.website.bean.PlatTeamGoods;

public interface PlatTeamGoodsMapper {
    int insert(PlatTeamGoods record);

    int insertSelective(PlatTeamGoods record);
    int newPlatTeamDetails(PlatTeamGoods record);
}