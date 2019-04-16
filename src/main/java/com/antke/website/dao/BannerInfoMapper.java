package com.antke.website.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.antke.website.model.bean.BannerInfo;

public interface BannerInfoMapper {
    int insert(BannerInfo record);

    int insertSelective(BannerInfo record);

    BannerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BannerInfo record);

    int updateByPrimaryKey(BannerInfo record);
    
    public int queryBannerListCount(Map map);
	
	public List<BannerInfo> queryBannerListByPages(RowBounds rowBounds, Map map);
	
	public BannerInfo qyById(Map map);
}